package tests;

import base.BaseTestSetup;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class SignUpTests extends BaseTestSetup {

    private LoginPage loginPage = null;
    private SignUpPage signUpPage = null;
    private ThanksPage thanksPage = null;
    private ActivateYourAccountPage activateYourAccountPage = null;
    private MailPage mailPage = null;


    @BeforeMethod()
    private void clickLogin(){
        loginPage = landingPage.clickLoginNavButton();
    }

    @Test(priority=1)
    public void signUpTest(ITestContext context){

        mailPage = initMailPage(this.driver);
        String newCustomerEmail = mailPage.createNewEmailAccount();
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



    }

    @Test(priority=3)
    public void successfulLoginTest(){

    }

}