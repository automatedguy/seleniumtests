package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivateAccountPage extends BasePage{

    public ActivateAccountPage(WebDriver iDriver) {
        super(iDriver);
    }

    /* Locators */

    @FindBy(css = "#firstNameBorder > input")
    private WebElement firstNameInput;

    @FindBy(css = "#lastNameBorder > input")
    private WebElement lastNameInput;

    @FindBy(css = ".activate-section > div:nth-child(4) > span > input")
    private WebElement chooseYourPasswwordInput;

    @FindBy(css = ".activate-section > div:nth-child(5) > span > input")
    private WebElement confirmPasswordInput;

    @FindBy(css = ".form-row.company-name > span.form-field > input")
    private WebElement companyNameInput;

    @FindBy(css = "#SMALL")
    private WebElement bussinesSizeProfesionalRdb;

    @FindBy(css = "#MEDIUM")
    private WebElement bussinesSizeSmallBussinessRdb;

    @FindBy(css = "#ENTERPRISE")
    private WebElement bussinesSizeEnterpriseRdb;

    @FindBy(css = "div:nth-child(6) > div > div:nth-child(5) > span > input")
    private WebElement phoneInput;

    @FindBy(css = "#termsAndConditions")
    private WebElement agreeTermsOfServiceCkb;

    @FindBy(css = ".adb-styled.buttons > button")
    private WebElement createAccountButton;

    /* Actions */

    public ActivateAccountPage fillFirstName(String firstName){
        fillData(firstNameInput, "First Name", firstName);
        return this;
    }

    public ActivateAccountPage fillLastName(String lastName){
        fillData(lastNameInput, "Last Name", lastName);
        return this;
    }

    public ActivateAccountPage fillPassword(String password){
        fillData(chooseYourPasswwordInput, "Choose your Password", password);
        return this;
    }

    public ActivateAccountPage fillconfirmPassword(String passwordConfirmation){
        fillData(confirmPasswordInput, "Confirm Password", passwordConfirmation);
        return this;
    }

    public ActivateAccountPage fillCompanyName(String companyName){
        fillData(companyNameInput, "Company name", companyName);
        return this;
    }

    public ActivateAccountPage selectBusinessSize(String businessSize){
        logger.info("Selecting business size: [" + businessSize + "]");
        switch(businessSize){
            case "Professional" : bussinesSizeProfesionalRdb.click();
                break;
            case "SmallBusiness" : bussinesSizeSmallBussinessRdb.click();
                break;
            case "Enterprise" : bussinesSizeEnterpriseRdb.click();
        }
        return this;
    }

    public ActivateAccountPage fillPhone(String phone){
        fillData(phoneInput, "Phone", phone);
        return this;
    }

    public ActivateAccountPage clickAgreeTermsAndConditions(){
        clickElement(agreeTermsOfServiceCkb, "I agree to the Terms of Service");
        return this;
    }

    public HomePage clickCreateAccount(){
        clickElement(createAccountButton, "Create Account button");
        return initHomePage(this.driver);
    }


}
