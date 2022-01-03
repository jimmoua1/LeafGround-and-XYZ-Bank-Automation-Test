// This Test File is relied on added dependencies in pom.xml

package Assignments._LeafGroundWebsite.java;

import Assignments._LeafGroundWebsite.listeners.Listener;
import Assignments._LeafGroundWebsite.pages.LeafGroundPage;
import Assignments._LeafGroundWebsite.utils.ExcelUtil;
import Assignments._LeafGroundWebsite.utils.LoadProperties;
import _TestNotes.hybrid_driven_framework.POM._notes.Logging;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Listeners(Listener.class)
public class TestLeafPlayground extends BaseTest {
    // make a variable, next import to "BaseTest", add some "Log", than `mvn test` on terminal
        // Check "logs"/main.log --> for the logs information
                         // call the test itself again
    Logger Log = Logger.getLogger(Logging.class);

    @Test
    public void testEditBox() throws IOException {
        Map<String, String> testData = ExcelUtil.readExcel().get("testEditBox");
        // Going to Edit Page
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/Edit.html");
        Log.info("page factory configured");

        // Enter your email address
        LeafGroundPage editPage = new LeafGroundPage(driver);
        Log.info("New driver instantiated");
        editPage.textBox1()
                .sendKeys(testData.get("Input 1"));

        // Append a text and press keyboard tab
        editPage.textBox2()
                .sendKeys(testData.get("Input 2"), Keys.TAB);

        // Get default text entered
        editPage.textBox3().getAttribute("value");
        String defaultValue = editPage.textBox3().getAttribute("value");
        Assert.assertEquals(defaultValue, "TestLeaf");

        // Clear the text
        editPage.textBox4()
                .clear();

        // Confirm that edit field is disabled
        editPage.textBox5()
                .getAttribute("disabled");
        String disabled = editPage.textBox5().getAttribute("disabled");
        Assert.assertEquals(disabled, "true", "the field is enabled");
    }

    @Test
    public void testButton(){
        // go to Button Page
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/Button.html");

        // Click button to travel home page
        LeafGroundPage buttonPage = new LeafGroundPage(driver);
        buttonPage.firstButton()
                .click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.leafground.com/home.html");
        // Go back to the Button Test page
        driver.get(url + "/pages/Button.html");

        // Getting X and Y mouse coordinates
        int x = buttonPage.secondButton().getLocation().getX();
        int y = buttonPage.secondButton().getLocation().getY();
        System.out.println(x + " " + y);

        // Making sure button is "lightgreen"
        String style = buttonPage.thirdButton();
        Assert.assertTrue(style.contains("lightgreen"));

        // Finding height and width of the blue button
        int width = buttonPage.fourthButton().getSize().getWidth();
        int height = buttonPage.fourthButton().getSize().getHeight();
        System.out.println(width + "  " + height);
    }

    @Test
    public void testHyperLink() throws IOException {
        // Go to HyperLink Page
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/Link.html");

        // Go to Home Page
        LeafGroundPage hyperLinkPage = new LeafGroundPage(driver);
        hyperLinkPage.firstHyperLink().click();
        Assert.assertEquals(driver.getCurrentUrl(), url + "/home.html");
        driver.get(url + "/pages/Link.html");

        // Find where am supposed to go without clicking me?
        hyperLinkPage.secondHyperLink().getAttribute("href");
        String href = hyperLinkPage.secondHyperLink().getAttribute("href");
        System.out.println("URL is: " +href);

        // Go to Home Page (Interact with same link name)
        hyperLinkPage.thirdHyperLink().click();

        // Verify current url is same
        Assert.assertEquals(driver.getCurrentUrl(), url + "/home.html");

        // Verify am I broken?
        driver.get(url + "/pages/Link.html");
        WebElement brokenLink = hyperLinkPage.fourthHyperLink();
        String urlTest = brokenLink.getAttribute("href");

        // check url if status code is 200 or 404
        URL u = new URL(urlTest); // throws "MalformedURLException" is same as try/catch/finally
        // if having HttpURLConnection will throw "IOException"

        // open url site into exception
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        // calls the url
        huc.setRequestMethod("GET"); // get the url
        huc.connect();               // connect once you get the url

        // Verify if Link is broken or not - code status "200" or "400 or more"
        int respCode = huc.getResponseCode();
        if(respCode >= 400){
            System.out.println("Broken Link");
        } else {
            System.out.println("Valid Link");
        }
    }

