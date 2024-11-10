package Com.Qaqart.todo.Request;

import com.github.javafaker.Faker;

public class User {
    private String email;
    private String password;

    public String setAndGetEmail(String email) {
        this.email = email;
        return this.email;
    }
    public String setAndGetPassword(String password) {
        this.password = password;
        return this.password;
    }
    public String GenerateFakerUser(){
        String RequestBody
                =String.format
                ("{\n" +
                "    \"firstName\":\"%s\",\n" +
                "    \"lastName\":\"%s\",\n" +
                "    \"email\":    \"%s\",\n" +
                "    \"password\": \"%s\"\n" +
                "}"
                ,new Faker().name().firstName()
                ,new Faker().name().lastName()
                ,new Faker().internet().emailAddress()
                ,new Faker().internet().password());
        return RequestBody;
    }
    public String LoginWithAPIUser(String Email,String Password){
        String RequestBody
                =String.format
                ("{\n" +
                "    \"email\":    \"%s\",\n" +
                "    \"password\": \"%s\"\n" +
                "}\n"
                ,setAndGetEmail(Email)
                ,setAndGetPassword(Password));
        return RequestBody;
    }
}
