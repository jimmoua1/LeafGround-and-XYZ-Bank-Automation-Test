package _TestNotes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;


public class TestLeafIntro {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.leafground.com");

        // Edit Fields
        WebElement editLink = driver.findElement(By.xpath("//a[@href='pages/Edit.html']"));
        editLink.click();

        WebElement textBox1 = driver.findElement(By.id("email"));
        textBox1.sendKeys("testing@gmail.com");

        WebElement textBox2 = driver.findElement(By.xpath("//input[@value='Append ']"));
        textBox2.sendKeys("text");

        WebElement textBox3 = driver.findElement(By.xpath("//input[@name='username' and @value='TestLeaf']"));
        String defaultValue = textBox3.getAttribute("value");
        System.out.println("--------------Edit Field Test------------------");
        System.out.println("Default Value is: " +defaultValue);
        System.out.println("");
        Assert.assertEquals(defaultValue, "TestLeaf");

        WebElement textBox4 = driver.findElement(By.xpath("//input[@name='username' and @value='Clear me!!']"));
        textBox4.clear();

        WebElement textBox5 = driver.findElement(By.xpath("//input[@style=\"width:350px;background-color:LightGrey;\"]"));
        String disabled = textBox5.getAttribute("disabled");
        System.out.println("Its disabled?: " +disabled);

        // Click back to HomePage
        WebElement HomePage = driver.findElement(By.xpath("//a[@href='../home.html']"));
        HomePage.click();

//-------------------------------------------------------------------------------------------------

        // Button Page
        WebElement buttonPage = driver.findElement(By.xpath("//a[@href='pages/Button.html']"));
        buttonPage.click();

        WebElement button1 = driver.findElement(By.id("home"));
        button1.click();

        // Click Button Page again
        WebElement buttonPage1 = driver.findElement(By.xpath("//a[@href='pages/Button.html']"));
        buttonPage1.click();

        WebElement button2 = driver.findElement(By.id("position"));
        button2.click();

        WebElement button3 = driver.findElement(By.xpath("//button[@id='color' and @style='background-color:lightgreen']"));
        button3.click();

        WebElement button4 = driver.findElement(By.xpath("//button[@id='size' and @style='background-color:lightblue']"));
        button4.click();

        // Click back to HomePage
        WebElement HomePage1 = driver.findElement(By.xpath("//a[@href='../home.html']"));
        HomePage1.click();

//-------------------------------------------------------------------------------------------------

        // HyperLink
        WebElement HyperLink = driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight' and @href='pages/Link.html']"));
        HyperLink.click();

        WebElement firstLink = driver.findElement(By.xpath("//a[@link='blue' and @href='../home.html']"));
        firstLink.click();

        // Click Back to HyperLink
        WebElement HyperLink1 = driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight' and @href='pages/Link.html']"));
        HyperLink1.click();

        WebElement secondLink = driver.findElement(By.xpath("//a[@link='blue' and @href='Button.html']"));
        secondLink.click();

        // Click Back to Home Page
        WebElement HomePage2 = driver.findElement(By.xpath("//a[@href='../home.html']"));
        HomePage2.click();

        // Click Back to HyperLink Again
        WebElement HyperLink2 = driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight' and @href='pages/Link.html']"));
        HyperLink2.click();

        WebElement thirdLink = driver.findElement(By.xpath("//a[@href='error.html']"));
        thirdLink.click();

        // Return to HyperLink Page
        driver.get("http://leafground.com/pages/Link.html");

        WebElement fourthLink = driver.findElement(By.xpath("//a[@href='../home.html' and @style='color: #CC0000']"));
        fourthLink.click();

        // Click Back to HyperLink Again
        WebElement HyperLink3 = driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight' and @href='pages/Link.html']"));
        HyperLink3.click();

        WebElement fifthLink = driver.findElement(By.xpath("//a[@href='#']"));
        fifthLink.click();

        // Click Back to Home Page
        WebElement HomePage3 = driver.findElement(By.xpath("//a[@href='../home.html']"));
        HomePage3.click();
//-------------------------------------------------------------------------------------------------

        // Image
        WebElement Image = driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight' and @href='pages/Image.html']"));
        Image.click();

        WebElement imageOne = driver.findElement(By.xpath("//img[@src='../images/home.png']"));
        imageOne.click();

