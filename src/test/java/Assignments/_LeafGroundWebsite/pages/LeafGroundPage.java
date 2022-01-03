package Assignments._LeafGroundWebsite.pages;

import _TestNotes.hybrid_driven_framework.POM.utils.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static Assignments._LeafGroundWebsite.utils.DriverUtil.getDriver;

public class LeafGroundPage {

    public LeafGroundPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

// testEditBox
    @FindBy(xpath = "//a[@href='pages/Edit.html'][1]")
    public WebElement EditImage;

    @FindBy(id = "email")
    public WebElement textBox1;

    @FindBy(xpath = "//input[@value='Append ']")
    public WebElement textBox2;

    @FindBy(xpath = "//input[@name='username' and @value='TestLeaf']")
    public WebElement textBox3;

    @FindBy(xpath = "//input[@name='username' and @value='Clear me!!']")
    public WebElement textBox4;

    @FindBy(xpath = "//input[@style=\"width:350px;background-color:LightGrey;\"]")
    public WebElement textBox5;

// testButton
    @FindBy(id = "home")
    public WebElement button1;

    @FindBy(id = "position")
    public WebElement button2;

    @FindBy(id = "color")
    public WebElement button3;

    @FindBy(id = "size")
    public WebElement button4;

// testHyperLink
    @FindBy(xpath = "//a[@href='../home.html'][1]")
    public WebElement hyperlink1;

    @FindBy(xpath = "//a[text()='Find where am supposed to go without clicking me?']")
    public WebElement hyperlink2;

    @FindBy(xpath = "//a[text()='Go to Home Page' and @style='color: #CC0000']")
    public WebElement hyperlink3;

    @FindBy(xpath = "//a[@href='error.html']")
    public WebElement hyperlink4;

// testImage
    @FindBy(xpath = "//img[@src='../images/home.png']")
    public WebElement image1;

    @FindBy(xpath = "//img[@src='../images/abcd.jpg']")
    public WebElement image2;

    @FindBy(xpath = "//img[@src=\"../images/keyboard.png\"]")
    public WebElement image3;

// testDropDown
    @FindBy(id = "dropdown1")
    public WebElement firstDropdown;

    @FindBy(xpath = "//select[@name='dropdown2']")
    public WebElement secondDropdown;

    @FindBy(id = "dropdown3")
    public WebElement thirdDropdown;

    @FindBy(className = "dropdown")
    public WebElement fourthDropdown;

    @FindBy(xpath = "//div[5]//select")
    public WebElement fifthDropdown;

    @FindBy(xpath = "//select[@multiple='']")
    public WebElement sixthDropdown;

// testRadioButton
    @FindBy(xpath = "//input[@id='yes']")
    public WebElement firstRadio;

    @FindBy(xpath = "//label[@for='yes']")
    public WebElement firstRadio_Text;

    @FindBy(xpath = "//label[@for='Checked']")
    public WebElement secondRadio;

    @FindBy(xpath = "//input[@name=\"age\"]")
    public List<WebElement> thirdRadio;

// testCheckBox
    @FindBy(xpath = "//div[@class='example'][1]//input[@type='checkbox']")
    public List<WebElement> firstBox;

    @FindBy(xpath = "//div[@class='example'][2]//input[@type='checkbox']")
    public WebElement secondBox;

    @FindBy(xpath = "//div[@class='example'][3]//input[@type='checkbox']")
    public List<WebElement> thirdBox;

    @FindBy(xpath = "//div[@class='example'][4]//input[@type='checkbox']")
    public List<WebElement> fourthBox;

// testCheckBox
    @FindBy(id = "table_id")
    public WebElement table;

    @FindBy(xpath = "//th")
    public List<WebElement> column;

// testAlert
    @FindBy(xpath = "//button[text()='Alert Box']")
    public WebElement alert1;

    @FindBy(xpath = "//button[text()='Confirm Box']")
    public WebElement alert2;

    @FindBy(xpath = "//button[@onclick='confirmPrompt()']")
    public WebElement alert3;

