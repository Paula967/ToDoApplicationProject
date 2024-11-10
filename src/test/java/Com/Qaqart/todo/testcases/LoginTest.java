package Com.Qaqart.todo.testcases;
import Com.Qaqart.todo.Base.BaseTest;
import Com.Qaqart.todo.Pages.LoginPage;
import Com.Qaqart.todo.Pages.ToDoPage;
import Com.Qaqart.todo.Utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
@Feature("Auth Feature")
public class LoginTest extends BaseTest {
    ConfigUtils configUtils=new ConfigUtils();

    public LoginTest() throws IOException {
    }

    @Story("Login with Email and Password")
    @Description("It will login by filling email and password and navigate ToDo Page")
    @Test(description = "Test the Login Functionality within Email and Password")
    public void LoginWitheEmailAndPassword() throws IOException, InterruptedException {

         //Login in With Valid Email and Password
         LoginPage loginPagee=new LoginPage(getDriver());
                                boolean toDoPageWelcomeMessage= loginPagee
                                .load()
                                .Login(configUtils.getEmail(), configUtils.getPassword()).IsWelcomeMessageDisplayed();
        Assert.assertTrue(toDoPageWelcomeMessage);

    }
    @Story("LogOut")
    @Test(priority = 2,description = "Test Logout Functionality")
    public void LOGOUT(){
        ToDoPage toDoPage=new ToDoPage(getDriver());
        toDoPage.logout();
    }

}
