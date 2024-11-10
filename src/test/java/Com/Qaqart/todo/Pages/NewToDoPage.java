package Com.Qaqart.todo.Pages;
import Com.Qaqart.todo.Base.BasePage;
import Com.Qaqart.todo.Utils.ConfigUtils;
import Com.Qaqart.todo.Utils.CookiesUtils;
import Com.Qaqart.todo.config.EndPoints;
import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class NewToDoPage extends BasePage {

    //Constructor with SuperMethod to Access driver of the Parent Class  => (BasePage)
    public NewToDoPage(WebDriver driver) {
        super(driver);

    }
    @FindBy(xpath = "//input[@data-testid='new-todo']")
    private WebElement TodoText;

    @FindBy(xpath="//button[@data-testid='submit-newTask']")
    private WebElement CreateToDoButton;
    @Step
    public ToDoPage InputDataAndCreateToDo(String data){
        TodoText.sendKeys(data);
        click(CreateToDoButton);
        return new ToDoPage(driver);
    }

    public NewToDoPage Load() throws IOException {
        driver.get(new ConfigUtils().getBaseUrl()+ EndPoints.NEW_TODO_PAGE_ENDPOINT);
        return this;
    }



}
