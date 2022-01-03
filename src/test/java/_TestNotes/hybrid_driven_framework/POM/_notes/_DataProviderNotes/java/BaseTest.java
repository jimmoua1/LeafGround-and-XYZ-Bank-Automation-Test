// This BaseTest example for "DataProviderTest"

package _TestNotes.hybrid_driven_framework.POM._notes._DataProviderNotes.java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

// regression testing
public class BaseTest {

    // Data Provider in "BaseTest"
    //  name = "can name this data"
    //  parallel = "true -> run cases at same time depends on "threadPoolSize"..."
            // can mention "parallel" in testing.xml file
                //<test parallel = "classes, methods, etc...">  | recommended on "classes" level
    @org.testng.annotations.DataProvider(name = "dataProvider", parallel = true)
    public Object[][] data1(){
        return new Object[][]{
            // keep in mind these are example like XPATHS
                {"valid username", "valid password", "login successful"},
                {"invalid username", "invalid password", "login failed"},
                {"", "", "login failed"},
                {"asdasdasdasd", "asdasdasdasd", "login failed"},
        };
    }
}
