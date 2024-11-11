package Com.Qaqart.todo.Pages;
import Com.Qaqart.todo.Base.BasePage;
import Com.Qaqart.todo.Utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;

public class LoginPage extends BasePage {

    //Attributes
    @FindBy(id = "email") //Email Attribute
    private WebElement Email;

    @FindBy(id = "password") //Password Attribute
    private WebElement Password;

    @FindBy(id = "submit") //Submit Button
    private WebElement submit;

    //Constructor with SuperMethod to Access driver of the Parent Class  => (BasePage)
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Methods

    //Setter and Getter
    public WebElement getEmail() {
        return Email;
    }
    public void setEmail(WebElement email) {
        Email = email;
    }
    public WebElement getPassword() {
        return Password;
    }
    public void setPassword(WebElement password) {
        Password = password;
    }
    public WebElement getSubmit() {
        return submit;
    }
    public void setSubmit(WebElement submit) {
        this.submit = submit;
    }

    //Specific Methods
    /* Login Method Take UserName , Password as a param
     * then click on Login
     * then Retrieve ToDoPage type because the successful login data will go to the todopage
     * Assert on the welcome message in ToDoPage
     */
    public ToDoPage Login(String email,String password) throws InterruptedException {
        Email.sendKeys(email);
        Password.sendKeys(password);
        click(submit);
        return new ToDoPage(driver);
    }
    //This method in every calling return the LoginPage
    public LoginPage load() throws IOException, InterruptedException {
        driver.get(new ConfigUtils().getBaseUrl());
        return this;
    }


}
