package Assignments._LeafGroundWebsite.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    LoadProperties loadProperties;
    static Properties properties = new Properties();

    public static void init(){
        try {
    // For other type of region websites | .com is US | .eu is EU | etc....
//            String prop = System.getProperty("region");
//            if (prop.contains("us"))
//                properties.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/java/Assignments/_LeafGroundWebsite/resources/properties.properties"));
//            if (prop.contains("eu"))
//                properties.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/java/Assignments/_LeafGroundWebsite/resources/properties.properties"));

            properties.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/java/Assignments/_LeafGroundWebsite/resources/properties.properties"));

        } catch (IOException error){
            error.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
