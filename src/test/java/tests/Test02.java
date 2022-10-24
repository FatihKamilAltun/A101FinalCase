package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Test02 {
    @Test
    public void test02() {
        Actions actions = new Actions(Driver.getDriver());
        HepsiBuradaPage hepsiBuradaPage = new HepsiBuradaPage();

        // Kullanıcı Hepsiburada.com sitesini ziyaret eder.
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));

        // Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.


        // Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.


        // Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.






    }
}
