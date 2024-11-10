package Com.Qaqart.todo.Utils;

import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookiesUtils {
    //This Function Convert RestAssuredCookies To SeleniumCookies To Save the UserData into Selenium
    public  static List<Cookie> ConvertResTAssuredCookiesToSeleniumCookies(List<io.restassured.http.Cookie> RestAssuredCookies){
        List<Cookie> SeleniumReturnedCookie=new ArrayList<>();
        for(io.restassured.http.Cookie restcookie:RestAssuredCookies) {
            org.openqa.selenium.Cookie cookie = new org.openqa.selenium.Cookie(restcookie.getName(), restcookie.getValue());
            SeleniumReturnedCookie.add(cookie);
        }
        return SeleniumReturnedCookie;
    }
}
