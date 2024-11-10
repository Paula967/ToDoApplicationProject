package Com.Qaqart.todo.Apis;

import Com.Qaqart.todo.Request.User;

import Com.Qaqart.todo.Utils.ConfigUtils;
import Com.Qaqart.todo.config.EndPoints;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;


public class RegisterAPI {
    //Attributes
    private String BodyFirstName;
    private String BodyAccessToken;
    private String BodyUserId;
    private List<Cookie> RestAssuredRegisterCookies;

    //Getter
    public String getBodyAccessToken() {
        return this.BodyAccessToken;
    }
    public String getBodyUserId() {
        return BodyUserId;
    }
    public String getFirstName() {
        return BodyFirstName;
    }
    public List<Cookie> getRestAssuredRegisterCookies() {
        return this.RestAssuredRegisterCookies;
    }
    //Methods
    //This method Generate a User with Fake data and Register within The Api
    public void Register() throws IOException {
        User user=new User();
        Response rep=
        given()
                .baseUri(new ConfigUtils().getBaseUrl())
                .header("Content-Type", "application/json")
                .body(user.GenerateFakerUser())
                .log().all()
        .when()
                .post(EndPoints.REGISTER_API_ENDPOINT)
        .then()
                .log().all()
                .extract().response();
         if(rep.statusCode() !=201){
             throw  new RuntimeException("Your Data isWrong");
         }
         RestAssuredRegisterCookies=rep.detailedCookies().asList();
         BodyAccessToken = rep.path("access_token");
         BodyUserId =rep.path("userID");
         BodyFirstName=rep.path("firstName");
    }
}
