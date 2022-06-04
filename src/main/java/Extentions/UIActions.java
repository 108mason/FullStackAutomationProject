package Extentions;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class UIActions extends CommonOps {

    @Step("Click On Element")
    public static void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @Step("Click on Element with JSExecutor")
    public static void JSclick(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
    }

    @Step("Select Element From DropDown")
    public static void selectFromDropDown(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }


    @Step("Update Text in Element")
    public static void updateText(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }


    @Step("Insert Key")
    public static void insertKey(WebElement element, Keys value) {
        element.sendKeys(value);
    }


    @Step("MouseHover 2 Elements")
    public static void mouseHover(WebElement elem1,WebElement elem2){
        wait.until(ExpectedConditions.visibilityOf(elem1));
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

    @Step("MouseHover 1 Element")
    public static void mouseHover(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        action.moveToElement(elem).click().build().perform();
    }


}
