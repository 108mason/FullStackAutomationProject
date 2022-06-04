package Extentions;

import Utilities.CommonOps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MobileActions extends CommonOps {


        @Step("Tap on Element")
        public static void tap(MobileElement elem) {
            wait.until(ExpectedConditions.elementToBeClickable(elem));
            TouchAction action = new TouchAction(mobileDriver);
            action.tap((new TapOptions())
                    .withElement(ElementOption.element(elem)))
                    .perform();
        }

    @Step("Update Text in Element")
    public static void updateText(MobileElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Clear Text in Element")
    public static void clearText(MobileElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.clear();
    }



}
