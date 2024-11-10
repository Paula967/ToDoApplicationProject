package Com.Qaqart.todo.Utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {
    /* This function take a filePath as a Parameter
    * And Read the data of this file
    * Then Return these data
     */
    public static Properties LoadProperties(String filepath) throws IOException {
        File file=new File(filepath);
        InputStream inputStream=new FileInputStream(file);
        Properties properties=new Properties();
        properties.load(inputStream);
        return properties;
    }
}
