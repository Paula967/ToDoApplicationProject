package Com.Qaqart.todo.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends BaseTest {

  protected WebDriver driver;

    public BasePage(WebDriver driver) {
         this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//div[@class='sc-ezWOiH iOQdwL']/button")
    private WebElement LogoutButton;

    @FindBy(xpath = "//h2[@data-testid='welcome']")
    private WebElement Welcomemessage;

    public void click(WebElement element){
        element.click();
    }
    public void logout(){
        click(LogoutButton);
    }
    public boolean IsWelcomeMessageDisplayed() throws InterruptedException {
        return Welcomemessage.isDisplayed();
    }

}