    @FindBy(xpath = "//p[@id='result1']")
    public WebElement promptBox;

    @FindBy(xpath = "//button[@onclick='lineBreaks()']")
    public WebElement alert4;

// testFrame
    @FindBy(xpath = "//iframe")
    public List<WebElement> frame1;

    @FindBy(xpath = "//iframe[@src='page.html']")
    public List<WebElement> frame2;

    @FindBy(xpath = "//iframe[@src='countframes.html']")
    public List<WebElement> frame3;

// testWindow
    @FindBy(id = "home")
    public WebElement buttonWindow1;

    @FindBy(xpath = "(//button[contains(@onclick, 'openWindows')])[1]")
    public WebElement buttonWindow2;

    @FindBy(xpath = "(//button[contains(@onclick, 'openWindows')])[2]")
    public WebElement buttonWindow3;

    @FindBy(xpath = "//button[contains(@onclick, 'openWindowsWithWait')]")
    public WebElement buttonWindow4;

// testCalendar
    @FindBy(id = "datepicker")
    public WebElement calendar_id;

    @FindBy(xpath = "//a[@data-handler='next']")
    public WebElement calendar_Data;

    @FindBy(xpath = "//a[text()='10']")
    public WebElement calendar_10;

// testCalendar | testDroppable(some here)
    @FindBy(id = "draggable")
    public WebElement picture1;

// testDroppable
    @FindBy(id = "droppable")
    public WebElement drop1;

// testSelectable
    @FindBy(xpath = "//div[@id='mydiv']//li")
    public List<WebElement> select1;

// testSortable
    @FindBy(xpath = "(//ul[@id='sortable']//following::li)[1]")
    public WebElement sortItem1;

    @FindBy(xpath = "(//ul[@id='sortable']//following::li)[2]")
    public WebElement sortItem2;

    @FindBy(xpath = "(//ul[@id='sortable']//following::li)[4]")
    public WebElement sortItem3;

    @FindBy(xpath = "(//ul[@id='sortable']//following::li)[5]")
    public WebElement sortItem4;

// testAutoComplete
    @FindBy(id = "tags")
    public WebElement textfield1;

    @FindBy(id = "ui-id-2")
    public WebElement textfield2;

// testDownloadFiles
    @FindBy(xpath = "//div[@class='todo']//a[text()='Download Excel']")
    public WebElement downloadExcel;

    @FindBy(xpath = "(//div[@class='todo']//following::a)[1]")
    public WebElement downloadPDF;

    @FindBy(xpath = "(//div[@class='todo']//following::a)[2]")
    public WebElement downloadText;

// testUploadFiles
    @FindBy(xpath = "//input[@name='filename']")
    public WebElement uploadFile;

// testToolTip
    @FindBy(id = "age")
    public WebElement age_id;

    @FindBy(xpath = "//div[@class = 'ui-tooltip-content']")
    public WebElement textPath;

// testWaitToDisappear
    @FindBy(id = "btn")
    public WebElement wait_BTN;

    @FindBy(id = "show")
    public WebElement textOnWait;

// testWaitToAppear
    @FindBy(xpath = "//button[@id='btn']")
    public WebElement wait_appear;

// testWaitForTextChange
    @FindBy(xpath = "//button[@id='btn' and @onclick='clicked()']")
    public WebElement wait_text;

// testWaitForAlert
    @FindBy(xpath = "//button[text()='Click to get Alert']")
    public WebElement button_click_alert;

// testMouseHover
    @FindBy(xpath = "//a[text()='TestLeaf Courses']")
    public WebElement mouse_hover_field;

    @FindBy(xpath = "//li//ul//li//a")
    public List<WebElement> mouse_hover_list;

    @FindBy(xpath = "//li//ul//li//a")
    public WebElement mouse_hover_list_Element;

// testAdvanceWebTable
    @FindBy(xpath = "//tr//th[text()='Name']")
    public WebElement nameFilter;

    @FindBy(xpath = "//tr//td[2]")
    public List<WebElement> nameValue;

