package tests;

import base.BaseTestSetup;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MailPage;
import pages.SignUpPage;
import pages.ThanksPage;

public class SignUpTests extends BaseTestSetup {

    private LoginPage loginPage = null;
    private SignUpPage signUpPage = null;
    private ThanksPage thanksPage = null;
    private String newCustomerEmail = "";
    private MailPage mailPage = null;

    @BeforeMethod()
    private void clickLogin(){
        loginPage = landingPage.clickLoginNavButton();
    }

    private String createNewEmailAccount(){
        mailPage = initMailPage(this.driver);
        return mailPage.createNewEmailAccount() + "@mailinator.com";
    }


    @Test(priority=1)
    public void signUpTest(){
        signUpPage = loginPage.clickSignUpbutton();

        newCustomerEmail = createNewEmailAccount();

        signUpPage.fillEmail(newCustomerEmail);
        thanksPage = signUpPage.clickSignUpButton();
        Assert.assertTrue(thanksPage.assertThanksMsg(newCustomerEmail));
    }

    @Test(priority=2)
    public void simpleLoginTest(){

    }

    @Test(priority=3)
    public void loginFailTest(){

    }

}
