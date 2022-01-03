// Recommended way for POM(Page Object Model) way
//

package _TestNotes.hybrid_driven_framework.POM.java;

import _TestNotes.hybrid_driven_framework.POM.pages.ToolTipPageFactory;
import org.testng.annotations.Test;

public class testToolTipFactory extends BaseTest {

    @Test
    public void testToolTip(){
        driver.get("http://leafground.com/pages/tooltip.html");
        ToolTipPageFactory toolTipPageFactory = new ToolTipPageFactory(driver);
        toolTipPageFactory
                .login("test")
                .searchProduct("Iphone X");
    }
}
