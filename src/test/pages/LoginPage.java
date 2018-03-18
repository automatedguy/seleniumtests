package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver iDriver) {
        super(iDriver);
    }

    /* Locators */

    @FindBy(css = "#username")
    private WebElement emailInput;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    @FindBy(css = ".adb-container_footer > menu > button")
    private WebElement logInbutton;

    @FindBy(css = ".adb-container_footer > menu > a")
    private WebElement signUpButton;

    @FindBy(css = "ul > li > span")
    private WebElement wrongPass;

    /* Actions */

    public LoginPage fillEmail(String email){
        fillData(emailInput, "User name input", email);
        return this;
    }

    public LoginPage fillPassword(String password){
        fillData(passwordInput, "Password input", password);
        return this;
    }

    public HomePage clickLogInButton(){
        clickElement(logInbutton, "Login button");
        return initHomePage(this.driver);
    }

    public SignUpPage clickSignUpButton(){
        clickElement(signUpButton, "Sign Up button");
        return initSignUpPage(this.driver);
    }

    public Boolean assertWrongPassMsg(String wrongPassMsg){
        logger.info("Asserting wrong pass message is displayed: [" + wrongPassMsg + "]");
        waitForElement(wrongPass, 10, wrongPassMsg);
        if(wrongPass.getText().equals(wrongPassMsg)){
            logger.info("[" + wrongPassMsg + "] is displayed correctly");
            return true;
        } else {
            logger.error("[" + wrongPassMsg + "] is not displayed correctly");
            return false;
        }
    }

}
