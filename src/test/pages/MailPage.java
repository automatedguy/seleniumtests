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
    final String MAILINATOR_QSTRING = "/v2/inbox.jsp?zone=public&query=";
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
        waitForElement(emailSender, 5, "Email Sender");
        clickElement(emailSender, "Email Sender");
        return this;
    }

    private MailPage clickActivateButton(){
        driver.switchTo().frame("msg_body");
        waitForElement(activateButton, 5, "Activate Account button");
        clickElement(activateButton, "Activate Account button");
        switchToNewTab(3);
        return this;
    }

    public String createNewEmailAccount(String randomEmail){
        openNewTab(MAILINATOR_URL);
        switchToNewTab(2);
        String newCustomerEmail = randomEmail;
        fillEmailField(newCustomerEmail);
        clickGoButton();
        closeNewTab();
        switchToNewTab(1);
        return newCustomerEmail + MAILINATOR_EMAIL;
    }

    public ActivateYourAccountPage openNewEmailBox(String newCustomerEmail){
        openNewTab(MAILINATOR_URL + MAILINATOR_QSTRING + newCustomerEmail.replace(MAILINATOR_EMAIL, ""));
        switchToNewTab(2);
        clickNewEmail();
        clickActivateButton();
        return initActivateYourAccountPage(this.driver);
    }

}
