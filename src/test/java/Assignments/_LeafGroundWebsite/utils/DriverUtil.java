package Assignments._LeafGroundWebsite.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DriverUtil {
    static WebDriver driver;

    public static WebDriver getDriver(){
        // Converting this to below - line 26 to line 60
//        if (driver == null){
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        }
//        return driver;


        // This String variable is pulling from XML file
        String browser = LoadProperties.getProperty("browser");
        try {
            if (driver == null) {
                // To run and test on all common browsers, will use "browserstack.com" application
                    // for now will use "if" using chrome and firefox ==> Factory Design Pattern
                if (browser.contains("chrome")){
                                            // running chrome version 95
                    WebDriverManager.chromedriver().browserVersion("95").setup();
                    ChromeOptions chromeOptions = new ChromeOptions();

                    // To run it background use "setHeadless" --> true
                             chromeOptions.setHeadless(true);

                    // To disable the infobars when chrome/browser is launched
                            // chromeOptions.addArguments("disable-infobars"); ---> code is deprecated(no longer in code)
                        // But this code works
                            // chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                            // chromeOptions.setExperimentalOption("useAutomationExtension", false);


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
