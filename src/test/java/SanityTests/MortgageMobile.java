package SanityTests;

import Extentions.Verifications;
import Utilities.CommonOps;
import WorkFlows.mobileFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.Listeners.class)
public class MortgageMobile extends CommonOps {

    @Test(description = "Test01 - Verify Mortgage")
    @Description("This test something")
    public static void Test01_verifyMortgage(){
        mobileFlows.calculateMortgage("1000", "3", "4");
        Verifications.verifyTextInElement(mortgageMain.txt_repayment, "£30.03");
        }

}
