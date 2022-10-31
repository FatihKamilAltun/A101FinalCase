package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HepsiBuradaPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Set;

import static org.testng.Assert.*;

public class Test01 {
    Actions actions = new Actions(Driver.getDriver());
    HepsiBuradaPage hepsiBuradaPage = new HepsiBuradaPage();
    SoftAssert softAssert=new SoftAssert();


    @Test
    public void test01() throws InterruptedException {

        // Kullanıcı "Hepsiburada.com" sitesini ziyaret eder.
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));

        // Kullanıcı cookie'leri kabul eder
        hepsiBuradaPage.acceptCookiesButton.click();

        // Kullanıcı giriş işlemi yapılır.
        actions.moveToElement(hepsiBuradaPage.logInOrSignInButton).perform();
        hepsiBuradaPage.popUpLogInButton.click();
        hepsiBuradaPage.emailOrPhoneNumberBox.sendKeys(ConfigReader.getProperty("userMail"));
        hepsiBuradaPage.emailLogInButton.click();
        hepsiBuradaPage.passwordBox.sendKeys(ConfigReader.getProperty("userPassword"));
        hepsiBuradaPage.passwordLogInButton.click();

        // Yönlendirmeden sonra anasayfada kullanıcı giriş işleminin yapıldığı doğrulanır
        assert hepsiBuradaPage.successLogInText.isDisplayed();

        // Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.
        hepsiBuradaPage.searchBox.sendKeys(ConfigReader.getProperty("productToSearch1"), Keys.ENTER);

        // Kullanıcı, ileride lazım olabileceğinden bulunduğu sayfanın "windowhandle" değerini alır.
        String firstTabWindowHandleHashCode = Driver.getDriver().getWindowHandle();
        Thread.sleep(500);

        // Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(500);
        hepsiBuradaPage.firstProduct.click();
        Thread.sleep(500);

        // Kullanıcı, seçtiği ürünün yeni bir sekmede açıldığını görür. Bu nedenle driver'ını yeni açılan sekmede işlem yapabilmesi için aşağıdaki işlemlerle yeni sekmeye gönderir
        Set<String> windowHandleseti= Driver.getDriver().getWindowHandles();
        System.out.println(windowHandleseti);
        String secondTabWindowHandleHashCode="";
        for (String each: windowHandleseti) {
            if (!each.equals(firstTabWindowHandleHashCode)){
                secondTabWindowHandleHashCode=each;
            }
        }
        Driver.getDriver().switchTo().window(secondTabWindowHandleHashCode);

        // Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
        String firstProductName=hepsiBuradaPage.firstProductName.getText();
        System.out.println(firstProductName);
        hepsiBuradaPage.addToCartButton.click();
        hepsiBuradaPage.popUpXButton.click();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(500);
        hepsiBuradaPage.otherSellerAddToCartButton.click();

        // Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.
        hepsiBuradaPage.popUpViewCartButton.click();
        softAssert.assertTrue(hepsiBuradaPage.cartPageText.isDisplayed());

        System.out.println("First seller is : " + hepsiBuradaPage.firstSeller.getText());
        System.out.println("Second seller is : " + hepsiBuradaPage.secondSeller.getText());
        System.out.println("name : " + hepsiBuradaPage.firstProductName.getText());

        System.out.println(hepsiBuradaPage.firstProductInfoBox.getText());
        softAssert.assertTrue(hepsiBuradaPage.firstProductInfoBox.getText().contains(hepsiBuradaPage.firstSeller.getText()));
        softAssert.assertTrue(hepsiBuradaPage.firstProductInfoBox.getText().contains(firstProductName));

        System.out.println(hepsiBuradaPage.secondProductInfoBox.getText());
        softAssert.assertTrue(hepsiBuradaPage.secondProductInfoBox.getText().contains(hepsiBuradaPage.secondSeller.getText()));
        softAssert.assertTrue(hepsiBuradaPage.secondProductInfoBox.getText().contains(firstProductName));



    }
}
