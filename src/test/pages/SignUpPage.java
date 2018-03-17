package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver iDriver) {
        super(iDriver);
    }

    /* Locators */

    @FindBy(css = ".adb-container_content > div > input")
    private WebElement email;

    @FindBy(css = "adb-button__primary adb-toolbar--item")
    private WebElement signUpButon;

    /* Actions */

    public SignUpPage fillEmail(String emailData){
        fillData(email, "Email", emailData);
        return this;
    }

    public ThanksPage clickSignUpButton(){
        clickElement(signUpButon, "Sign Up button");
        return initThanksPage(this.driver);
    }
}
