package PageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class MainPage {

    @FindBy(xpath="//input[@placeholder='Create a task']")
    private WebElement txt_createTask;

    @FindBy(className="taskWrapper_2u8dN")
    private List<WebElement> list_tasks;

    @FindBy(className="destroy_19w1q")
    private WebElement btn_X;

    @FindBy(className="downArrowIcon_3Zu5N")
    private WebElement btn_arrowDown;

    @FindBy(xpath="//span[@class='tag_21fhY']")
    private List<WebElement> list_colorsMenu;

    @FindBy(className="tag_3u4he")
    private List<WebElement> list_tasksColorTag;

    @FindBy(className="label_5i8SP")
    private List<WebElement> list_tasksLabel;

    @FindBy(xpath="//span[@class='tag_21fhY hasNoTag_3ftX1']")
    private WebElement btn_noTag;

    @FindBy(xpath="//div[@class='topWrapper_2caNE']")
    private WebElement btnsWraper_createTask;



    /*
 ===========================================================================
     */

    public WebElement getTxt_createTask(){
        return txt_createTask;
    }

    public List<WebElement> getList_tasks(){
        return list_tasks;
    }

    public WebElement getBtn_X(){
        return btn_X;
    }

    public WebElement getBtn_arrowDown(){
        return btn_arrowDown;
    }

    public List<WebElement> getList_colorsMenu(){
        return list_colorsMenu;
    }

    public List<WebElement> getList_tasksColorTag(){
        return list_tasksColorTag;
    }

    public List<WebElement> getList_tasksLabel(){
        return list_tasksLabel;
    }

    public WebElement getBtn_noTag(){
        return btn_noTag;
    }

    public WebElement getBtnsWraper_createTask(){
        return btnsWraper_createTask;
    }

}
