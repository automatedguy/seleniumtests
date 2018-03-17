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
    private WebElement email;

    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(css = "#id7")
    private WebElement logInbutton;

    @FindBy(css = ".adb-container_footer > menu > a")
    private WebElement signUpButton;

    /* Actions */

    public LoginPage fillEmail(String email){
        return this;
    }

    public LoginPage fillPassword(String password){
        return this;
    }

    public HomePage clickLogInButton(){
        return initHomePage(this.driver);
    }

    public SignUpPage clickSignUpbutton(){
        clickElement(signUpButton, "Sign Up button");
        return initSignUpPage(this.driver);
    }


}
