package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;
import pages.*;

import java.security.SecureRandom;
import java.util.ArrayList;

public class BasePage {

    public WebDriver driver;
    public BasePage(WebDriver iDriver) {
        this.driver = iDriver;
    }
    public static Logger logger = Logger.getLogger(BasePage.class);
    final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    SecureRandom rnd = new SecureRandom();

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

    public void openNewTab(String url){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('" + url + "','_blank');");
    }

    public void closeNewTab(){

    }

    public void switchToNewTab(int tabIndex){
        logger.info("Switching to child tab.");
        ArrayList<String> newTab = new ArrayList(this.driver.getWindowHandles());
        this.driver.switchTo().window(newTab.get(tabIndex));
        logger.info("Child Tab URL: " + "[" +  driver.getCurrentUrl() + "]");
    }

    public String getRandomString(int len){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    public void waitForElement(WebElement element, int timeOutInSeconds, String message){
        try {
            logger.info("Waiting for: [" + message + "]");
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.withMessage(message);
            wait.until(ExpectedConditions.visibilityOf(element));
            logger.info(message + " is displayed");
        }catch (TimeoutException exception) {
            logger.error(message + " is not displayed");
            throw exception;
        }
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

    protected ActivateAccountPage initActivateAccountPage(WebDriver driver){
        return PageFactory.initElements(driver,ActivateAccountPage.class);
    }

}
