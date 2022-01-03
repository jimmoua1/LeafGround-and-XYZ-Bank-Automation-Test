// Website test at
// https://docs.google.com/spreadsheets/d/1--CdC7xG2TTfYpJaUJUk9EPgGAy5kASJDftR8IL3kig/edit#gid=0

package Assignments.XYZBankDemo.java;

import Assignments.XYZBankDemo.utils.DriverUtil;
import _TestNotes.hybrid_driven_framework.POM._notes.Logging;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    Logger Log = Logger.getLogger(Logging.class);
    static WebDriver driver;

    @BeforeTest
    public void setUp(){
        PropertyConfigurator.configure("D:\\IntelliJ\\_Projects\\GenSparkMavenUI\\src\\test\\java\\Assignments\\XYZBankDemo\\resources\\log4j.properties");
        driver = DriverUtil.getDriver();
        Log.info("New driver instantiated");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closing(){
        System.out.println("Finish Test");
        driver.quit();
    }
}
