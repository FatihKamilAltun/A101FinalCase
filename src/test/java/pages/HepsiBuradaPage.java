package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiBuradaPage {
    public HepsiBuradaPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement acceptCookiesButton;
    @FindBy(xpath = "(//span[@class='sf-OldMyAccount-d0xCHLV38UCH5cD9mOXq'])[1]")
    public WebElement logInOrSignInButton;
    @FindBy(xpath = "//a[@id='login']")
    public WebElement popUpLogInButton;
    @FindBy(xpath = "//input[@id='txtUserName']")
    public WebElement emailOrPhoneNumberBox;
    @FindBy(xpath = "//button[@id='btnLogin']")
    public WebElement emailLogInButton;
    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement passwordBox;
    @FindBy(xpath = "//button[@id='btnEmailSelect']")
    public WebElement passwordLogInButton;
    @FindBy(xpath = "//*[text()='Hesabım']")
    public WebElement successLogInText;
    @FindBy(xpath = "//input[@class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']")
    public WebElement searchBox;
    @FindBy(xpath = "(//div[@data-test-id='product-card-image-container'])[2]")
    public WebElement firstProduct;
    @FindBy(xpath = "//button[@id='addToCart']")
    public WebElement addToCartButton;
    @FindBy(xpath = "//button[@class='add-to-basket button small']")
    public WebElement otherSellerAddToCartButton;
    @FindBy(xpath = "//a[@class='checkoutui-Modal-2iZXl']")
    public WebElement popUpXButton;
    @FindBy(xpath = "//*[text()='Sepete git']")
    public WebElement popUpViewCartButton;




   /* @FindBy(xpath = "//button[@id='btnGoogle']")
    public WebElement googleIleGirisYapButonu;

    @FindBy(xpath = "//input[@id='identifierId']")
    public WebElement emailBox;

    @FindBy(xpath = "//*[text()='İleri']")
    public WebElement ileriButonu;*/







}
