package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTestSetup {

    private static final String RESOURCES_PATH = "src/test/resources/";
    private WebDriver driver;
    private ChromeOptions chromeOptions;

    @BeforeSuite
    public void initializeTestBaseSetup(){
        setChromeOptions();
    }

    private void setChromeOptions(){
        System.setProperty("webdriver.chrome.driver", RESOURCES_PATH + "chromedriver");
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("test-type", "start-maximized", "no-default-browser-check");
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS,  true);
    }

    @BeforeMethod(alwaysRun = true)
    private void setDriver(){
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://www.appdirect.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}