    @Test
    public void testImage() throws IOException {
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/Image.html");

        // Verify same link
        Assert.assertEquals(driver.getCurrentUrl(), url + "/pages/Image.html");

        // Click on this image to go home page
        LeafGroundPage imagePage = new LeafGroundPage(driver);
        imagePage.firstImage().click();
        Assert.assertEquals(driver.getCurrentUrl(), url + "/home.html");

        // Am I Broken Image?
        driver.get(url + "/pages/Image.html");
        WebElement brokenLink1 = imagePage.secondImage();
        String urlTest = brokenLink1.getAttribute("src");
        // check url if status code is 200 or 404
        URL ud = new URL(urlTest);
        HttpURLConnection huc1 = (HttpURLConnection) ud.openConnection();
        huc1.setRequestMethod("GET"); // get the url
        huc1.connect();               // connect once you get the url
        // Verify if Link is broken or not - code status "200" or "400 or more"
        int respCode1 = huc1.getResponseCode();
        if(respCode1 >= 400){
            System.out.println("Broken Image Link");
        } else {
            System.out.println("Valid Image Link");
        }

        // Test image using keyboard or mouse to click
        driver.get(url + "/pages/Image.html");
        imagePage.thirdImage().click();
        // Verify Click to Home Page
        Assert.assertEquals(driver.getCurrentUrl(), url + "/home.html");

            // Notes on Keyboard
                // some action features
                // actions.doubleclick()
                // pressing ctrl+shift+del example code below
                // actions.keyDown(keys.CONTROL).keyDown(Keys.SHIFT).keyDown(keys.DELETE).perform()
    }

    @Test
    public void testDropDown() throws IOException {
        Map<String, String> testData = ExcelUtil.readExcel().get("testDropDown");

        // direct to Dropdown Page
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/Dropdown.html");
        Assert.assertEquals(driver.getCurrentUrl(), url + "/pages/Dropdown.html");

        // Select training program using Index
        LeafGroundPage dropDownPage = new LeafGroundPage(driver);
        WebElement element = dropDownPage.firstDropDown();
        Select select = new Select(element);
        select.selectByIndex(1);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(4);

        // Select training program using Text
        WebElement element2 = dropDownPage.secondDropDown();
        Select select2 = new Select(element2);
        select2.selectByVisibleText("Selenium");
        select2.selectByVisibleText("Appium");
        select2.selectByVisibleText("UFT/QTP");
        select2.selectByVisibleText("Loadrunner");

        // Select training program using Value
        WebElement element3 = dropDownPage.thirdDropDown();
        Select select3 = new Select(element3);
        select3.selectByValue("1");
        select3.selectByValue("2");
        select3.selectByValue("3");
        select3.selectByValue("4");

        // Get the number of dropdown options
        WebElement element4 = dropDownPage.fourthDropDown();
        Select select4 = new Select(element4);
        List<WebElement> options4 = select4.getOptions();
        // output the total number of options
        System.out.println("The number of dropdown options: " + options4.size());

        // You can also use sendKeys to select
        WebElement select5 = dropDownPage.fifthDropDown();
        select5.sendKeys(testData.get("Input 1"));
        select5.sendKeys(testData.get("Input 2"));
        select5.sendKeys(testData.get("Input 3"));
        select5.sendKeys(testData.get("Input 4"));

        // Select your programs
        WebElement element6 = dropDownPage.sixthDropDown();
        Select select6 = new Select(element6);

        // select all options
        if (select6.isMultiple()){
            select6.getAllSelectedOptions();
        }
    }

