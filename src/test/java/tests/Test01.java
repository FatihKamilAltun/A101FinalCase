package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Test01 {
    Actions actions=new Actions(Driver.getDriver());
    HepsiBuradaPage hepsiBuradaPage=new HepsiBuradaPage();


    @Test
    public void test01() {

        // Kullanıcı "Hepsiburada.com" sitesini ziyaret eder.
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));

        // Kullanıcı giriş işlemi yapılır.
        actions.moveToElement(hepsiBuradaPage.girisYapVeyaUyeOlButonu).perform();
        hepsiBuradaPage.girisYapButonu.click();



    }
}
