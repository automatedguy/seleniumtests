package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;
import pages.*;

import java.util.ArrayList;

public class BasePage {

    public WebDriver driver;
    public BasePage(WebDriver iDriver) {
        this.driver = iDriver;
    }
    public static Logger logger = Logger.getLogger(BasePage.class);

    private int currentTabIndex = 0;

    /* Common Actions */

    public void fillData(WebElement element, String description, String data){
        logger.info("Filling [" + description + "] : [" + data +"]");
        element.clear();
        element.sendKeys(data);
    }

    public void clickElement(WebElement element, String description){
        logger.info("Clicking: [" + description + "]");
        element.click();
    }


    public void switchToNewTab(){
        logger.info("Switching to child tab.");
        ArrayList<String> newTab = new ArrayList(this.driver.getWindowHandles());
        currentTabIndex = currentTabIndex + 1;
        this.driver.switchTo().window(newTab.get(currentTabIndex));
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

    protected ThanksPage initThanksPage(WebDriver driver){
        return PageFactory.initElements(driver, ThanksPage.class);
    }

    protected MailPage initMailPage(WebDriver driver){
        return PageFactory.initElements(driver, MailPage.class);
    }

}
