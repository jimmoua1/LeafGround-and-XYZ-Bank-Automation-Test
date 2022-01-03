// Using one Driver only format for ScreenShot

package _TestNotes.hybrid_driven_framework.POM.utils;

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

    private DriverUtil(){

    }

// run "mvn test" in terminal to test it

    public static WebDriver getDriver(){
        // Get the browser type in "properties.properties"
        String browser = LoadProperties.getProperty("browser");
        if (driver == null){
            WebDriverManager.chromedriver().browserVersion("95").setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setHeadless(true);
//      chromeOptions.setHeadless(true);  --> if parallel run with high cpu run, just make this true to ignore usage, testing in back-ground
//      chromeOptions.addArguments(" parameters to add here "); --> add parameters to the driver test
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
            chromeOptions.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver();      // also known as "Factory design pattern" if more than one
        }
        if (browser.contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        return driver;
    }
}


