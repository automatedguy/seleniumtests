package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.font.TrueTypeFont;

public class ThanksPage extends BasePage{

    public ThanksPage(WebDriver iDriver) {
        super(iDriver);
    }
    final private String FIRST_PART = "Thanks for registering.\nWe have sent a verification email to ";
    final private String SECOND_PART = ".\nPlease check your inbox and click the link to activate your account.";


    /* Locators  */

    @FindBy(css = "section > div")
    private WebElement thanksMessage;

    /* Actions  */
    private String getThanksMessage(){
        return thanksMessage.getText();
    }

    private String getExpectedThanksMsg(String newCustomerEmail){
        return  FIRST_PART + newCustomerEmail + SECOND_PART;
    }

    public Boolean assertThanksMsg(String newCustomerEmail){
        if(getThanksMessage().equals(getExpectedThanksMsg(newCustomerEmail))){
            logger.info("Thanks page msg is right!");
            return true;
        } else {
            logger.info("Thanks page msg is right!");
            return false;
        }
    }

}
