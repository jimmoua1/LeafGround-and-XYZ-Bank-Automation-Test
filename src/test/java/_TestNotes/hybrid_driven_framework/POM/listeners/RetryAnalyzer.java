
// Use this to retry if (Flaky fail test case) 4 times because of "int retryLimit = 4"
//  This is a RetryAnalyzer in "listeners" folder but not a Listener file.

package _TestNotes.hybrid_driven_framework.POM.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int counter = 0;
    int retryLimit = 4;

    @Override
    public boolean retry(ITestResult result){

        if(counter < retryLimit)  {
            counter++;
            return true;
        }
        return false;
    }
}
