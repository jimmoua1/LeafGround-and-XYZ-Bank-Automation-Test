package _TestNotes.hybrid_driven_framework.POM.java;

import _TestNotes.hybrid_driven_framework.POM.pages.ToolTipPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

// regression testing
public class TestL extends BaseTest {

    @Test
    public void testToolTip(){
    // converting URL to string
//        String url = LoadProperties.init().getProperty("url");
//        driver.get(url + "/pages/tooltip.html");

    // Convert (this code TO line 26-30) for POM(Page Object Model)
//        WebElement element = driver.findElement(By.id("age"));
//        Actions action = new Actions(driver);
//        action.moveToElement(element).perform();
//        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'ui-tooltip-content']")).isDisplayed());


        ToolTipPage toolTipPage = new ToolTipPage(driver);
        WebElement element = toolTipPage.getAge();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Assert.assertTrue(toolTipPage.getToolTip().isDisplayed());


    // Calendar for DriverUtil
        Reporter.log("<a href= >" );
    }

}
