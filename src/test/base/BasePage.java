package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.LoginPage;

public class BasePage extends BaseTestSetup{

    public BasePage(WebDriver iDriver) {
        this.driver = iDriver;
    }

    /************  Locators ************/

    @FindBy(css = "#login")
    public WebElement loginButton;

    /************  Actions ************/

    public void clickElement(WebElement element){
        element.click();
    }

    public LoginPage clickLoginButton(){
        clickElement(this.loginButton);
        return initLoginPage(driver);
    }

}