    @FindBy(xpath = "//tr//td[2]")
    public List<WebElement> nameListVerify;

//-------------------------------------------------------------------------------

// testEditBox
    public WebElement textBox1(){
        return textBox1;
    }

    public WebElement textBox2(){
        return textBox2;
    }

    public WebElement textBox3(){
        return textBox3;
    }

    public WebElement textBox4(){
        return textBox4;
    }

    public WebElement textBox5(){
        return textBox5;
    }

// testButton
    public WebElement firstButton(){
        return button1;
    }

    public WebElement secondButton(){
        return button2;
    }

    public String thirdButton(){
        return button3.getAttribute("style");
    }

    public WebElement fourthButton(){
        return button4;
    }

// testHyperLink
    public WebElement firstHyperLink(){
        return hyperlink1;
    }

    public WebElement secondHyperLink(){
        return hyperlink2;
    }

    public WebElement thirdHyperLink(){
        return hyperlink3;
    }

    public WebElement fourthHyperLink(){
        return hyperlink4;
    }

// testImage
    public WebElement firstImage(){
        return image1;
    }

    public WebElement secondImage(){
        return image2;
    }

    public WebElement thirdImage(){
        return image3;
    }

// testDropDown
    public WebElement firstDropDown(){
        return firstDropdown;
    }

    public WebElement secondDropDown(){
        return secondDropdown;
    }

    public WebElement thirdDropDown(){
        return thirdDropdown;
    }

    public WebElement fourthDropDown(){
        return fourthDropdown;
    }

    public WebElement fifthDropDown(){
        return fifthDropdown;
    }

    public WebElement sixthDropDown(){
        return sixthDropdown;
    }

// testRadioButton
    public WebElement firstRadioButton(){
        return firstRadio;
    }

    public WebElement firstRadioButtonText(){
        return firstRadio_Text;
    }

    public WebElement secondRadioButton(){
        return secondRadio;
    }

    public List<WebElement> thirdRadioButton(){
        return thirdRadio;
    }

// testCheckBox
    public List<WebElement> firstCheckBox(){
        return firstBox;
    }

    public WebElement secondCheckBox(){
        return secondBox;
    }

    public List<WebElement> thirdCheckBox(){
        return thirdBox;
    }

    public List<WebElement> fourthCheckBox(){
        return fourthBox;
    }

// testTable
    public WebElement TableID(){
        return table;
    }

    public List<WebElement> columns(){
        return column;
    }

// testAlert | testWaitForTextChange(some here) | testWaitForAlert(some here) | testMouseHover(some here)
    public WebElement alertButton1(){
        return alert1;
    }

    public WebElement alertButton2(){
        return alert2;
    }

    public WebElement alertButton3(){
        return alert3;
    }

    public LeafGroundPage inputAlertKeys(){
        getDriver().switchTo().alert().sendKeys("Typing Testing");
        return this;
    }

    public WebElement promptBoxAlert(){
        return promptBox;
    }

    public WebElement alertButton4(){
        return alert4;
    }

    public void acceptAlert(){
        getDriver().switchTo().alert().accept();
    }

    public void dismissAlert(){
        getDriver().switchTo().alert().dismiss();
    }

    public String getAlertText(){
        return getDriver().switchTo().alert().getText();
    }

// testFrame
    public List<WebElement> firstFrame(){
        return frame1;
    }

    public List<WebElement> secondFrame(){
        return frame2;
    }

    public List<WebElement> thirdFrame(){
        return frame3;
    }

// testWindow
    public WebElement firstWindow(){
        return buttonWindow1;
    }

    public void getListandClose1(){
        Set<String> windows = getDriver().getWindowHandles();
        ArrayList<String> listStr = new ArrayList<>(windows);
        getDriver().switchTo().window(listStr.get(1));
        getDriver().close();
        getDriver().switchTo().window(listStr.get(0));
    }

    public WebElement secondWindow(){
        return buttonWindow2;
    }

    public Set<String> getMultipleWindows(){
        return getDriver().getWindowHandles();
    }

