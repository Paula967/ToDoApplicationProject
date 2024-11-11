package Com.Qaqart.todo.Base;
import Com.Qaqart.todo.Factory.DriverFactory;
import Com.Qaqart.todo.Utils.CookiesUtils;
import io.restassured.http.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.util.List;

public class BaseTest {
    protected ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }
    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    @BeforeClass
    public void setup() throws IOException {
        WebDriver driver=new DriverFactory().Initialize();
        setDriver(driver);

    }
    @AfterClass
    public void Quite(){
        if (getDriver() != null) {
           getDriver().quit();
        }

    }

    public void InjectCookiesToBrowser(List<Cookie> RestAssuredCookie){
        List< org.openqa.selenium.Cookie>SeleniumCookies =
                CookiesUtils.
                        ConvertResTAssuredCookiesToSeleniumCookies(RestAssuredCookie);
        for(org.openqa.selenium.Cookie cookies:SeleniumCookies){
            getDriver().manage().addCookie(cookies);
        }
    }

}

