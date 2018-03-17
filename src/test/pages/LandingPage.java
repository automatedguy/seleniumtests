package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver iDriver) {
        super(iDriver);
    }

    /* Locators */

    @FindBy(css = "#login")
    public WebElement loginButton;

    /* Actions */

    public LoginPage clickLoginNavButton(){
        clickElement(loginButton, "LOG IN navigation button");
        switchToNewTab();
        return initLoginPage(driver);
    }
}
