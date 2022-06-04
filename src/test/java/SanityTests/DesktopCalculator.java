package SanityTests;


import Extentions.Verifications;
import Utilities.CommonOps;
import WorkFlows.desktopFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.Listeners.class)
public class DesktopCalculator extends CommonOps {

    @Test(description = "Test01 - Verify Addition Command")
    @Description("This test sums numbers and Verifies the Result")
    public void Test01_verifyAdditionCommand(){
        desktopFlows.calculateAddition(Integer.parseInt(getData("FirstNumber")),Integer.parseInt(getData("SecondNumber")));
        Verifications.assertTextInElement(calcMain.getField_result(),"Display is 7");
    }
}
