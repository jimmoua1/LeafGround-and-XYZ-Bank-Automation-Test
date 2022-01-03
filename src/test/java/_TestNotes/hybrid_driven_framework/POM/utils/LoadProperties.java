// For repetitive single URL using "properties"
//  driver.get("https://www.google.com")
//  drover.get("https://www.google.com/page1") and so on

package _TestNotes.hybrid_driven_framework.POM.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    LoadProperties loadProperties;
    static Properties properties = new Properties();

    private LoadProperties(){

    }

    public static void init(){
        try {
            // D:/IntelliJ/_Projects/GenSparkMavenUI/src/test/java/_TestNotes/hybrid_driven_framework/POM/utils/LoadProperties.java
            properties.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/java/_TestNotes/hybrid_driven_framework/POM/resources/properties.properties"));
        } catch (IOException error){
            error.printStackTrace();
        }
    }

    public static String getProperty(String key){
        init();
        return properties.getProperty(key);
    }
}
