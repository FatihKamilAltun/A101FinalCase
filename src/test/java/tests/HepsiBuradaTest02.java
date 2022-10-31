package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HepsiBuradaPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class HepsiBuradaTest02 {

    Actions actions = new Actions(Driver.getDriver());
    HepsiBuradaPage hepsiBuradaPage = new HepsiBuradaPage();
    SoftAssert softAssert=new SoftAssert();
    private static Logger logger= LogManager.getLogger(HepsiBuradaTest02.class.getName());

    @Test
    public void test02() throws InterruptedException {

        logger.info("Kullanici, hepsiburada.com sitesini ziyaret eder");
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));

        logger.info("Kullanici, cookie'leri kabul eder");
        hepsiBuradaPage.acceptCookiesButton.click();

        logger.info("Kullanici, ileride lazim olabileceginden bulundugu sayfanin 'windowhandle' degerini alir");
        String firstTabWindowHandleHashCode = Driver.getDriver().getWindowHandle();
        Thread.sleep(500);

        logger.info("Kullanici, istedigi urunu aratir ve 'enter' tusuna basar");
        hepsiBuradaPage.searchBox.sendKeys(ConfigReader.getProperty("productToSearch2"), Keys.ENTER);
        Thread.sleep(500);

        logger.info("Kullanici, sayfayi daha iyi gorebilmek icin sayfayi biraz asagi kaydirir");
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(500);

        logger.info("Kullanici, arama sonucunda ekrana gele urun listesinden (veya tek bir sonuc da donmus olabilir) urun secer");
        hepsiBuradaPage.secondProduct.click();

        logger.info("Kullanici, urunun yeni bir sekmede acildigini gorur bu nedenle yeni sekmede islem yapabilmek icin 'windowhandles' degerlerini alip bir set'e atar");
        Set<String> windowHandleseti= Driver.getDriver().getWindowHandles();
        String secondTabWindowHandleHashCode="";
        for (String each: windowHandleseti) {
            if (!each.equals(firstTabWindowHandleHashCode)){
                secondTabWindowHandleHashCode=each;
            }
        }

        logger.info("Kullanici, Set araciligi ile buldugu yeni sekmenin 'windowhandle' degeri kullanarak driveri yeni sekmeye gecirir");
        Driver.getDriver().switchTo().window(secondTabWindowHandleHashCode);

        logger.info("Kullanici, yeni sekmede acilan urunun basligini ileride kullanacagi icin String bir variable'a atar");
        String secondProductName=hepsiBuradaPage.secondProductName.getText();

        logger.info("Kullanici, urunu ilk saticidan sepete ekler");
        hepsiBuradaPage.addToCartButton.click();

        logger.info("Kullanici, urun eklendikten sonra cikan bilgilendirme pop-up'ini kapatir");
        hepsiBuradaPage.popUpXButton.click();

        logger.info("Kullanici, ikinci saticidan urun eklemek icin sayfayi asagiya kaydirir");
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(500);

        logger.info("Kullanici, ayni urunu ikinci saticidan da sepete ekler");
        hepsiBuradaPage.otherSellerAddToCartButton.click();

        logger.info("Kullanici, ekledigi urunleri dogrulamak icin sepetim sayfasina gider");
        hepsiBuradaPage.popUpViewCartButton.click();

        logger.info("Kullanici, 'Sepetim' sayfasinda oldugunu dogrular");
        softAssert.assertTrue(hepsiBuradaPage.cartPageText.isDisplayed());

        logger.info("Kullanici, sepete ekledigi ilk urunun " + hepsiBuradaPage.firstSeller.getText() + " saticisindan oldugunu dogrular");
        softAssert.assertTrue(hepsiBuradaPage.firstProductInfoBox.getText().contains(hepsiBuradaPage.firstSeller.getText()));

        logger.info("Kullanici, sepete ekledigi urunun dogru urun oldugunu daha onceden aldigi urun adi ile karsilastirarak dogrulama yapar");
        softAssert.assertTrue(hepsiBuradaPage.firstProductInfoBox.getText().contains(secondProductName));

        logger.info("Kullanici, sepete ekledigi diger urunun " + hepsiBuradaPage.secondSeller.getText() + " saticisindan oldugunu dogrular");
        softAssert.assertTrue(hepsiBuradaPage.secondProductInfoBox.getText().contains(hepsiBuradaPage.secondSeller.getText()));

        logger.info("Kullanici, sepete ekledigi urunun dogru urun oldugunu daha onceden aldigi urun adi ile karsilastirarak dogrulama yapar");
        softAssert.assertTrue(hepsiBuradaPage.secondProductInfoBox.getText().contains(secondProductName));
        softAssert.assertAll();

        logger.warn("Kullanici, acilan tum sayfalari kapatarak test islemine son verir");
        Driver.getDriver().quit();



    }
}
