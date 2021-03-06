package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;
import pages.LandingPage;
import pages.MailPage;

import java.security.SecureRandom;

public class BaseTestSetup {

    private static final String RESOURCES_PATH = "src/test/resources/";
    private static final String BASE_URL = "https://www.appdirect.com/";
    protected static final String TEST_PASSED = "Test PASSED!";

    final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    SecureRandom rnd = new SecureRandom();

    protected static Logger logger = Logger.getLogger(BaseTestSetup.class);

    protected WebDriver driver;
    private ChromeOptions chromeOptions;
    protected LandingPage landingPage = null;

    @BeforeClass
    public void prepareLogger() throws Exception
    {
        Class<? extends BaseTestSetup> currTestClass = getClass();
        this.logger = Logger.getLogger(currTestClass);
        String message = "Started executing class " + this.getClass().getName();
        logger.info(message);
    }

    protected String getRandomString(int len){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    private void printSeparator(){
        logger.info("***************************************");
    }
    protected void printTestInfo(String testInfo){
        printSeparator();
        logger.info("***" + testInfo + "***");
        printSeparator();
    }

    @BeforeSuite(alwaysRun = true)
    public void setUpBrowser(ITestContext context){
        setChromeOptions();
    }

    private void setChromeOptions(){
        logger.info("Setting up Chrome Browser");
        System.setProperty("webdriver.chrome.driver", RESOURCES_PATH + "chromedriver");
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("test-type", "start-maximized", "no-default-browser-check");
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS,  true);
    }

    @BeforeMethod(alwaysRun = true)
    public void openBasePage(ITestContext context){
        logger.info("Starting Chrome Browser...");
        driver = new ChromeDriver(chromeOptions);
        logger.info("Navigating to Base URL: " + BASE_URL);
        driver.navigate().to(BASE_URL);
        landingPage = initLandingPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestContext context) {
        logger.info("Tearing down Chrome Browser.");
        driver.quit();
    }

    /* Factories */

    private LandingPage initLandingPage(WebDriver driver){
        return PageFactory.initElements(driver, LandingPage.class);
    }

    protected MailPage initMailPage(WebDriver driver){
        return PageFactory.initElements(driver, MailPage.class);
    }
}