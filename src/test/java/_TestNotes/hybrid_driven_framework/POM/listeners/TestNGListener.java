package _TestNotes.hybrid_driven_framework.POM.listeners;

import Assignments._LeafGroundWebsite.listeners.Listener;
import _TestNotes.hybrid_driven_framework.POM.utils.DriverUtil;
import _TestNotes.hybrid_driven_framework.POM.utils.LoadProperties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static _TestNotes.hybrid_driven_framework.POM.utils.DriverUtil.getDriver;

// 1. Generates all "Override" ITestListeners
    // if test Start will go to "onTestStart"
    // if test Fail will go to "OnTestFailure"
    // .....etc

// 2. either import to the "Test Class" on Top of the whole test
    // @Listeners(Listener.class)

        // Or

// the global testing XML file (testing.xml)
    //      <suite name="All Test Suite">
    //          <listeners>         // directory of "listener" file location here
    //              <listener class-name="test.listeners.TestNGListener"></listener>
    //          </listeners>
    //          <test>
    //          </test>
    //      </suite>

public class TestNGListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // result shown as text in console
        System.out.println(result);

    // can screenshot here too
        // ScreenShot name
            // Evaluate -> put in "result.getMethod().getMethodName()"
                // result="name", that name is the png file name to put into screenshot
                    // OR
                // result.getMethod().getMethodName() just put in

        // if don't know where path is located
            // Evaluate -> System.getProperty("user.dir")
                // result="file directory"
                    // OR
                // System.getProperty("user.dir") just put it in.

        // Can do the same for Folder directory which is "result.getTestClass().getName()"

                                            // getDriver() --> for single chrome driver at "DriverUtil" Folder
        File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotAbsolutePath = System.getProperty("user.dir")  + "\\failedScreenShots\\" + result.getMethod().getMethodName() + ".png";
            FileUtils.copyFile(screenshot, new File(screenshotAbsolutePath));
            String path = "<img src=\"" + screenshotAbsolutePath + "\" />";
            Reporter.log(screenshotAbsolutePath);
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    // For repetitive getting URL page when starting Test
    @Override
    public void onStart(ITestContext context) {
        LoadProperties.init();
    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
