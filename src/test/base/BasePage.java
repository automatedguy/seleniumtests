package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

public class BasePage {

    public WebDriver driver;

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
        clickElement(loginButton);
        return initLoginPage(driver);
    }

    /************** Factories **************/

    protected LoginPage initLoginPage(WebDriver driver){
        return PageFactory.initElements(driver, LoginPage.class);
    }

}
