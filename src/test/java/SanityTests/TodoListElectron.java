package SanityTests;

import Extentions.Verifications;
import Utilities.CommonOps;
import WorkFlows.electronFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.Listeners.class)
public class TodoListElectron extends CommonOps {

    @Test(description = "Test01 - Add and Verify New Task")
    @Description("This test adds a new task and verifies it's addition")
    public void Test01_addAndVerifyNewTask(){
        electronFlows.addNewTaskWithColor("Learn Java");
        Verifications.assertNumber(electronFlows.getNumberOfTasks(),1);
    }

    @Test(description = "Test02 - Add a Task with color and Verify it's color")
    @Description("This test adds a new task tagged by color and verifies the color shown is correct")
    public void Test02_addColorTaskAndVerifyColor(){
        electronFlows.addNewTaskWithColor("Learn German","Green");
        Verifications.assertTextInElementAttribute(todoListMain.getList_tasksColorTag().get(0),"style","background: rgb(114, 204, 87);");
    }

    @Test(description = "Test03 - Add New Tasks, Delete 1 Task and Verify Deletion")
    @Description("This test adds some new tasks to the list, deletes one task and verifies it's deletion")
    public void Test03_addTaskAndDeleteAndVerifyDeletion(){
        electronFlows.addNewTaskWithColor("Learn Hacking");
        electronFlows.addNewTaskWithColor("Learn Soccer");
        electronFlows.addNewTaskWithColor("Learn Python");
        electronFlows.addNewTaskWithColor("Learn German");
        electronFlows.deleteTask("Learn Soccer");
        Verifications.assertNonExistenceOfSpecifiedRecordInList(todoListMain.getList_tasksLabel(), "Learn Soccer");
    }


}