        // Click Back to Image
        WebElement Image2 = driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight' and @href='pages/Image.html']"));
        Image2.click();

        // Broken Image test if clickable.......
        WebElement imageTwo = driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']"));
        imageTwo.click();

        WebElement imageThree = driver.findElement(By.xpath("//img[@src='../images/keyboard.png']"));
        imageThree.click();

//-------------------------------------------------------------------------------------------------

        // Drop down
        WebElement Dropdown = driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight' and @href='pages/Dropdown.html']"));
        Dropdown.click();

        WebElement dropdownIndex = driver.findElement(By.id("dropdown1"));
        dropdownIndex.click();

    // Dropdown Index
        WebElement dropdownOneOne = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[1]/select/option[1]"));
        dropdownOneOne.click();

        // Click Index Again
        WebElement dropdownTwo = driver.findElement(By.id("dropdown1"));
        dropdownTwo.click();

        WebElement dropdownOneTwo = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[1]/select/option[2]"));
        dropdownOneTwo.click();

        // Click Index Again
        WebElement dropdownThree = driver.findElement(By.id("dropdown1"));
        dropdownThree.click();

        WebElement dropdownOneThree = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[1]/select/option[3]"));
        dropdownOneThree.click();

        // Click Index Again
        WebElement dropdownFour = driver.findElement(By.id("dropdown1"));
        dropdownFour.click();

        WebElement dropdownOneFour = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[1]/select/option[4]"));
        dropdownOneFour.click();

        // Click Index Again
        WebElement dropdownFive = driver.findElement(By.id("dropdown1"));
        dropdownFive.click();

        WebElement dropdownOneFive = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[1]/select/option[5]"));
        dropdownOneFive.click();

    // Dropdown Text
        WebElement dropdownText = driver.findElement(By.xpath("//select[@name='dropdown2']"));
        dropdownText.click();

        WebElement dropdownTwoOne = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[2]/select/option[1]"));
        dropdownTwoOne.click();

        // Click Text Again
        WebElement dropdownText2 = driver.findElement(By.xpath("//select[@name='dropdown2']"));
        dropdownText2.click();

        WebElement dropdownTwoTwo = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[2]/select/option[2]"));
        dropdownTwoTwo.click();

        // Click Text Again
        WebElement dropdownText3 = driver.findElement(By.xpath("//select[@name='dropdown2']"));
        dropdownText3.click();

        WebElement dropdownTwoThree = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[2]/select/option[3]"));
        dropdownTwoThree.click();

        // Click Text Again
        WebElement dropdownText4 = driver.findElement(By.xpath("//select[@name='dropdown2']"));
        dropdownText4.click();

        WebElement dropdownTwoFour = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[2]/select/option[4]"));
        dropdownTwoFour.click();

        // Click Text Again
        WebElement dropdownText5 = driver.findElement(By.xpath("//select[@name='dropdown2']"));
        dropdownText5.click();

        WebElement dropdownTwoFive = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[2]/select/option[5]"));
        dropdownTwoFive.click();

    // Dropdown Value
        WebElement dropdownValue = driver.findElement(By.xpath("//select[@name='dropdown3']"));
        dropdownValue.click();

        WebElement dropdownThreeOne = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[3]/select/option[1]"));
        dropdownThreeOne.click();

        // Click Value Again
        WebElement dropdownValueTwo = driver.findElement(By.xpath("//select[@name='dropdown3']"));
        dropdownValueTwo.click();

        WebElement dropdownThreeTwo = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[3]/select/option[2]"));
        dropdownThreeTwo.click();

        // Click Value Again
        WebElement dropdownValueThree = driver.findElement(By.xpath("//select[@name='dropdown3']"));
        dropdownValueThree.click();

        WebElement dropdownThreeThree = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[3]/select/option[3]"));
        dropdownThreeThree.click();

        // Click Value Again
        WebElement dropdownValueFour = driver.findElement(By.xpath("//select[@name='dropdown3']"));
        dropdownValueFour.click();

        WebElement dropdownThreeFour = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[3]/select/option[4]"));
        dropdownThreeFour.click();

        // Click Value Again
        WebElement dropdownValueFive = driver.findElement(By.xpath("//select[@name='dropdown3']"));
        dropdownValueFive.click();

        WebElement dropdownThreeFive = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[3]/select/option[5]"));
        dropdownThreeFive.click();

