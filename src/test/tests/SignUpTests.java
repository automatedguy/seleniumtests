package tests;

import base.BaseTestSetup;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class SignUpTests extends BaseTestSetup {

    private LoginPage loginPage = null;
    private MailPage mailPage = null;
    private SignUpPage signUpPage = null;
    private ThanksPage thanksPage = null;
    private ActivateAccountPage activateAccountPage = null;
    private HomePage homePage = null;

    private final String APP_DIRECT_PASS = "AppDirect#1";
    private final String COMPANY_NAME = "Automathing Things Inc.";
    private final String PROFESSIONAL = "Professional";
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
        activateAccountPage = mailPage.openNewEmailBox(newCustomerEmail);

        String firstName = getRandomString(7);
        context.setAttribute("firstName", firstName);
        activateAccountPage.fillFirstName(firstName);

        String lastName = getRandomString(7);
        activateAccountPage.fillLastName(lastName);

        activateAccountPage.fillPassword(APP_DIRECT_PASS);
        activateAccountPage.fillconfirmPassword(APP_DIRECT_PASS);
        activateAccountPage.fillCompanyName(COMPANY_NAME);
        activateAccountPage.selectBusinessSize(PROFESSIONAL);
        activateAccountPage.fillPhone(PHONE);
        activateAccountPage.clickAgreeTermsAndConditions();
        homePage = activateAccountPage.clickCreateAccount();

        Assert.assertTrue(homePage.assertAccountUserName(firstName));

        homePage.clickAccountHeader();
        homePage.clickLogout();

        Assert.assertTrue(homePage.assertSignUpIsDisplayed());

        logger.info(TEST_PASSED);
    }

    @Test(priority=3)
    public void failLoginTest(ITestContext context){
        String wrongPass = "WrongPassword";
        String newCustomerEmail = (String) context.getAttribute("newCustomerEmail");
        logger.info("Customer email is: " + newCustomerEmail);

        loginPage.fillEmail(newCustomerEmail);
        loginPage.fillPassword(wrongPass);
        loginPage.clickLogInButton();

        logger.info(TEST_PASSED);
    }

    @Test(priority=4)
    public void successfulLoginTest(ITestContext context){
        String newCustomerEmail = (String) context.getAttribute("newCustomerEmail");
        logger.info("Customer email is: " + newCustomerEmail);

        loginPage.fillEmail(newCustomerEmail);
        loginPage.fillPassword(APP_DIRECT_PASS);
        homePage = loginPage.clickLogInButton();

        String firstName = (String) context.getAttribute("firstName");
        Assert.assertTrue(homePage.assertAccountUserName(firstName));

        logger.info(TEST_PASSED);
    }
}