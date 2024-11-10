package Com.Qaqart.todo.Pages;
import Com.Qaqart.todo.Base.BasePage;
import Com.Qaqart.todo.Utils.ConfigUtils;
import Com.Qaqart.todo.config.EndPoints;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.time.Duration;

public class ToDoPage extends BasePage {

    //Constructor with SuperMethod to Access driver of the Parent Class  => (BasePage)
    public ToDoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@data-testid='todo-item']")
    private WebElement todoItem;

    @FindBy (xpath="//div[@class='sc-idiyUo hWRklb']/button")
    private WebElement addButton;

    @FindBy (xpath="//input[@type='checkbox']")
    private WebElement CheckboxItem;

    @FindBy(xpath = "//button[@data-testid='delete']")
    private WebElement DeleteItem;

    @FindBy(xpath = "//h4[@data-testid='no-todos']")
    private WebElement EmptyItemMessage;

    public NewToDoPage ClickPlusButton() throws InterruptedException {
        click(addButton);
        return new NewToDoPage(driver);
    }

    public String getToDoItemt(){
        return todoItem.getText();
    }

    public ToDoPage ClickOnDeleteItem() throws InterruptedException {
        click(CheckboxItem);
        click(DeleteItem);
        return this;
    }

    public boolean IsEmptyItemMessageDisplayed() throws InterruptedException {
        return EmptyItemMessage.isDisplayed();
    }

    public ToDoPage Load() throws IOException, InterruptedException {
        driver.get(new ConfigUtils().getBaseUrl()+ EndPoints.TODO_PAGE_ENDPOINT);
        return this;
    }


}
