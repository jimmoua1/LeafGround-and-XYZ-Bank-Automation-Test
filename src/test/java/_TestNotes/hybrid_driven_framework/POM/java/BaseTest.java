// This is the BaseTest where repetitive test code put here

package _TestNotes.hybrid_driven_framework.POM.java;

import _TestNotes.hybrid_driven_framework.POM._notes.Logging;
import _TestNotes.hybrid_driven_framework.POM.utils.DriverUtil;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    org.apache.log4j.Logger Log = Logger.getLogger(Logging.class);
    public WebDriver driver;

    @BeforeTest
    public void setUp(){
                                                // Absolute Path
        PropertyConfigurator.configure("D:\\IntelliJ\\_Projects\\GenSparkMavenUI\\src\\test\\java\\_TestNotes\\hybrid_driven_framework\\POM\\resources\\log4j.properties");
        driver = DriverUtil.getDriver();
        driver.manage().window().maximize();
        Log.info("New driver instantiated");
    }

    @AfterTest
    public void tearDown(){
        System.out.println("Finish Test");
//        driver.quit();
    }

}
