package Com.Qaqart.todo.Utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {

    private Properties properties;

    /*Send the File path to LoadProperties
    * Then the return data Store in variable properties as an object of Properties Class
     */
    public ConfigUtils() throws IOException {
        properties = PropertiesUtils.LoadProperties("src/test/java/Com/Qaqart/todo/config/Production.properities");
    }

    //Return the BaseUrl of The Website from production.properties File
    public  String getBaseUrl(){
       return properties.getProperty("baseUrl");
    }

    //Return the Email of The User from production.properties File
    public String getEmail(){
        return properties.getProperty("email");
    }

    //Return the Password of The Admin from production.properties File
    public String getPassword(){
        return properties.getProperty("password");
    }
}
