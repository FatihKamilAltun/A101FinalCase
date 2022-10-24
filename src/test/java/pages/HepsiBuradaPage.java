package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiBuradaPage {
    public HepsiBuradaPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "(//span[@class='sf-OldMyAccount-d0xCHLV38UCH5cD9mOXq'])[1]")
    public WebElement girisYapVeyaUyeOlButonu;

    @FindBy(xpath = "//a[@id='login']")
    public WebElement girisYapButonu;


}
