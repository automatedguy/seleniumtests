package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;
import pages.HomePage;
import pages.LoginPage;
import pages.MailPage;
import pages.SignUpPage;

import java.util.ArrayList;

public class BasePage {

    public WebDriver driver;
    public BasePage(WebDriver iDriver) {
        this.driver = iDriver;
    }
    public static Logger logger = Logger.getLogger(BasePage.class);


    /* Common Actions */

    public void clickElement(WebElement element, String description){
        logger.info("Clicking: [" + description + "]");
        element.click();
    }


    public void switchToNewTab(int currentTab){
        logger.info("Switching to child tab.");
        ArrayList<String> newTab = new ArrayList(this.driver.getWindowHandles());
        this.driver.switchTo().window(newTab.get(currentTab + 1));
        logger.info("Child Tab URL: " + "[" +  driver.getCurrentUrl() + "]");
    }

    /* Factories */

    protected LoginPage initLoginPage(WebDriver driver){
        return PageFactory.initElements(driver, LoginPage.class);
    }

    protected HomePage initHomePage(WebDriver driver){
        return PageFactory.initElements(driver, HomePage.class);
    }

    protected SignUpPage initSignUpPage(WebDriver driver){
        return PageFactory.initElements(driver, SignUpPage.class);
    }

    protected MailPage initMailPage(WebDriver driver){
        return PageFactory.initElements(driver, MailPage.class);
    }

}
