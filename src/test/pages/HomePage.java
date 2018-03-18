package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver iDriver) {
        super(iDriver);
    }

    /* Locators */

    @FindBy(css = ".ad-component_list-item--signup")
    private WebElement signUp;

    @FindBy(css = "#primaryNav > header .js-primary-nav-user-menu > a")
    private WebElement accountHeader;

    @FindBy(css = ".ad-component_list-item--logout > a")
    private WebElement logout;

    /* Actions */

    public HomePage clickAccountHeader(){
        clickElement(accountHeader, "Account Header");
        return this;
    }

    public HomePage clickLogout(){
        clickElement(logout, "Logout");
        return this;
    }

    public Boolean assertSignUpIsDisplayed(){
        logger.info("Asserting Sign Up header is displayed.");
        waitForElement(signUp, 10, "Sign Up menu header");
        if(signUp.isDisplayed()){
            logger.info("Sign Up is displayed");
            return true;
        } else {
            logger.info("Sign Up is no displayed");
            return false;
        }
    }

    public String getAccountHeaderText(){
        waitForElement(accountHeader, 10, "User name on header");
        return accountHeader.getText();
    }

    public Boolean assertAccountUserName(String accountUserName){
        logger.info("Asserting user name displayed: [" + accountUserName + "]");
        if(getAccountHeaderText().equals(accountUserName)){
            logger.info("User name is displayed correctly.");
                    return true;
        } else {
            logger.error("User name is not displayed correctly");
            return false;
        }
    }
}