    // Dropdown "Get the number of dropdown options"
        WebElement dropdownOptions = driver.findElement(By.className("dropdown"));
        dropdownOptions.click();

        WebElement dropdownFourOne = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[4]/select/option[1]"));
        dropdownFourOne.click();

        // Click "Get the number of dropdown options" Again
        WebElement dropdownOptionsTwo = driver.findElement(By.className("dropdown"));
        dropdownOptionsTwo.click();

        WebElement dropdownFourTwo = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[4]/select/option[2]"));
        dropdownFourTwo.click();

        // Click "Get the number of dropdown options" Again
        WebElement dropdownOptionsThree = driver.findElement(By.className("dropdown"));
        dropdownOptionsThree.click();

        WebElement dropdownFourThree = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[4]/select/option[3]"));
        dropdownFourThree.click();

        // Click "Get the number of dropdown options" Again
        WebElement dropdownOptionsFour = driver.findElement(By.className("dropdown"));
        dropdownOptionsFour.click();

        WebElement dropdownFourFour = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[4]/select/option[4]"));
        dropdownFourFour.click();

        // Click "Get the number of dropdown options" Again
        WebElement dropdownOptionsFive = driver.findElement(By.className("dropdown"));
        dropdownOptionsFive.click();

        WebElement dropdownFourFive = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[4]/select/option[5]"));
        dropdownFourFive.click();

    // Dropdown "You can also use sendKeys to select"
        WebElement dropdownSendKeys = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[5]/select"));
        dropdownSendKeys.click();

        WebElement dropdownFiveOne = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[5]/select/option[1]"));
        dropdownFiveOne.click();

        // Click SendKeys Again
        WebElement dropdownSendKeysTwo = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[5]/select"));
        dropdownSendKeysTwo.click();

        WebElement dropdownFiveTwo = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[5]/select/option[2]"));
        dropdownFiveTwo.click();

        // Click SendKeys Again
        WebElement dropdownSendKeysThree = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[5]/select"));
        dropdownSendKeysThree.click();

        WebElement dropdownFiveThree = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[5]/select/option[3]"));
        dropdownFiveThree.click();

        // Click SendKeys Again
        WebElement dropdownSendKeysFour = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[5]/select"));
        dropdownSendKeysFour.click();

        WebElement dropdownFiveFour = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[5]/select/option[4]"));
        dropdownFiveFour.click();

        // Click SendKeys Again
        WebElement dropdownSendKeysFive = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[5]/select"));
        dropdownSendKeysFive.click();

        WebElement dropdownFiveFive = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[5]/select/option[5]"));
        dropdownFiveFive.click();

    // Dropdown "Select your programs"
        // Click "Select your programs"
        WebElement dropdownProgram = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[6]/select/option[1]"));
        dropdownProgram.click();

        // Click "Selenium"
        WebElement dropdownProgramOne = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[5]/select/option[2]"));
        dropdownProgramOne.click();

        // Click "Appium"
        WebElement dropdownProgramTwo = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[5]/select/option[3]"));
        dropdownProgramTwo.click();

        // Click "UFT/QTP"
        WebElement dropdownProgramThree = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[5]/select/option[4]"));
        dropdownProgramThree.click();

        // Scroll down
        WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[6]/select/option[5]"));
        Actions scrollDown = new Actions(driver);
        scrollDown.moveToElement(element);
        scrollDown.perform();

        // Click "Loadrunner"
        WebElement dropdownProgramFour = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[6]/select/option[5]"));
        dropdownProgramFour.click();

    // Click Back to Home Page
        WebElement HomePage4 = driver.findElement(By.xpath("//a[@href='../home.html']"));
        HomePage4.click();

//-------------------------------------------------------------------------------------------------

    // Radio Button
    WebElement radioPage = driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight' and @href='pages/radio.html']"));
    radioPage.click();

    // Are you enjoying the classes?
    WebElement radioOneYes = driver.findElement(By.xpath("//input[@id='yes' and @value='1']"));
    radioOneYes.click();

    WebElement radioOneNo = driver.findElement(By.xpath("//input[@id='no' and @value='0']"));
    radioOneNo.click();

    // Find default selected radio button
    WebElement radioTwo = driver.findElement(By.xpath("//input[@name='news' and @checked='']"));
    radioTwo.click();

