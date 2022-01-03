package _TestNotes.hybrid_driven_framework.POM._notes;

import _TestNotes.hybrid_driven_framework.POM.java.BaseTest;
import _TestNotes.hybrid_driven_framework.POM.pages.ToolTipPageFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static _TestNotes.hybrid_driven_framework.POM.utils.DriverUtil.getDriver;

public class ScreenShots extends BaseTest {

    // example Test
    @Test
    public void testToolTip(){
        driver.get("http://www.leafground.com/pages/tooltip.html");
        ToolTipPageFactory toolTipPageFactory = new ToolTipPageFactory(driver);
        toolTipPageFactory.login("aaaa")
                .searchProduct("sssss");
    }

// -------------- ScreenShot Test -------------------------------------------------
    // This can be place in "@AfterMethod" test or in any test cases
    @AfterMethod
    public void afterMethod(){              // getDriver() --> single driver from "DriverUtil"
        File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("D:\\IntelliJ\\_Projects\\GenSparkMavenUI\\failedScreenShots\\failed.png"));
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }
}
