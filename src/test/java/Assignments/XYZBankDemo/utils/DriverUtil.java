package Assignments.XYZBankDemo.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DriverUtil {
    static WebDriver driver;

    public static WebDriver getDriver(){
        // Converting this to below - line 18
//        if (driver == null){
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        }
//        return driver;

        String browser = LoadProperties.getProperty("browser");
        try {
            if (driver == null) {
                // Factory Design Pattern | more information on this area code at LeafGround Project
                if (browser.contains("chrome")){
                    WebDriverManager.chromedriver().browserVersion("95").setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setHeadless(true);
                    Map<String, Object> prefs = new HashMap<String, Object>();
                    prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
                    chromeOptions.setExperimentalOption("prefs", prefs);
                    driver = new ChromeDriver(chromeOptions);
                }
                if (browser.contains("firefox")){
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }
}