    WebElement verifyDefaultValue = driver.findElement(By.xpath("//label[@for='Checked']"));
    String radioTwoDefault = verifyDefaultValue.getText();
    Assert.assertEquals(radioTwoDefault, "Checked");
    System.out.println("--------------Radio Test------------------");
    System.out.println("Default Selected is: " +radioTwoDefault);
    System.out.println("");

    // Select your age group (Only if choice wasn't selected)
    WebElement radioThreeOne = driver.findElement(By.xpath("//input[@name='age' and @value='0']"));
    radioThreeOne.click();

    WebElement radioThreeTwo = driver.findElement(By.xpath("//input[@name='age' and @value='1']"));
    radioThreeTwo.click();

    WebElement radioThreeThree = driver.findElement(By.xpath("//input[@name='age' and @value='2']"));
    radioThreeThree.click();

    // Click Back to Home Page
    WebElement HomePage5 = driver.findElement(By.xpath("//a[@href='../home.html']"));
    HomePage5.click();

//-------------------------------------------------------------------------------------------------

    // Checkbox
    WebElement checkboxPage = driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight' and @href='pages/checkbox.html']"));
    checkboxPage.click();

    // Select the languages that you know?
    WebElement checkboxPageOneTwo = driver.findElement(By.cssSelector("div.example:nth-child(3) > div:nth-child(4) > input:nth-child(1)"));
    checkboxPageOneTwo.click();

    WebElement checkboxPageOneThree = driver.findElement(By.cssSelector("div.example:nth-child(3) > div:nth-child(6) > input:nth-child(1)"));
    checkboxPageOneThree.click();

    // Confirm Selenium is checked
    WebElement verifyDefaultValueCheckBox = driver.findElement(By.xpath("//div[text()='Selenium']"));
    String CheckBoxTwoDefault = verifyDefaultValueCheckBox.getText();
    Assert.assertEquals(CheckBoxTwoDefault, "Selenium");
    System.out.println("--------------Checkbox Test------------------");
    System.out.println("Default Selected is: " +CheckBoxTwoDefault);
    System.out.println("");

    // DeSelect only checked
    WebElement checkboxPageOneFour = driver.findElement(By.cssSelector("div.example:nth-child(9) > div:nth-child(5) > input:nth-child(1)"));
    checkboxPageOneFour.click();

    // Select all below checkboxes
    WebElement checkboxPageOneFive = driver.findElement(By.cssSelector("div.example:nth-child(12) > div:nth-child(4) > input:nth-child(1)"));
    checkboxPageOneFive.click();

    WebElement checkboxPageOneFiveTwo = driver.findElement(By.cssSelector("div.example:nth-child(12) > div:nth-child(5) > input:nth-child(1)"));
    checkboxPageOneFiveTwo.click();

    WebElement checkboxPageOneFiveThree = driver.findElement(By.cssSelector("div.example:nth-child(12) > div:nth-child(6) > input:nth-child(1)"));
    checkboxPageOneFiveThree.click();

    WebElement checkboxPageOneFiveFour = driver.findElement(By.cssSelector("div.example:nth-child(12) > div:nth-child(7) > input:nth-child(1)"));
    checkboxPageOneFiveFour.click();

    WebElement checkboxPageOneFiveFive = driver.findElement(By.cssSelector("div.example:nth-child(12) > div:nth-child(8) > input:nth-child(1)"));
    checkboxPageOneFiveFive.click();

    // Click Back to Home Page
    WebElement HomePage6 = driver.findElement(By.xpath("//a[@href='../home.html']"));
    HomePage6.click();

//-------------------------------------------------------------------------------------------------

    // Table
    WebElement TablePage = driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight' and @href='pages/table.html']"));
    TablePage.click();

    WebElement TableBoxOne = driver.findElement(By.cssSelector("#table_id > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(3) > input:nth-child(1)"));
    TableBoxOne.click();

    WebElement TableBoxTwo = driver.findElement(By.cssSelector("tr.even:nth-child(3) > td:nth-child(3) > input:nth-child(1)"));
    TableBoxTwo.click();

    WebElement TableBoxThree = driver.findElement(By.cssSelector("tr.even:nth-child(4) > td:nth-child(3) > input:nth-child(1)"));
    TableBoxThree.click();

    WebElement TableBoxFour = driver.findElement(By.cssSelector("tr.even:nth-child(5) > td:nth-child(3) > input:nth-child(1)"));
    TableBoxFour.click();

