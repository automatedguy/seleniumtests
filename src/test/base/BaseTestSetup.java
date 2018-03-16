package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;


public class BaseTestSetup {

    private static final String RESOURCES_PATH = "src/test/resources/";
    private static final String BASE_URL = "https://www.appdirect.com/";

    public static Logger logger = Logger.getLogger(BaseTestSetup.class);

    private WebDriver driver;
    private ChromeOptions chromeOptions;

    @BeforeClass
    public void prepareLogger() throws Exception
    {
        Class<? extends BaseTestSetup> currTestClass = getClass();
        this.logger = Logger.getLogger(currTestClass);
        String message = "Started executing class " + this.getClass().getName();
        logger.info(message);
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
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestContext context) {
        logger.info("Tearing down Chrome Browser.");
        driver.quit();
    }
}