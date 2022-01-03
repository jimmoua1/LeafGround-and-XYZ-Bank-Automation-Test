package _TestNotes.hybrid_driven_framework.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// POM -> Page Object Model
public class ToolTipPage {

// Converting these two lines
//    WebElement textBox = driver.findElement(By.id("age"));
//    Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'ui-tooltip-content']")).isDisplayed());

    By ageId = By.id("age");
    By toolTipXpath = By.xpath("//div[@class = 'ui-tooltip-content']");

    WebDriver driver;

    public ToolTipPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getAge(){
        return driver.findElement(ageId);
    }

    public WebElement getToolTip(){
        return driver.findElement(toolTipXpath);
    }

}