    @Test
    public void testRadioButton(){
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/radio.html");
        Assert.assertEquals(driver.getCurrentUrl(), url + "/pages/radio.html");

        // Are you enjoying the classes?
        LeafGroundPage radioPage = new LeafGroundPage(driver);
        radioPage.firstRadioButton().click();
        WebElement testLink2 = radioPage.firstRadioButtonText();
        // Verify Clicked
        Assert.assertEquals(testLink2.getText(), "Yes");

        // Find default selected radio button
        radioPage.secondRadioButton().click();
        WebElement defaultValue2 = radioPage.secondRadioButton();
        // Verify Text of "selected radio button"
        Assert.assertEquals(defaultValue2.getText(), "Checked");
        System.out.println("Default Select Radio Button is: " +defaultValue2.getText());

        // Select your age group (Only if choice wasn't selected)
        HashMap<Integer, String> map = new HashMap<>();   // mapping the radio buttons age group
        map.put(0, " 1 - 20 years ");    // key=value, value=text
        map.put(1, " 21 - 40 years ");
        map.put(2, "Above 40 years");

        // direct to "Select your age group (Only if choice wasn't selected)"
        List<WebElement> ageGroups = radioPage.thirdRadioButton();
        ageGroups.get(1).click();  // Clicked key "1" ----> 21 - 40 years
    }

    @Test
    public void testCheckBox(){
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/checkbox.html");

        // Select the languages that you know?
        LeafGroundPage checkBoxPage = new LeafGroundPage(driver);
        List<WebElement> languages = checkBoxPage.firstCheckBox();
        languages.get(0).click();
        languages.get(3).click();
        languages.get(4).click();

        // Confirm Selenium is checked
        boolean checked = checkBoxPage.secondCheckBox().isSelected();
        Assert.assertTrue(checked);

        // DeSelect only checked
        List<WebElement> deselectCheckBoxes = checkBoxPage.thirdCheckBox();
        for (WebElement elementDeselect : deselectCheckBoxes){
            if(elementDeselect.isSelected()){
                elementDeselect.click();
            }
        }

        // Select all below checkboxes
        List<WebElement> selectCheckBoxes = checkBoxPage.fourthCheckBox();
        for(WebElement checks : selectCheckBoxes){
            checks.click();
        }
    }

    @Test
    public void testTable(){
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/table.html");

        //------------------------------
        LeafGroundPage tablePage = new LeafGroundPage(driver);
        WebElement table = tablePage.TableID();
        System.out.println("No of columns: " +tablePage.columns().size());

        //------------------------------
        List<WebElement> rows = table.findElements(By.xpath("//tr"));
        int total = rows.size() - 1;
        System.out.println("No of rows: " + total);
        //------------------------------
        // total = rows.size() - 1  -----------> the total rows
        for(int i = 0; i < total; i++){
            List<WebElement> columns = rows.get(i).findElements(By.xpath("td"));
            for(int j = 0; j < columns.size(); j++){
                String text = columns.get(j).getText();
                //System.out.print(text + "  ");           // print all text
                if(text.equals("Learn to interact with Elements")){
                    System.out.println(columns.get(j + 1).getText());   // j + 1 is the column "Learn to interact with Elements" plus one more is "Progress"
                    break;
                }
            }
            System.out.println();   // print text within the second for-loop
        }

        // Check the vital task for the least completed progress.
        List<WebElement> Progress = driver.findElements(By.xpath("//td[2]"));

        // Loop through "//td[2]" as i
        for(int i = 0; i < Progress.size(); i++){
            // Convert to text ---> //td[i] to Text
            String Text = Progress.get(i).getText();
            if(Text.equals("30%")){
                driver.findElement(By.xpath("//tr[4]//td[3]//input")).click();
            }
        }
    }