    public void getListandClose2(){
        Set<String> windows = getDriver().getWindowHandles();
        ArrayList<String> listStr = new ArrayList<>(windows);
        listStr = new ArrayList<>(windows);
        windows = getMultipleWindows();
        Assert.assertEquals(windows.size(), 3);
        getDriver().switchTo().window(listStr.get(2));
        getDriver().close();
        getDriver().switchTo().window(listStr.get(1));
        getDriver().close();
        getDriver().switchTo().window(listStr.get(0));
    }

    public WebElement thirdWindow(){
        return buttonWindow3;
    }

    public void getListandClose3(){
        Set<String> windows = getDriver().getWindowHandles();
        ArrayList<String> listStr = new ArrayList<>(windows);
        windows = getDriver().getWindowHandles();
        listStr = new ArrayList<>(windows);
        getDriver().switchTo().window(listStr.get(2));
        getDriver().close();
        getDriver().switchTo().window(listStr.get(1));
        getDriver().close();
        getDriver().switchTo().window(listStr.get(0));
    }

    public WebElement fourthWindow(){
        return buttonWindow4;
    }

    public void getListandClose4(){
        Set<String> windows = getDriver().getWindowHandles();
        ArrayList<String> listStr = new ArrayList<>(windows);
        listStr = new ArrayList<>(windows);
        windows = getDriver().getWindowHandles();
        Assert.assertEquals(windows.size(), 3);
        getDriver().switchTo().window(listStr.get(2));
        getDriver().close();
        getDriver().switchTo().window(listStr.get(1));
        getDriver().close();
        getDriver().switchTo().window(listStr.get(0));
    }

// testCalendar
    public WebElement calendarID(){
        return calendar_id;
    }

    public WebElement calendarData(){
        return calendar_Data;
    }

    public WebElement calendarPick10(){
        return  calendar_10;
    }

// testDraggable | testDraggable(some here)
    public WebElement dragPicture(){
        return picture1;
    }

// testDraggable
    public WebElement dropPicture(){
        return drop1;
    }

// testSelectable
    public List<WebElement> selectList(){
        return select1;
    }

// testSortable
    public WebElement item1(){
        return sortItem1;
    }

    public WebElement item2(){
        return sortItem2;
    }

    public WebElement item4(){
        return sortItem3;
    }

    public WebElement item5(){
        return sortItem4;
    }

// testAutoComplete
    public WebElement autoCompleteField(){
        return textfield1;
    }

    public WebElement getAutoCompleteInput(){
        return textfield2;
    }

// testDownloadFiles
    public WebElement downloadExcelFile(){
        return downloadExcel;
    }

    public WebElement downloadPDFFile(){
        return downloadPDF;
    }

    public WebElement downloadTextFile(){
        return downloadText;
    }

// testUploadFiles
    public WebElement uploadFiles(){
        return uploadFile;
    }

// testToolTip
    public WebElement getAgeID(){
        return age_id;
    }

    public WebElement displayText(){
        return textPath;
    }

// testWaitToDisappear
    public WebElement waitByBTN(){
        return wait_BTN;
    }

    public WebElement textID(){
        return textOnWait;
    }

// testWaitToAppear
    public WebElement waitForAppear(){
        return wait_appear;
    }

// testWaitForTextChange
    public WebElement waitforText() {
        return wait_text;
    }

// testWaitForAlert
    public WebElement buttonTextAlert() {
        return button_click_alert;
    }

// testMouseHover
    public WebElement blankMouseHoverField() {
        return mouse_hover_field;
    }

    public List<WebElement> mouseHoverList(){
        return mouse_hover_list;
    }

    public WebElement mouseHoverListElement(){
        return mouse_hover_list_Element;
    }

// testAdvanceWebTable
    public WebElement clickNameFilter() {
        return nameFilter;
    }

    public List<WebElement> storeName() {
        return nameValue;
    }

    public List<WebElement> verifyNameList() {
        return nameListVerify;
    }

}
