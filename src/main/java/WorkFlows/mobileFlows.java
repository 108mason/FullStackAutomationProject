package WorkFlows;

import Extentions.MobileActions;
import Utilities.CommonOps;
import io.qameta.allure.Step;

public class mobileFlows extends CommonOps {

    @Step("Business Flow: Fill Form and Calculate Mortgage")
    public static void calculateMortgage(String amount, String term, String rate){
        MobileActions.updateText(mortgageMain.txt_amount, amount);
        MobileActions.updateText(mortgageMain.txt_term, term);
        MobileActions.updateText(mortgageMain.txt_rate, rate);
        MobileActions.tap(mortgageMain.btn_calculate);
    }


    @Step("Clear Text Fields")
    public static void clearTextFields(){
        MobileActions.clearText(mortgageMain.txt_repayment);
        MobileActions.clearText(mortgageMain.txt_term);
        MobileActions.clearText(mortgageMain.txt_rate);
    }



}
