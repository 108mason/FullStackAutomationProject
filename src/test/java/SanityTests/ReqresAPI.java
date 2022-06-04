package SanityTests;

import Extentions.Verifications;
import Utilities.CommonOps;
import WorkFlows.apiFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(Utilities.Listeners.class)
public class ReqresAPI extends CommonOps {

    @Test(description = "Test01 - Verify User Email")
    @Description("This test verifies the user's email")
    public void test01_verifyUserEmail() {
        Verifications.verifyText(apiFlows.getUserProperty("7", "data.email"), "michael.lawson@reqres.in");
    }

    @Test(description = "Test02 - Add User")
    @Description("This test adds a user and verifies it was added")
    public void test02_addUser() {
        int code = apiFlows.createUser("Tomer", "Engineer");
        Verifications.verifyNumbers(code, 201);
    }

    @Test(description = "Test03 - Update User")
    @Description("This test updates user's information and verifies it was updated")
    public void test03_updateUser() {
        int code = apiFlows.updateUser("Tomer", "Engineer", "7");
        Verifications.verifyNumbers(code, 200);
    }

    @Test(description = "Test04 - Delete User")
    @Description("This test deletes a user and verifies it was deleted")
    public void test04_deleteUser() {
        int code = apiFlows.deleteUser("7");
        Verifications.verifyNumbers(code, 204);
    }
}
