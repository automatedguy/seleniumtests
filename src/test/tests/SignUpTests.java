package tests;

import base.BaseTestSetup;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class SignUpTests extends BaseTestSetup {

    private LoginPage loginPage = null;
    private SignUpPage signUpPage = null;
    private ThanksPage thanksPage = null;
    private ActivateYourAccountPage activateYourAccountPage = null;
    private MailPage mailPage = null;

    private final String APP_DIRECT_PASSWD = "AppDirect#1";
    private final String COMPANY_NAME = "Automathing Things Inc.";
    private final int PROFESSIONAL = 1;
    private final String PHONE = "777777777";


    @BeforeMethod()
    private void clickLogin(){
        loginPage = landingPage.clickLoginNavButton();
    }

    @Test(priority=1)
    public void signUpTest(ITestContext context){

        mailPage = initMailPage(this.driver);
        String newCustomerEmail = mailPage.createNewEmailAccount(getRandomString(9));
        context.setAttribute("newCustomerEmail", newCustomerEmail);

        signUpPage = loginPage.clickSignUpbutton();
        signUpPage.fillEmail(newCustomerEmail);
        thanksPage = signUpPage.clickSignUpButton();

        Assert.assertTrue(thanksPage.assertThanksMsg(newCustomerEmail));
        logger.info(TEST_PASSED);
    }

    @Test(priority=2)
    public void activateAccountTest(ITestContext context){
        String newCustomerEmail = (String) context.getAttribute("newCustomerEmail");
        logger.info("Customer email is: " + newCustomerEmail);

        mailPage = initMailPage(this.driver);
        activateYourAccountPage = mailPage.openNewEmailBox(newCustomerEmail);

        activateYourAccountPage.fillFirstName(getRandomString(7));
        activateYourAccountPage.fillLastName(getRandomString(7));
        activateYourAccountPage.fillPassword(APP_DIRECT_PASSWD);
        activateYourAccountPage.fillconfirmPassword(APP_DIRECT_PASSWD);
        activateYourAccountPage.fillCompanyName(COMPANY_NAME);
        activateYourAccountPage.selectBusinessSize(PROFESSIONAL);
        activateYourAccountPage.fillPhone(PHONE);
        activateYourAccountPage.
        activateYourAccountPage.clickCreateAccount();
    }

    @Test(priority=3)
    public void successfulLoginTest(){

    }

}