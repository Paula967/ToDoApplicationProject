package Com.Qaqart.todo.Apis;
import Com.Qaqart.todo.Request.User;
import Com.Qaqart.todo.Utils.ConfigUtils;
import Com.Qaqart.todo.config.EndPoints;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class LoginAPI {
   //Attributes
    private Cookies RestAssuredCookies;
    private String AccessToken;
    private String UserId;
    private String FirstName;

   //Getter
    public String getUserId() {
        return UserId;
    }
    public String getFirstName() {
        return FirstName;
    }
    public Cookies getRestAssuredCookies() {
        return this.RestAssuredCookies;
    }
    public String getAccessToken() {
        return this.AccessToken;
    }

    //Methods
    //This Function Login With Api
    public void Login() throws IOException {
       User user=new User();
       Response response =
               given()
                   .baseUri(new ConfigUtils().getBaseUrl())
                   .header("Content-Type", "application/json")
                   .body(user.LoginWithAPIUser(new ConfigUtils().getEmail(),new ConfigUtils().getPassword()))
                   .log().all()
               .when()
                   .post(EndPoints.LOGIN_API_ENDPOINT)
               .then()
                    .log().all()
                    .extract().response();
                    RestAssuredCookies=response.detailedCookies();
                    AccessToken=response.path("access_token");
                    UserId=response.path("userID");
                    FirstName=response.path("firstName");
   }
}
