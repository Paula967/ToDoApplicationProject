package Com.Qaqart.todo.testcases;
import Com.Qaqart.todo.Apis.RegisterAPI;
import Com.Qaqart.todo.Base.BaseTest;
import Com.Qaqart.todo.Pages.NewToDoPage;
import Com.Qaqart.todo.Pages.ToDoPage;
import Com.Qaqart.todo.Utils.ConfigUtils;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
@Feature("ToDo Feature")
public class TodoTest extends BaseTest {
  ConfigUtils configUtils=new ConfigUtils();

    public TodoTest() throws IOException {

    }
   @Story("Add ToDo")
    @Test(priority = 1,description = "Test Adding new Todo Functionality")
    public void addnewtodo() throws IOException {

       // Using Api to AddNewToDo For a new Faker User =>instead of using Ui only
        //in newToDo Page is very Fast
        RegisterAPI registerAPI=new RegisterAPI();
        registerAPI.Register();
        NewToDoPage newToDoPage=new NewToDoPage(getDriver());
        newToDoPage.Load();
        InjectCookiesToBrowser(registerAPI.getRestAssuredRegisterCookies());
        String Todoitem=newToDoPage
                .Load()
                .InputDataAndCreateToDo("Learn Selenium")
                .getToDoItemt();
        Assert.assertEquals(Todoitem,"Learn Selenium");
    }
    @Story("Delete ToDo")
    @Test(priority = 2,description = "Test Deleting Existing Todo Functionality")
    public void Deletetodo() throws InterruptedException {
        ToDoPage todopage=new ToDoPage(getDriver());
        boolean result=todopage
                .ClickOnDeleteItem()
                .IsEmptyItemMessageDisplayed();
        Assert.assertTrue(result);
    }

}
