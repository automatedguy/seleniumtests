package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class MailPage extends BasePage {

    public MailPage(WebDriver iDriver) {
        super(iDriver);
    }

    final String MAILINATOR_URL = "https://www.mailinator.com";
    final String MAILINATOR_EMAIL = "@mailinator.com";
    /* Locators */

    @FindBy(css = "div.panel #inboxfield")
    private WebElement emailField;

    @FindBy(css = ".input-group span button")
    private WebElement goButton;

    @FindBy(css = "#inboxpane div:nth-child(3)")
    private WebElement emailSender;

    @FindBy(css = "tr:nth-child(11) > td > a")
    private WebElement activateButton;

    /* Actions */

    private MailPage fillEmailField(String newCustomerEmail){
        fillData(emailField, "Email field", newCustomerEmail);
        return this;
    }

    private MailPage clickGoButton(){
        clickElement(goButton, "GO button");
        return this;
    }

    private MailPage clickNewEmail(){
        clickElement(emailSender, "Email Sender");
        return this;
    }

    private MailPage clickActivateButton(){
        clickElement(activateButton, "Activate Account button");
        return this;
    }

    public String createNewEmailAccount(){
        openNewTab(MAILINATOR_URL);
        switchToNewTab(2);
        String newCustomerEmail = getRandomString(9);
        fillEmailField(newCustomerEmail);
        clickGoButton();
        closeNewTab();
        switchToNewTab(1);
        return newCustomerEmail + MAILINATOR_EMAIL;
    }

    public ActivateAccountPage goToActivateAccountPage(){
        clickNewEmail();
        clickActivateButton();
        return initActivateAccountPage(this.driver);
    }

}