    // Click Back to Home Page
    WebElement HomePage7 = driver.findElement(By.xpath("//a[@href='../home.html']"));
    HomePage7.click();

//-------------------------------------------------------------------------------------------------

    // Table
    WebElement AlertPage = driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight' and @href='pages/Alert.html']"));
    AlertPage.click();

    // An alert box.
    WebElement alertBoxOne = driver.findElement(By.xpath("//button[@onclick='normalAlert()']"));
    alertBoxOne.click();
        // Click Ok on "Alert" notification
    Alert al = driver.switchTo().alert();
    al.accept();

    // A confirm box.
    WebElement alertBoxTwo = driver.findElement(By.xpath("//button[@onclick='confirmAlert()']"));
    alertBoxTwo.click();
        // Click Ok on "Alert" notification
    al.accept();

    // A prompt box.
    WebElement alertBoxThree = driver.findElement(By.xpath("//button[@onclick='confirmPrompt()']"));
    alertBoxThree.click();
        // Type words in Alert Message
    al.sendKeys("||Testing Leaf Selenium||");
        // Click Ok on "Alert" notification
    al.accept();

    // Click the button to learn line-breaks in an alert.
    WebElement alertBoxFour = driver.findElement(By.xpath("//button[@onclick='lineBreaks()']"));
    alertBoxFour.click();
        // Click Ok on "Alert" notification
    al.accept();

    // Click the below button and click OK.
    WebElement alertBoxFive = driver.findElement(By.xpath("//button[@onclick='sweetalert()']"));
    alertBoxFive.click();
        // Click Ok on "Alert" notification
    WebElement alertBoxFiveAlertButton = driver.findElement(By.cssSelector(".swal-button"));
    alertBoxFiveAlertButton.click();

    // Click Back to Home Page
    WebElement HomePage8 = driver.findElement(By.xpath("//a[@href='../home.html']"));
    HomePage8.click();

//-------------------------------------------------------------------------------------------------

    // Frame
    WebElement framePage = driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight' and @href='pages/frame.html']"));
    framePage.click();

    // Frame 1
    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='default.html']")));
    WebElement frameOne = driver.findElement(By.id("Click"));
    frameOne.click();

    // Frame 2
    driver.switchTo().defaultContent();
    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='page.html']")));
    driver.switchTo().frame(driver.findElement(By.id("frame2")));
    WebElement frameTwo = driver.findElement(By.id("Click1"));
    frameTwo.click();

    // Frame 3
    driver.switchTo().defaultContent();
    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='countframes.html']")));
    driver.switchTo().frame(driver.findElement(By.id("frame2")));

    // Click Back to Home Page
    driver.switchTo().defaultContent();
    WebElement HomePage9 = driver.findElement(By.xpath("//a[@href='../home.html']"));
    HomePage9.click();

