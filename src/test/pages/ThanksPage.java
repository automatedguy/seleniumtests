package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThanksPage extends BasePage{

    public ThanksPage(WebDriver iDriver) {
        super(iDriver);
    }

    /* Locators  */

    @FindBy(css = "section > div")
    private WebElement thanksMessage;

    /* Actions  */
    public String getThanksMessage(){
        return thanksMessage.getText();
    }
}
