package Extentions;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.testng.Assert;


import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.fail;

public class Verifications extends CommonOps {

    @Step("Assert Number Of Elements")
    public static void assertNumberOfElementsInList(List<WebElement> list, int expected){
        if (!list.isEmpty()){
            wait.until(ExpectedConditions.visibilityOfAllElements(list));
            assertEquals(list.size(),expected);
        }
        else
            assertEquals(0,expected);
    }


    @Step("Assert Text In Attribute")
    public static void assertTextInElementAttribute(WebElement elem, String attribute, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getAttribute(attribute),expected);
    }


    @Step("Assert Non Existence of Specified Record in List")
    public static void assertNonExistenceOfSpecifiedRecordInList(List<WebElement> list, String record) {
        boolean recordNotPresent = true;
        for (int i=0; i < list.size(); i++) {
            if (list.get(i).getText().equalsIgnoreCase(record))
                recordNotPresent=false;
        }
        assertTrue(recordNotPresent);
    }

    @Step("Assert Number")
    public static void assertNumber(int actual, int expected){
        assertEquals(actual,expected);
    }

    @Step("Assert Condition")
    public static void assertCondition(Boolean isTrue){
        assertTrue(isTrue);
    }

    @Step("Assert Text In Element")
    public static void assertTextInElement(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(),expected);
    }


    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement element, String expected) {
        wait.until(ExpectedConditions.visibilityOf(element));
        assertEquals(element.getText(), expected);
    }



    @Step("Assert Element Visually")
    public static void assertElementVisually(String expectedImageName){
        try {
            screen.find(getData("ImageRepo") + expectedImageName + ".png");
        } catch (FindFailed findFailed) {
            fail("Error Comparing Image Files: "+findFailed);
        }
    }

    @Step("Assert Visibility Of Elements (Soft Assertion)")
    public static void softAssertVisibilityOfElements(List<WebElement> list){
        for(int i=0; i< list.size(); i++){
            softAssert.assertTrue(list.get(i).isDisplayed(),list.get(i).getText()+" not Displayed");
        }
        softAssert.assertAll();
    }


    @Step("verify Text with Text")
    public static void text(String actual, String expected)
    {
        Assert.assertEquals(actual,expected);
    }


    @Step("Verify Two Texts Are Identical")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify Two numbers Are Identical")
    public static void verifyNumbers(int actual, int expected) {
        assertEquals(actual, expected);
    }



}
