//   "POM/listeners/TestNGListener" file is required for this file

package _TestNotes.hybrid_driven_framework.POM._notes;

import _TestNotes.hybrid_driven_framework.POM.java.BaseTest;
import _TestNotes.hybrid_driven_framework.POM.listeners.TestNGListener;
import _TestNotes.hybrid_driven_framework.POM.pages.ToolTipPageFactory;
import _TestNotes.hybrid_driven_framework.POM.utils.LoadProperties;
import org.testng.annotations.Test;

// can put in testing.xml file located below "suite"
//      <suite name="All Test Suite">
//          <listeners>         // directory of "listener" file location here
//              <listener class-name="test.listeners.TestNGListener"></listener>
//          </listeners>
//          <test>
//          </test>
//        </suite>

// Make sure to add the "test Listener" from Edit Configuration..
//      Run the test -> stop -> Edit Configuration -> Listeners -> + -> search by name (here)

// implement Listeners here
@org.testng.annotations.Listeners(TestNGListener.class) // or @Listeners
public class Listeners extends BaseTest {

    // example Test
    @Test
    public void testToolTip(){
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/tooltip.html");
        ToolTipPageFactory toolTipPageFactory = new ToolTipPageFactory(driver);
        toolTipPageFactory.login("aaaa")
                .searchProduct("ssss");
    }

}