    @Test
    public void testAlert(){
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/Alert.html");

        // Click the button to display an alert box.
        LeafGroundPage alertPage = new LeafGroundPage(driver);
        alertPage.alertButton1().click();
        alertPage.acceptAlert();

        // Click the button to display a "Confirm box"
        alertPage.alertButton2().click();
        alertPage.dismissAlert();

        // Click the button to display a prompt box.
        alertPage.alertButton3().click();
        alertPage.inputAlertKeys();
        alertPage.acceptAlert();
        WebElement promptBox = alertPage.promptBoxAlert();
        Assert.assertEquals(promptBox.getText(), "You should not have enjoyed learning at Typing Testing as compared to TestLeaf! Right?");

        // Click the button to learn line-breaks in an alert.
        alertPage.alertButton4().click();
        alertPage.getAlertText();
        // Verify Text
        String AlertText = alertPage.getAlertText();
        Assert.assertEquals(AlertText, "Hello\n" +
                "How are you doing today?");
        // Print to Console
        System.out.println("---------------Test Alerts-------------------");
        System.out.println(alertPage.getAlertText());
        System.out.println("");
        alertPage.acceptAlert();

//        driver.findElement(By.xpath("//button[@onclick='confirmPrompt()']")).click();
//        driver.switchTo().alert().sendKeys("Typing Testing");
//        driver.switchTo().alert().accept();
//        WebElement promptBox = driver.findElement(By.xpath("//p[@id='result1']"));
//        Assert.assertEquals(promptBox.getText(), "You should not have enjoyed learning at Typing Testing as compared to TestLeaf! Right?");
//
//        // Click the button to learn line-breaks in an alert.
//        driver.findElement(By.xpath("//button[@onclick='lineBreaks()']")).click();
//        driver.switchTo().alert().getText();
//        // Verify Text
//        Assert.assertEquals(driver.switchTo().alert().getText(), "Hello\n" +
//                "How are you doing today?");
//        // Print to Console
//        System.out.println("---------------Test Alerts-------------------");
//        System.out.println(driver.switchTo().alert().getText());
//        System.out.println("");
//        driver.switchTo().alert().accept();
    }

    @Test
    public void testFrame(){
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/frame.html");

        // Find total number of frames.
        LeafGroundPage framePage = new LeafGroundPage(driver);
        List<WebElement> iframes1 = framePage.firstFrame();
        List<WebElement> iframes2 = framePage.secondFrame();
        List<WebElement> iframes3 = framePage.thirdFrame();
        int totalFrame = iframes1.size() + iframes2.size() + iframes3.size();    // add all iframe in page

        // Verify total iframes is 5 in the page
        Assert.assertEquals(totalFrame, 5);
        System.out.println("---------------Test Iframe-------------------");
        System.out.println("Total iframes: " +totalFrame);
    }

    @Test
    public void testWindow() throws InterruptedException {
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/Window.html");

        // Click button to open home page in New Window
        LeafGroundPage windowPage = new LeafGroundPage(driver);
        windowPage.firstWindow().click();

        windowPage.getListandClose1();

        // Find the number of opened windows
        windowPage.secondWindow().click();
        windowPage.getListandClose2();

        // Close all except this window
        windowPage.thirdWindow().click();
        windowPage.getListandClose3();
        Assert.assertTrue(driver.getCurrentUrl().contains("Window.html"));

        // Wait for 2 new Windows to open
        windowPage.fourthWindow().click();
        windowPage.getListandClose4();
    }

    @Test
    public void testCalendar(){
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/Calendar.html");

        // click the blank text field
        LeafGroundPage calendarPage = new LeafGroundPage(driver);
        calendarPage.calendarID().click();

        // click the calendar
        calendarPage.calendarData().click();

        // click the number 10
        calendarPage.calendarPick10().click();
    }

    @Test
    public void testDraggable(){
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/drag.html");

        LeafGroundPage dragPage = new LeafGroundPage(driver);
        WebElement dragging = dragPage.dragPicture();

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(dragging, 100, 200).perform();
    }

    @Test
    public void testDroppable(){
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/drop.html");

        LeafGroundPage dropPage = new LeafGroundPage(driver);

        WebElement source = dropPage.dragPicture();
        WebElement target = dropPage.dropPicture();
        Actions actions2 = new Actions(driver);
        actions2.dragAndDrop(source, target).perform();
    }

    @Test
    public void testSelectable(){
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/selectable.html");

        LeafGroundPage selectPage = new LeafGroundPage(driver);
        List<WebElement> selecting = selectPage.selectList();
        Actions actions3 = new Actions(driver);
        // click first element, press CTRL key, click the second element
        actions3.click(selecting.get(0)).keyDown(Keys.CONTROL)
                .click(selecting.get(selecting.size()-1))
                .perform();
    }

