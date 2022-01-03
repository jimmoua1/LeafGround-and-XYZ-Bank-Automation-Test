package Assignments._LeafGroundWebsite.java;

import Assignments._LeafGroundWebsite.utils.DriverUtil;
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
        PropertyConfigurator.configure("D:\\IntelliJ\\_Projects\\GenSparkMavenUI\\src\\test\\java\\Assignments\\_LeafGroundWebsite\\resources\\log4j.properties");
        driver = DriverUtil.getDriver();       // using same driver instead of new Chrome/browser everytime
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
