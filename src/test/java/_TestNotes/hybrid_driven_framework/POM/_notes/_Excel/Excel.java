// This Excel is an example Test Case Priority to what can be change or so
package _TestNotes.hybrid_driven_framework.POM._notes._Excel;

import _TestNotes.hybrid_driven_framework.POM.java.BaseTest;
import _TestNotes.hybrid_driven_framework.POM.pages.ToolTipPageFactory;
import _TestNotes.hybrid_driven_framework.POM.utils.ExcelUtils;
import _TestNotes.hybrid_driven_framework.POM.utils.LoadProperties;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class Excel extends BaseTest {

    @Test
    public void testToolTip() throws IOException {
        Map<String, String> testData = ExcelUtils.readExcel().get("ToolTip");
        String url = LoadProperties.getProperty("url");
        driver.get(url +"/pages/tooltip.html");
        ToolTipPageFactory toolTipPageFactory = new ToolTipPageFactory(driver);
                                // not hardcoded since change is in Excel
        toolTipPageFactory.login(testData.get("Username"));
    }

}