    @Test
    public void testSortable(){
        //Navigate to Sortable Page
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/sortable.html");

        // Item 1, 2, 4, 5
        LeafGroundPage sortPage = new LeafGroundPage(driver);
        WebElement item1 = sortPage.item1();
        WebElement item2 = sortPage.item2();
        WebElement item4 = sortPage.item4();
        WebElement item5 = sortPage.item5();

        Actions actionSort = new Actions(driver);
        actionSort.dragAndDrop(item5, item4).perform();
        actionSort.dragAndDrop(item2,item1).perform();
    }

    @Test
    public void testAutoComplete() throws InterruptedException, IOException {
        Map<String, String> testData = ExcelUtil.readExcel().get("testAutoComplete");

        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/autoComplete.html");

        // blank text box
        LeafGroundPage autoCompletePage = new LeafGroundPage(driver);
        WebElement autoInput = autoCompletePage.autoCompleteField();
        autoInput.sendKeys(testData.get("Input 1"));
        Thread.sleep(2000);
        autoCompletePage.getAutoCompleteInput().click();
    }

    @Test
    public void testDownloadFiles() throws InterruptedException {
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/download.html");

            // download location
        File file = new File("C:\\Users\\Asterisk\\Downloads\\Documents");
        int before = file.listFiles().length;

        // Download Excel
        LeafGroundPage downloadPage = new LeafGroundPage(driver);
        downloadPage.downloadExcelFile().click();
        Thread.sleep(1000);
        Assert.assertEquals(before,13);

        // Download PDF
        downloadPage.downloadPDFFile().click();
        driver.get(url + "/pages/download.html");

        // Download Text
        downloadPage.downloadTextFile().click();
    }

    @Test
    public void testUploadFiles() throws IOException {
        Map<String, String> testData = ExcelUtil.readExcel().get("testUploadFiles");

        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/upload.html");
        // since it's an input, we just sendKeys("File location from Computer")
        LeafGroundPage uploadPage = new LeafGroundPage(driver);
        uploadPage.uploadFiles().sendKeys(testData.get("Input 1"));
    }

    @Test
    public void testToolTip(){
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/tooltip.html");
            // Input box
        LeafGroundPage toolTipPage = new LeafGroundPage(driver);
        WebElement textBox = toolTipPage.getAgeID();
        Actions action = new Actions(driver);
        action.moveToElement(textBox).perform();
        Assert.assertTrue(toolTipPage.displayText().isDisplayed());

    }

    @Test
    public void testWaitToDisappear(){
        //-------------- notes
        // implicit wait ----> wait on certain amount of time then THROW the error
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // explicit wait ----> wait on certain CONDITION then THROW the error
        // WebDriverWait wait = new WebDriverWait(driver, 30);

        // Below for Fluent Wait

        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/disapper.html");

        LeafGroundPage waitPage = new LeafGroundPage(driver);
        WebElement elementWait = waitPage.waitByBTN();
        // This Explicit Wait will overwrite the implicit wait
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOf(elementWait));

        String textWait = waitPage.textID().getText();
        Assert.assertEquals(textWait, "I know you can do it! Button is disappeared!");

