package Com.Qaqart.todo.Factory;

import Com.Qaqart.todo.Utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.IOException;
import java.time.Duration;


public class DriverFactory {

    protected WebDriver driver;
    String browser=System.getProperty("browser","CHROME");
    public WebDriver Initialize() throws IOException {
        switch (browser)
        {
            case"CHROME":
                driver=new ChromeDriver();
                break;
            case"EDGE":
                driver=new EdgeDriver();
                break;
            case"FIREFOX":
                driver=new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("The browser is not supported");
        }
        driver.manage().window().maximize();
        ConfigUtils configUtils=new ConfigUtils();
        driver.get(configUtils.getBaseUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
        return driver;
    }
}
