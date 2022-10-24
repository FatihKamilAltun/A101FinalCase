package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Set;

public class Test01 {
    Actions actions = new Actions(Driver.getDriver());
    HepsiBuradaPage hepsiBuradaPage = new HepsiBuradaPage();


    @Test
    public void test01() throws InterruptedException {

        // Kullanıcı "Hepsiburada.com" sitesini ziyaret eder.
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));

        hepsiBuradaPage.acceptCookiesButton.click();
        actions.moveToElement(hepsiBuradaPage.logInOrSignInButton).perform();
        hepsiBuradaPage.popUpLogInButton.click();
        hepsiBuradaPage.emailOrPhoneNumberBox.sendKeys(ConfigReader.getProperty("userMail"));
        hepsiBuradaPage.emailLogInButton.click();
        hepsiBuradaPage.passwordBox.sendKeys(ConfigReader.getProperty("userPassword"));
        hepsiBuradaPage.passwordLogInButton.click();
        assert hepsiBuradaPage.successLogInText.isDisplayed();
        hepsiBuradaPage.searchBox.sendKeys(ConfigReader.getProperty("productToSearch"), Keys.ENTER);
        String firstTabWindowHandleHashCode = Driver.getDriver().getWindowHandle();
        Thread.sleep(500);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(500);
        hepsiBuradaPage.firstProduct.click();
        Thread.sleep(500);

        Set<String> windowHandleseti= Driver.getDriver().getWindowHandles();
        System.out.println(windowHandleseti);
        String secondTabWindowHandleHashCode="";
        for (String each: windowHandleseti) {
            if (!each.equals(firstTabWindowHandleHashCode)){
                secondTabWindowHandleHashCode=each;
            }
        }

        Driver.getDriver().switchTo().window(secondTabWindowHandleHashCode);
        hepsiBuradaPage.addToCartButton.click();
















        // hepsiBuradaPage.addToCartButton.click();
        /*Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(500);
        hepsiBuradaPage.googleIleGirisYapButonu.click();
        hepsiBuradaPage.emailBox.sendKeys(ConfigReader.getProperty("userMail"));
        hepsiBuradaPage.ileriButonu.click();*/


    }
}