        //-------------- notes
            // fluent wait   ----> Similar as Explicit wait just 3 parameters|arguments CONDITIONS
            //        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
            //                .withTimeout(20, TimeUnit.SECONDS)    // timeout at 20 seconds
            //                .pollingEvery(5, TimeUnit.SECONDS)    // check element is there every 5 seconds
            //                .ignoring(NoSuchElementException.class);     // if not there ignore it
            //        wait.until((driver) -> element.isEnabled());        // waiting until element is available
    }

    @Test
    public void testWaitToAppear(){
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/appear.html");

        // wait for new button text is visible than click
        LeafGroundPage appearPage = new LeafGroundPage(driver);
        WebElement elementAppear = appearPage.waitForAppear();
        WebDriverWait waitAppear = new WebDriverWait(driver, 30);
        waitAppear.until(ExpectedConditions.visibilityOf(elementAppear));
        // verify the new button is there
        Assert.assertEquals(elementAppear.getText(), "Voila! I'm here Guys");
    }

    @Test
    public void testWaitForTextChange(){
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/TextChange.html");

        // wait for button text changes to "Click ME!"
        LeafGroundPage textChangePage = new LeafGroundPage(driver);
        WebElement elementT = textChangePage.waitforText();
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        wait2.until(ExpectedConditions.textToBePresentInElement(elementT, "Click ME!"));
        // verify new button text
        Assert.assertEquals(elementT.getText(), "Click ME!");
        // click, get the text, verify it, finally accept the alert
        elementT.click();
        Assert.assertEquals(textChangePage.getAlertText(), "Click ME!");
        textChangePage.acceptAlert();
    }

    @Test
    public void testWaitForAlert(){
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/alertappear.html");

        // Click on Alert
        LeafGroundPage alertPage = new LeafGroundPage(driver);
        alertPage.buttonTextAlert().click();

        // Wait until Alert is visible, Verify the Alert, finally accept the Alert
        WebDriverWait wait3 = new WebDriverWait(driver, 30);
        wait3.until(ExpectedConditions.alertIsPresent());
        String AlertText2 = alertPage.getAlertText();
        Assert.assertEquals(AlertText2, "Hurray, Click OK");
        alertPage.acceptAlert();
    }

    @Test
    public void testMouseHover(){
        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/mouseOver.html");

        // mouse hover, THEN print all the following Links
        LeafGroundPage mouseHoverPage = new LeafGroundPage(driver);
        WebElement MouseHover = mouseHoverPage.blankMouseHoverField();
        List<WebElement> element3List = mouseHoverPage.mouseHoverList();
        // mouse hovering
        Actions actionsMouse = new Actions(driver);
        actionsMouse.moveToElement(MouseHover).perform();
        // print all following links
        System.out.println("-----------Test Mouse Hover-------------------");
        for(WebElement totalAlert : element3List){
            System.out.println(totalAlert.getText());
        }
        System.out.println("------------------------------------------");

        // click on course and handle the alert
        mouseHoverPage.mouseHoverListElement().click();
        mouseHoverPage.acceptAlert();
    }

    @Test
    public void testAdvanceWebTable(){
        //        - Q 5: Advance webtable
        //        - Click on 'name' column -> store the values in a list
        //                - sort the above list in reverse order
        //        - Click on 'name' column again -> store the values in a list
        //        - Compare both the lists using [1. Use collections sort , best to 2. Use comparator]

        String url = LoadProperties.getProperty("url");
        driver.get(url + "/pages/sorttable.html");

        // click name
        LeafGroundPage webTablePage = new LeafGroundPage(driver);
        WebElement Name = webTablePage.clickNameFilter();
        Name.click();

        //---List 1---------------------------------------
        // store Value in list in reverse order
        List<WebElement> nameValue = webTablePage.storeName();
        // store in a new list and get text of each value
        List<String> nameValueList = new ArrayList<>();
        for (WebElement text1 : nameValue ) {
            nameValueList.add(text1.getText());
        }

            // another way to do it
            //        String[] text = new String[nameValueList.size()];
            //        int i = 0;
            //        for(WebElement name : nameValueList){
            //                text[i] = name.getText();
            //                i++;
            //        }
            //        Arrays.sort(text);

        System.out.println("-----------Test Advance Web table-------------------");
        // print all the text value
        System.out.println("Sorted in Reverse: " + nameValueList);

        //---List 2---------------------------------------
        // store new name after click "Name"
        Name.click();
        // verify where list is located
        List<WebElement> nameValue2 = webTablePage.verifyNameList();
        // store in a new list and get text of each value
        List<String> nameValueList2 = new ArrayList<>();
        for (WebElement text2 : nameValue2 ) {
            nameValueList2.add(text2.getText());
        }

            // another way to do it
            //        String[] text2 = new String[nameValueList2.size()];
            //        int j = 0;
            //        for(WebElement name2 : nameValueList2){
            //            text2[j] = name2.getText();
            //            j++;
            //        }

        // print all the text value
        System.out.println("The New name after another Click: " + nameValueList2);

        //---Compare Both List---------------------------------------
        System.out.println("Same Table?: " +nameValue.containsAll(nameValue2)); // return true because both list contains same element
        System.out.println("------------------------------------------");
    }

}
