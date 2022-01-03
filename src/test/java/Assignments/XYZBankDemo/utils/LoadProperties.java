package Assignments.XYZBankDemo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    LoadProperties loadProperties;
    static Properties properties = new Properties();

    public static void init(){
        try {
            properties.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/java/Assignments/XYZBankDemo/resources/properties.properties"));
        } catch (IOException error){
            error.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
