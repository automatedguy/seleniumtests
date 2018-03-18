package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivateYourAccountPage extends BasePage{

    public ActivateYourAccountPage(WebDriver iDriver) {
        super(iDriver);
    }

    /* Locators */

    @FindBy(css = "#firstNameBorder > input")
    private WebElement firstNameInput;

    @FindBy(css = "#lastNameBorder > input")
    private WebElement lastNameInput;

    @FindBy(css = "#id18 > div.activate-section > div:nth-child(4) > span > input")
    private WebElement chooseYourPasswwordInput;

    @FindBy(css = "#id18 > div.activate-section > div:nth-child(5) > span > input")
    private WebElement confirmPasswordInput;

    @FindBy(css = "#id1d")
    private WebElement companyNameInput;

    @FindBy(css = "#id1e")
    private WebElement bussinesSizeProfesionalRdb;

    @FindBy(css = "#id20")
    private WebElement bussinesSizeSmallBussinessRdb;

    @FindBy(css = "#id21")
    private WebElement bussinesSizeEnterpriseRdb;

    @FindBy(css = "#id22")
    private WebElement phoneInput;

    @FindBy(css = "#termsAndConditions")
    private WebElement agreeTermsOfServiceCkb;

    @FindBy(css = "#id19")
    private WebElement createAccountButton;

    /* Actions */

    public ActivateYourAccountPage fillFirstName(String firstName){
        fillData(firstNameInput, "First Name", firstName);
        return this;
    }

    public ActivateYourAccountPage fillLastName(String lastName){
        fillData(lastNameInput, "Last Name", lastName);
        return this;
    }

    public ActivateYourAccountPage fillPassword(String password){
        fillData(chooseYourPasswwordInput, "Choose your Password", password);
        return this;
    }

    public ActivateYourAccountPage fillconfirmPassword(String passwordConfirmation){
        fillData(confirmPasswordInput, "Confirm Password", passwordConfirmation);
        return this;
    }

    public ActivateYourAccountPage fillCompanyName(String companyName){
        fillData(confirmPasswordInput, "Confirm Password", companyName);
        return this;
    }

    public ActivateYourAccountPage selectBussinessSize(String bussinessSize){
        return this;
    }

    public ActivateYourAccountPage fillPhone(String phone){
        fillData(phoneInput, "Phone", phone);
        return this;
    }

    public HomePage clickCreateAccount(){
        clickElement(createAccountButton, "Create Account button");
        return initHomePage(this.driver);
    }


}
