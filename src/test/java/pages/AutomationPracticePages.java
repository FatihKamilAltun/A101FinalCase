package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationPracticePages {
    public AutomationPracticePages() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
