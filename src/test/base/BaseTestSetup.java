package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.*;

import static base.Constansts.RESOURCES_PATH;

public class BaseTestSetup {

    private WebDriver driver;

    private ChromeOptions setChromeOptions(){
        System.setProperty("webdriver.chrome.driver", RESOURCES_PATH + "chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("test-type", "start-maximized", "no-default-browser-check");
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS,  true);
        return chromeOptions;
    }

    @BeforeMethod
    private void setDriver(){
        driver = new ChromeDriver(setChromeOptions());
    }
}