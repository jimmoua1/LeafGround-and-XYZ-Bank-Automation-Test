package _TestNotes.hybrid_driven_framework.POM._notes;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static _TestNotes.hybrid_driven_framework.POM.utils.DriverUtil.getDriver;

public class ScreenShotInCalendarFormat implements ITestListener {

    // ScreenShot in calendar format | This is implemented in Listeners
    @Override
    public void onTestFailure(ITestResult result) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String methodName = result.getName();
                                        // getDriver() here from "DriverUtil"
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\failedScreenShots\\";
            File destFile = new File((String) reportDirectory + "\\failedScreenShots\\" + methodName + "_" + formatter.format(calendar.getTime()) + ".png");
            FileUtils.copyFile(scrFile, destFile);
            Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");  // report a path of the screenshot
        } catch (IOException error){
            error.printStackTrace();
        }
    }
}
