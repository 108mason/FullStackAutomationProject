package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelperFunctions extends Base {

    @Step("TodoList: Insert Tag Color, returns it's Index")
    public static String todoListTagColors(String color){
        String[][] ColorsIndex= {
                {"Red", "0"},
                {"Orange", "1"},
                {"Yellow", "2"},
                {"Green", "3"},
                {"Blue", "4"},
                {"Purple", "5"},
                {"Grey", "6"}
        };
        for (int i=0; i<ColorsIndex.length; i++){
            if (ColorsIndex[i][0].equalsIgnoreCase(color)) {
                return ColorsIndex[i][1];
            }
        }
        throw new RuntimeException("Invalid Color Name");
    }

    @Step("TodoList: Insert Tag Color, returns it's CSS Style value")
    public static String todoListTagColorsByRgb(String color){
        String[][] colorsWithIndex= {
                {"Red", "background: rgb(255, 103, 93);"},
                {"Orange", "background: rgb(249, 167, 77);"},
                {"Yellow", "background: rgb(245, 206, 83);"},
                {"Green", "background: rgb(114, 204, 87);"},
                {"Blue", "background: rgb(87, 185, 244);"},
                {"Purple", "background: rgb(210, 137, 226);"},
                {"Grey", "background: rgb(165, 165, 167);"}
        };
        for (int i=0; i<colorsWithIndex.length; i++){
            if (colorsWithIndex[i][0].equalsIgnoreCase(color)) {
                return colorsWithIndex[i][1];
            }
        }
        throw new RuntimeException("Invalid Color Name");
    }


    @Step("Calculator: Insert Number, returns it's WebElement")
    public static WebElement calculatorNumbers(int num){
        List<WebElement> numbers = new ArrayList<>(Arrays.asList(calcMain.getBtn_zero(),calcMain.getBtn_one(),calcMain.getBtn_two(),calcMain.getBtn_three(),calcMain.getBtn_four(),
                calcMain.getBtn_five(),calcMain.getBtn_six(),calcMain.getBtn_seven(),calcMain.getBtn_eight(),calcMain.getBtn_nine()));
        return numbers.get(num);
    }


}
