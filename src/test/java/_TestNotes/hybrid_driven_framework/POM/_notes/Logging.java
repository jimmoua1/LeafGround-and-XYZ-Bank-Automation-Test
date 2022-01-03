package _TestNotes.hybrid_driven_framework.POM._notes;

import _TestNotes.hybrid_driven_framework.POM.java.BaseTest;
import _TestNotes.hybrid_driven_framework.POM.pages.ToolTipPageFactory;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Logging extends BaseTest {
    // make a variable, next import to "BaseTest", add some "Log", than `mvn test` on terminal
        // Check "logs"/main.log --> for the logs information
                                // call the test itself again
    Logger Log = Logger.getLogger(Logging.class);

    @Test
    public void testToolTip(){
        driver.get("http://leafground.com/pages/tooltip.html");
        Log.info("New driver instantiated");
        ToolTipPageFactory toolTipPageFactory = new ToolTipPageFactory(driver);
        Log.info("page factory configured");
        toolTipPageFactory
                .login("test")
                .searchProduct("Iphone X");
    }
}
