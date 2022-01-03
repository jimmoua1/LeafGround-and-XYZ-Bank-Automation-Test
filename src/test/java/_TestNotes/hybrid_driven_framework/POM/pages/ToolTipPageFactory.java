// Recommended POM(Page Object Model) strategy for making page to check for more

package _TestNotes.hybrid_driven_framework.POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolTipPageFactory {

    private WebDriver driver; // can go private

    public ToolTipPageFactory(WebDriver driver){
        this.driver = driver;
        // static method, this page code particular driver initialize
        PageFactory.initElements(driver, this);   // invoke the "@FindBy" below and
    }

    // driver.findElement(By.id("age"));
    @FindBy(id = "age")
    private WebElement age;

    // driver.findElement(By.xpath("//div[@class = 'ui-tooltip-content']"))
    @FindBy(xpath = "//div[@class ='ui-tooltip-content']")
    public WebElement toolTip;

    // example for loginbutton (xpath is NOT right)
    @FindBy(xpath = "//div[@class ='ui-tooltip-content']")
    public WebElement loginButton;

    // example for searching product (xpath is NOT right)
    @FindBy(xpath = "//div[@class ='ui-tooltip-content']")
    public WebElement searchProductName;

//-------------------------------------------------------------------------------
    // example converting to age above to here
    public WebElement getAge(){
        return age;
    }

    public void setAge(String str){
        age.sendKeys(str);
    }


    // below are called "Fluent design pattern" because of "return this"
        // login
    public ToolTipPageFactory login(String username){
        age.sendKeys(username);
        loginButton.click();
        return this;
    }

        // search a Product
    public ToolTipPageFactory searchProduct(String productName){
        searchProductName.sendKeys(productName);
        return this;
    }

}
