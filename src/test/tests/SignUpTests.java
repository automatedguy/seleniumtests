package tests;

import base.BaseTestSetup;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class SignUpTests extends BaseTestSetup {

    private LoginPage loginPage = null;

    @BeforeMethod()
    private void clickLogin(){
        basePage.clickLoginButton();
    }

    @Test(priority=1)
    public void signUpTest(){

    }

    @Test(priority=2)
    public void simpleLoginTest(){

    }

    @Test(priority=3)
    public void loginFailTest(){

    }

}
