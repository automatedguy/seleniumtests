package tests;

import base.BaseTestSetup;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignUpPage;
import pages.ThanksPage;

public class SignUpTests extends BaseTestSetup {

    private LoginPage loginPage = null;
    private SignUpPage signUpPage = null;
    private ThanksPage thanksPage = null;

    @BeforeMethod()
    private void clickLogin(){
        loginPage = landingPage.clickLoginNavButton();
    }

    @Test(priority=1)
    public void signUpTest(){
        signUpPage = loginPage.clickSignUpbutton();
        signUpPage.fillEmail("logquesea@mailinator.com");
        thanksPage = signUpPage.clickSignUpButton();
    }

    @Test(priority=2)
    public void simpleLoginTest(){

    }

    @Test(priority=3)
    public void loginFailTest(){

    }

}
