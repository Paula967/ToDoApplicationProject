package Com.Qaqart.todo.testcases;
import Com.Qaqart.todo.Base.BaseTest;
import Com.Qaqart.todo.Pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterTest extends BaseTest {

    @Test(description = "Test Register Functionality")
    public void SignUP() throws IOException, InterruptedException {
        RegisterPage registerPage=new RegisterPage(getDriver());
        boolean ToDoWelcomeMessage=registerPage
                .registerPage()
                .IsWelcomeMessageDisplayed();
        Assert.assertTrue(ToDoWelcomeMessage);
    }
}
