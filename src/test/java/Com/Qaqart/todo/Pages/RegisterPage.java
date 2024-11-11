package Com.Qaqart.todo.Pages;
import Com.Qaqart.todo.Base.BasePage;
import Com.Qaqart.todo.Utils.ConfigUtils;
import Com.Qaqart.todo.config.EndPoints;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;


public class RegisterPage extends BasePage {

    //Attributes
    @FindBy(xpath = "//input[@data-testid='first-name']") //FirstName Attribute
    private WebElement FirstName;

    @FindBy(xpath = "//input[@data-testid='last-name']") //LastName Attribute
    private WebElement LastName;

    @FindBy(xpath = "//input[@data-testid='email']") //Email Attribute
    private WebElement Email;

    @FindBy(xpath = "//input[@data-testid='password']") //Password Attribute
    private WebElement Password;

    @FindBy(xpath = "//input[@data-testid='confirm-password']") //Confirmation Attribute
    private WebElement ConfirmPassword;

    @FindBy(xpath = "//div[@class='sc-ftvSup cQlBkf']/button") //SignUp Button
    private WebElement SignUpButton;

    private String BaseURI;

    public String getBaseURI() {
        return BaseURI;
    }

    public void setBaseURI(String baseURI) {
        BaseURI = baseURI;
    }

    //Constructor with SuperMethod to Access driver of the Parent Class  => (BasePage)
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Methods
    /* register Method to Generate FakerUsers Automatically and Return ToDoPage Type
    * because the successful data will lead to the todoPage
    * and assertion on Welcome Message
     */

    public ToDoPage registerPage() throws IOException {
        driver.get(new ConfigUtils().getBaseUrl()+ EndPoints.REGISTER_PAGE_ENDPOINT);
        String pass=new Faker().internet().password();
        FirstName.sendKeys(new Faker().name().firstName());
        LastName.sendKeys(new Faker().name().lastName());
        Email.sendKeys(new Faker().internet().emailAddress());
        Password.sendKeys(pass);
        ConfirmPassword.sendKeys(pass);
        SignUpButton.click();
        return new ToDoPage(driver);
    }
}
