package SanityTests;

import Extentions.Verifications;
import Utilities.CommonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class SauceDemoDB extends CommonOps   {

    @Test(description = "Test02 - Login To Saucedemo With DB Credentials")
    @Description("This test tries to login with DB credentials and verifies the error message")
    public void test02_verifyErrorLogin() {
        webFlows.loginDB("SELECT username, password FROM Sauce_DataBase WHERE id='2'");
        Verifications.verifyTextInElement(sauceLogin.errorMessage, getData("LoginError"));
    }


}
