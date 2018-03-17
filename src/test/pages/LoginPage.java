package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
        List<WebElement> elementList = driver.findElements(By.cssSelector("a"));
        for(WebElement element: elementList) {
            logger.info("Text: [" + element.getText() + "]");
            if (element.getText().equals("Sign Up"))
                signUpButton = element;
        }
        clickElement(signUpButton, "Sign Up button");
        return initSignUpPage(this.driver);
    }


}