//-------------------------------------------------------------------------------------------------

    // Windows
    WebElement WindowPage = driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight' and @href='pages/Window.html']"));
    WindowPage.click();

    //---------------First button---------------------------------------------------------
    WebElement WindowsOne = driver.findElement(By.cssSelector("#home"));
    WindowsOne.click();

        // Parent Window
    String ParentWindow = driver.getWindowHandle();
        // Check element to store in Set
    driver.findElement(By.xpath("/html")).click();
        // Storing in Set
    Set ChildWindow = driver.getWindowHandles();
        // Loop through
    for (Object ExtraWindows : ChildWindow) {
        driver.switchTo().window((String) ExtraWindows);
        String s = driver.getTitle();
        if(s.equals("TestLeaf - Selenium Playground")){
            driver.close();
        }
    }

    driver.switchTo().window(ParentWindow);

    //---------------Second button---------------------------------------------------------
    WebElement WindowsTwo = driver.findElement(By.cssSelector("div.example:nth-child(4) > div:nth-child(1) > div:nth-child(1) > button:nth-child(6)"));

        // Click "Open Mutiple Windows" 4 times for 4 windows pop-up
    for(int i = 0; i < 2; i++){
        WindowsTwo.click();
    }
        // Parent Window
    String ParentWindowTwo = driver.getWindowHandle();
        // Check element to store in Set
    driver.findElement(By.xpath("/html")).click();
        // Storing in Set
    Set ButtonWindows = driver.getWindowHandles();
    for (Object AllWindows : ButtonWindows) {
        driver.switchTo().window((String) AllWindows);
        String s = driver.getTitle();
        if(s.equals("TestLeaf - Interact with Buttons") || s.equals("TestLeaf - Interact with HyperLinks")){
            driver.close();
        }
    }

    driver.switchTo().window(ParentWindowTwo);

    //---------------Third button---------------------------------------------------------
    WebElement WindowsThree = driver.findElement(By.xpath("//*[@id=\"color\"]"));
        // Click "Open Mutiple Windows" 4 times for 4 windows pop-up
    for(int i = 0; i < 1; i++){
        WindowsThree.click();
    }

    // Parent Window
    String ParentWindowThree = driver.getWindowHandle();
    // Check element to store in Set
    driver.findElement(By.xpath("/html")).click();
    // Storing in Set
    Set ThirdWindows = driver.getWindowHandles();
    for (Object ThirdMostWindows : ThirdWindows) {
        driver.switchTo().window((String) ThirdMostWindows);
        String s = driver.getTitle();
        if(s.equals("TestLeaf - Interact with Buttons") || s.equals("TestLeaf - Interact with HyperLinks")){
            driver.close();
        }
    }

    driver.switchTo().window(ParentWindowThree);

    //---------------Fourth button---------------------------------------------------------
    WebElement WindowsFourth = driver.findElement(By.cssSelector("div.example:nth-child(10) > div:nth-child(1) > div:nth-child(1) > button:nth-child(6)"));
    WindowsFourth.click();
        // wait 6 seconds
    driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

    // Parent Window
    String ParentWindowFour = driver.getWindowHandle();
    // Check element to store in Set
    driver.findElement(By.xpath("/html")).click();
    // Storing in Set
    Set FourthWindows = driver.getWindowHandles();
    for (Object FourthMostWindows : FourthWindows) {
        driver.switchTo().window((String) FourthMostWindows);
        String s = driver.getTitle();
        if(s.equals("TestLeaf - Interact with Buttons") || s.equals("TestLeaf - Interact with HyperLinks")){
            driver.close();
        }
    }

    driver.switchTo().window(ParentWindowFour);

    // Click Back to Home Page
    WebElement HomePage10 = driver.findElement(By.xpath("//a[@href='../home.html']"));
    HomePage10.click();

//-------------------------------------------------------------------------------------------------

    // Calendar
    WebElement CalendarPage = driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight' and @href='pages/Calendar.html']"));
    CalendarPage.click();

    // Click on Blank Text Field
    WebElement CalendarBlankField = driver.findElement(By.cssSelector("#datepicker"));
    CalendarBlankField.click();

    // Click 10th day of the Month
    WebElement TenthDay = driver.findElement(By.xpath("//a[text()='10']"));
    TenthDay.click();
        // wait 3 seconds
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    // Click Back to Home Page
    WebElement HomePage11 = driver.findElement(By.xpath("//a[@href='../home.html']"));
    HomePage11.click();

    // scroll down HomePage
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("window.scrollBy(0,650)");

//-------------------------------------------------------------------------------------------------

    // Draggable
    WebElement DragPage = driver.findElement(By.cssSelector("li.col-lg-3:nth-child(13) > a:nth-child(1)"));
    DragPage.click();

        //GreenBox original position
    WebElement GreenBoxPosition = driver.findElement(By.xpath("//p[text()='Drag me around']"));
        //GreenBox new position
    WebElement GreenBoxPositionOne = driver.findElement(By.xpath("//h1[@class='wp-heading' and @itemprop='name']"));
    Actions act = new Actions(driver);          // Actions => the drag and drop library
    act.clickAndHold(GreenBoxPosition)          // Click and hold the Green Box
        .moveToElement(GreenBoxPositionOne)     // Move it to "Play with Draggable" Title
        .release()                              // release Mouse
        .build()                                // Form all the above together
        .perform();                             // Start taking Action


    // Click Back to Home Page
    WebElement HomePage12 = driver.findElement(By.xpath("//a[@href='../home.html']"));
    HomePage12.click();

    // scroll down HomePage
    JavascriptExecutor scrollMore = (JavascriptExecutor)driver;
    scrollMore.executeScript("window.scrollBy(0,850)");

//-------------------------------------------------------------------------------------------------

    // Droppable
    



















        System.out.println("Test finished");
    }
}

//    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);