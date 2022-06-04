package WorkFlows;

import Extentions.UIActions;
import Utilities.CommonOps;
import Utilities.HelperFunctions;
import io.qameta.allure.Step;

public class desktopFlows extends CommonOps {

    @Step("Business Flow: Calculate Addition")
    public static void calculateAddition(int num1, int num2) {
        UIActions.click(HelperFunctions.calculatorNumbers(num1));
        UIActions.click(calcMain.getBtn_plus());
        UIActions.click(HelperFunctions.calculatorNumbers(num2));
        UIActions.click(calcMain.getBtn_equals());
    }

    @Step("Click on 'Clear' button")
    public static void clickOnClearButton() {
        UIActions.click(calcMain.getBtn_clear());
    }

}
