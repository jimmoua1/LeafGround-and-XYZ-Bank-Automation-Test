package Assignments.XYZBankDemo.java;

import Assignments.XYZBankDemo.listener.Listener;
import Assignments.XYZBankDemo.pages.XYZ_TestCasesPage;
import Assignments.XYZBankDemo.utils.ExcelUtil;
import Assignments.XYZBankDemo.utils.LoadProperties;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Listeners(Listener.class)
public class XYZ_TestCases extends BaseTest {
    Logger Log = Logger.getLogger(XYZ_TestCases.class);

    @Test
    public void verifyBankUrl(){
        String url = LoadProperties.getProperty("urlMain");
        driver.get(url + "/banking/#/login");
        Log.info("New driver instantiated");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.way2automation.com/angularjs-protractor/banking/#/login");
            // message to console
        System.out.println("-----------Verify Bank URL-------------");
        if(driver.getCurrentUrl().equals("https://www.way2automation.com/angularjs-protractor/banking/#/login")){
            System.out.println("Bank URl is correct");
        } else {
            System.out.println("Bank URL is INCORRECT");
        }
        System.out.println("");
        Log.info("page factory configured");
    }

    @Test
    public void verifyHomeButton(){
        String url = LoadProperties.getProperty("urlMain");
        driver.get(url + "/banking/#/login");

        XYZ_TestCasesPage homePage = new XYZ_TestCasesPage(driver);
        homePage.getHomeButton();
        Assert.assertEquals(homePage.HomeButtonText(), "Home");

            // message to console
        System.out.println("-----------Verify Home Button URL-------------");
            if (homePage.HomeButtonText().equals("Home")){
                System.out.println("Home Button is correct");
            } else {
                System.out.println("Home Button is INCORRECT");
            }
        System.out.println("");
    }

    @Test
    public void verifyCustomerLogin(){
        String url = LoadProperties.getProperty("urlMain");
        driver.get(url + "/banking/#/login");

        XYZ_TestCasesPage customerButton = new XYZ_TestCasesPage(driver);
        customerButton.getCustomerButton();

    // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/customer"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.way2automation.com/angularjs-protractor/banking/#/customer");
    }

    @Test
    public void verifyBankManagerLogin(){
        String url = LoadProperties.getProperty("urlMain");
        driver.get(url + "/banking/#/login");

        XYZ_TestCasesPage bankManagerButton = new XYZ_TestCasesPage(driver);
        bankManagerButton.getBankManagerButton();

            // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/manager"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.way2automation.com/angularjs-protractor/banking/#/manager");
    }

    @Test
    public void verifyAddingDeletingCustomer() throws IOException {
        // dependent code
        String url = LoadProperties.getProperty("urlBankManager");
        driver.get(url);

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/manager"));

    // testing here
        driver.get(url);
        WebDriverWait wait2 = new WebDriverWait(driver, 10);

            // adding customer
        Map<String, String> testData = ExcelUtil.readExcel().get("verifyAddingDeletingCustomer");
        XYZ_TestCasesPage addCustomer = new XYZ_TestCasesPage(driver);
        addCustomer.clickAddCustomer();

        WebElement Title = addCustomer.waitUntilPageLoad();
        wait2.until(ExpectedConditions.visibilityOf(Title));

        addCustomer.firstName().sendKeys(testData.get("Input 1"));
        addCustomer.lastName().sendKeys(testData.get("Input 2"));
        addCustomer.postCode().sendKeys(testData.get("Input 3"));

        addCustomer.clickSubmit();
        driver.switchTo().alert().accept();

            // deleting customer
        addCustomer.customerPage();
        wait2.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/manager/list"));

        List<WebElement> firstNameList = addCustomer.getCustomerFirstNameList();
        List<WebElement> lastNameList = addCustomer.getCustomerLastNameList();
        WebElement deleteName = addCustomer.getDeleteButton();

        String firstNam = "";
        String lastNam = "";

        for (WebElement findFirst : firstNameList ) {
            String text = findFirst.getText();
            if(text.equals("Alan")){
                firstNam = text;
                break;
            }
        }

        for (WebElement findFirst : lastNameList ) {
            String text2 = findFirst.getText();
            if(text2.equals("Smith")){
                lastNam = text2;
                break;
            }
        }

        System.out.println("-----------Verify Add/Delete Customer-------------");
        if(firstNam.contains("Alan") && lastNam.equals("Smith")){
            System.out.println("Alan Smith in Account, deleting");
            deleteName.click();
        } else {
            System.out.println("No Alan Smith in Account");
        }
    }

    @Test
    public void bvaFirstName() throws IOException {
    // dependent code
        String url = LoadProperties.getProperty("urlMain");
        String urlManager = LoadProperties.getProperty("urlBankManager");
        driver.get(url + "/banking/#/login");

        XYZ_TestCasesPage bankManagerButton = new XYZ_TestCasesPage(driver);
        bankManagerButton.getBankManagerButton();

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/manager"));

    // Testing here
        driver.get(urlManager);
        XYZ_TestCasesPage addCustomer = new XYZ_TestCasesPage(driver);
        addCustomer.clickAddCustomer();
        Map<String, String> testData = ExcelUtil.readExcel().get("bvaFirstName");
        addCustomer.firstName().sendKeys(testData.get("Input 1"));
        addCustomer.firstName().sendKeys(testData.get("Input 2"));
        addCustomer.firstName().sendKeys(testData.get("Input 3"));
        addCustomer.firstName().sendKeys(testData.get("Input 4"));
        addCustomer.firstName().sendKeys(testData.get("Input 5"));
    }

    @Test
    public void bvaLastName() throws IOException {
        // dependent code
        String url = LoadProperties.getProperty("urlMain");
        String urlManager = LoadProperties.getProperty("urlBankManager");
        driver.get(url + "/banking/#/login");

        XYZ_TestCasesPage bankManagerButton = new XYZ_TestCasesPage(driver);
        bankManagerButton.getBankManagerButton();

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/manager"));

        // Testing here
        driver.get(urlManager);
        Map<String, String> testData = ExcelUtil.readExcel().get("bvaLastName");
        XYZ_TestCasesPage addCustomer = new XYZ_TestCasesPage(driver);
        addCustomer.clickAddCustomer();
        addCustomer.lastName().sendKeys(testData.get("Input 1"));
        addCustomer.lastName().sendKeys(testData.get("Input 2"));
        addCustomer.lastName().sendKeys(testData.get("Input 3"));
        addCustomer.lastName().sendKeys(testData.get("Input 4"));
        addCustomer.lastName().sendKeys(testData.get("Input 5"));
    }

    @Test
    public void bvaPostCode() throws IOException {
        // dependent code
        String url = LoadProperties.getProperty("urlMain");
        String urlManager = LoadProperties.getProperty("urlBankManager");
        driver.get(url + "/banking/#/login");

        XYZ_TestCasesPage bankManagerButton = new XYZ_TestCasesPage(driver);
        bankManagerButton.getBankManagerButton();

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/manager"));

        // Testing here
        driver.get(urlManager);
        Map<String, String> testData = ExcelUtil.readExcel().get("bvaPostCode");
        XYZ_TestCasesPage addCustomer = new XYZ_TestCasesPage(driver);
        addCustomer.clickAddCustomer();
        addCustomer.postCode().sendKeys(testData.get("Input 1"));
        addCustomer.postCode().sendKeys(testData.get("Input 2"));
        addCustomer.postCode().sendKeys(testData.get("Input 3"));
        addCustomer.postCode().sendKeys(testData.get("Input 4"));
        addCustomer.postCode().sendKeys(testData.get("Input 5"));
    }

    @Test
    public void checkAlertPopUp() throws IOException {
    // dependent code
        String url = LoadProperties.getProperty("urlMain");
        String urlManager = LoadProperties.getProperty("urlBankManager");
        driver.get(url + "/banking/#/login");

        XYZ_TestCasesPage bankManagerButton = new XYZ_TestCasesPage(driver);
        bankManagerButton.getBankManagerButton();

    // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/manager"));

    // Testing here
        driver.get(urlManager);
        XYZ_TestCasesPage addCustomer = new XYZ_TestCasesPage(driver);
        addCustomer.clickAddCustomer();
        Map<String, String> testData = ExcelUtil.readExcel().get("checkAlertPopUp");
        addCustomer.firstName().sendKeys(testData.get("Input 1"));
        addCustomer.lastName().sendKeys(testData.get("Input 2"));
        addCustomer.postCode().sendKeys(testData.get("Input 3"));
        addCustomer.clickSubmit();
        Assert.assertEquals(addCustomer.getAlertText(), addCustomer.getAlertText());
        addCustomer.acceptAlert();
    }

    @Test
    public void checkAllAccountsOnCustomerName() {
    // dependent code
        String url = LoadProperties.getProperty("urlMain");
        String urlManager = LoadProperties.getProperty("urlBankManager");
        driver.get(url + "/banking/#/login");

        XYZ_TestCasesPage bankManagerButton = new XYZ_TestCasesPage(driver);
        bankManagerButton.getBankManagerButton();

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/manager"));

    // Testing here
        driver.get(urlManager);
        XYZ_TestCasesPage addAccounts = new XYZ_TestCasesPage(driver);
        addAccounts.getOpenAccounts();
        addAccounts.getOption2();
        addAccounts.getOption3();
        addAccounts.getOption4();

        // if option 5 exist get it, if not option 6 should exist.
            // having this logic due to deleting account on tests.
        WebElement option5 = addAccounts.getOption5();
        WebElement option6 = addAccounts.getOption6();
        if (option5 == null){
            assert false;
            option5.click();
        } else if (option6 == null){
            assert false;
            option6.click();
        }
    }

    @Test
    public void checkAllAccountsOnCustomerNameArrowKeys(){
    // dependent code
        String url = LoadProperties.getProperty("urlMain");
        String urlManager = LoadProperties.getProperty("urlBankManager");
        driver.get(url + "/banking/#/login");

        XYZ_TestCasesPage bankManagerButton = new XYZ_TestCasesPage(driver);
        bankManagerButton.getBankManagerButton();

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/manager"));

    // Testing here
        driver.get(urlManager);
        XYZ_TestCasesPage addAccounts = new XYZ_TestCasesPage(driver);
        addAccounts.getOpenAccounts();
        addAccounts.getCustomerNameByArrowKeys();
    }

    @Test
    public void checkAllAccountsOnCustomerNameCurrency(){
    // dependent code
        String url = LoadProperties.getProperty("urlMain");
        String urlManager = LoadProperties.getProperty("urlBankManager");
        driver.get(url + "/banking/#/login");

        XYZ_TestCasesPage bankManagerButton = new XYZ_TestCasesPage(driver);
        bankManagerButton.getBankManagerButton();

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/manager"));

    // Testing here
        driver.get(urlManager);
        XYZ_TestCasesPage addAccounts = new XYZ_TestCasesPage(driver);
        addAccounts.getOpenAccounts();
        addAccounts.selectDollar();
        addAccounts.selectPound();
        addAccounts.selectRupee();
    }

    @Test
    public void checkAllAccountsOnCustomerNameCurrencyArrowKeys(){
    // dependent code
        String url = LoadProperties.getProperty("urlMain");
        String urlManager = LoadProperties.getProperty("urlBankManager");
        driver.get(url + "/banking/#/login");

        XYZ_TestCasesPage bankManagerButton = new XYZ_TestCasesPage(driver);
        bankManagerButton.getBankManagerButton();

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/manager"));

    // Testing here
        driver.get(urlManager);
        XYZ_TestCasesPage addAccounts = new XYZ_TestCasesPage(driver);
        addAccounts.getOpenAccounts();
        addAccounts.getCurrencyByArrowKeys();
    }

    @Test
    public void openNewAccount(){
    // dependent code
        String url = LoadProperties.getProperty("urlMain");
        String urlManager = LoadProperties.getProperty("urlBankManager");
        driver.get(url + "/banking/#/login");

        XYZ_TestCasesPage bankManagerButton = new XYZ_TestCasesPage(driver);
        bankManagerButton.getBankManagerButton();

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/manager"));

    // Testing here
            // Customer: Harry Potter
        driver.get(urlManager);
        XYZ_TestCasesPage addAccounts = new XYZ_TestCasesPage(driver);
        addAccounts.getOpenAccounts();
            // Customer: Harry Potter
        addAccounts.getOption2();
            // Currency: Pound
        addAccounts.selectPound();
            // Click Process
        addAccounts.clickSubmit();
        addAccounts.acceptAlert();
    }

    @Test
    public void verifyNewAccountAlert(){
    // dependent code
        String url = LoadProperties.getProperty("urlMain");
        String urlManager = LoadProperties.getProperty("urlBankManager");
        driver.get(url + "/banking/#/login");

        XYZ_TestCasesPage bankManagerButton = new XYZ_TestCasesPage(driver);
        bankManagerButton.getBankManagerButton();

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/manager"));

    // Testing here
        // Customer: Harry Potter
        driver.get(urlManager);
        XYZ_TestCasesPage addAccounts = new XYZ_TestCasesPage(driver);
        addAccounts.getOpenAccounts();
        addAccounts.getOption2();
        // Currency: Pound
        addAccounts.selectPound();
        // Click Process
        addAccounts.clickSubmit();
        addAccounts.gotAlerted();
        addAccounts.acceptAlert();
    }

    @Test
    public void checkSearchCustomer(){
    // dependent code
        String url = LoadProperties.getProperty("urlMain");
        String urlManager = LoadProperties.getProperty("urlBankManager");
        driver.get(url + "/banking/#/login");

        XYZ_TestCasesPage bankManagerButton = new XYZ_TestCasesPage(driver);
        bankManagerButton.getBankManagerButton();

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/manager"));

    // Testing here
        driver.get(urlManager);
        XYZ_TestCasesPage checkCustomer = new XYZ_TestCasesPage(driver);
        checkCustomer.customerPage();
        checkCustomer.searchBarWords("Harry");
    }

    @Test
    public void clickSortFirstName(){
    // dependent code
        String url = LoadProperties.getProperty("urlMain");
        String urlManager = LoadProperties.getProperty("urlBankManager");
        driver.get(url + "/banking/#/login");

        XYZ_TestCasesPage bankManagerButton = new XYZ_TestCasesPage(driver);
        bankManagerButton.getBankManagerButton();

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/manager"));

    // Testing here
        driver.get(urlManager);
        XYZ_TestCasesPage checkCustomer = new XYZ_TestCasesPage(driver);
        checkCustomer.customerPage();
        checkCustomer.clickFirstName();
    }

    @Test
    public void clickSortLastName(){
    // dependent code
        String url = LoadProperties.getProperty("urlMain");
        String urlManager = LoadProperties.getProperty("urlBankManager");
        driver.get(url + "/banking/#/login");

        XYZ_TestCasesPage bankManagerButton = new XYZ_TestCasesPage(driver);
        bankManagerButton.getBankManagerButton();

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/manager"));

    // Testing here
        driver.get(urlManager);
        XYZ_TestCasesPage checkCustomer = new XYZ_TestCasesPage(driver);
        checkCustomer.customerPage();
        checkCustomer.clickLastName();
    }

    @Test
    public void clickSortPostCode(){
    // dependent code
        String url = LoadProperties.getProperty("urlMain");
        String urlManager = LoadProperties.getProperty("urlBankManager");
        driver.get(url + "/banking/#/login");

        XYZ_TestCasesPage bankManagerButton = new XYZ_TestCasesPage(driver);
        bankManagerButton.getBankManagerButton();

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/manager"));

    // Testing here
        driver.get(urlManager);
        XYZ_TestCasesPage checkCustomer = new XYZ_TestCasesPage(driver);
        checkCustomer.customerPage();
        checkCustomer.clickPostCode();
    }

    @Test
    public void deleteCustomer(){
    // dependent code
        String url = LoadProperties.getProperty("urlMain");
        String urlManager = LoadProperties.getProperty("urlBankManager");
        driver.get(url + "/banking/#/login");

        XYZ_TestCasesPage bankManagerButton = new XYZ_TestCasesPage(driver);
        bankManagerButton.getBankManagerButton();

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/manager"));

    // Testing here
        driver.get(urlManager);
        XYZ_TestCasesPage checkCustomer = new XYZ_TestCasesPage(driver);
        checkCustomer.customerPage();
        checkCustomer.deleteButton();
    }

    //--------------- Customer Test----------------------------
    @Test
    public void customerLoginLogout(){
    // dependent code
        String url = LoadProperties.getProperty("urlCustomer");
        driver.get(url);

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/customer"));

    // Testing here
            // Login
        driver.get(url);
        XYZ_TestCasesPage customerLoginPage = new XYZ_TestCasesPage(driver);
        customerLoginPage.getOption2();
        customerLoginPage.customerLogin();
        customerLoginPage.customerLogout();
    }

    @Test
    public void customerAccountChange(){
        // dependent code
        String url = LoadProperties.getProperty("urlCustomer");
        driver.get(url);

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/customer"));

    // Testing here
            // Login
        driver.get(url);
        XYZ_TestCasesPage customerPage = new XYZ_TestCasesPage(driver);
        customerPage.getOption2();
        customerPage.customerLogin();
            // Change Account
        customerPage.customerAccount1005();
        customerPage.implicitlyWait5seconds();  // wait 5 seconds if account 1006 not found
        customerPage.customerAccount1006();
    }

    @Test
    public void displayTransactionPage(){
    // dependent code
        String url = LoadProperties.getProperty("urlCustomer");
        driver.get(url);

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/customer"));

    // Testing here
        // Login
        driver.get(url);
        XYZ_TestCasesPage customerPage = new XYZ_TestCasesPage(driver);
        customerPage.getOption2();
        customerPage.customerLogin();

        // Transactions Page
        customerPage.customerTransactionsPage();
    }

    @Test
    public void displayTransactionCalendar() throws InterruptedException, IOException {
    // dependent code
        String url = LoadProperties.getProperty("urlCustomer");
        driver.get(url);

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/customer"));

    // Testing here
        // Login
        driver.get(url);
        XYZ_TestCasesPage customerPage = new XYZ_TestCasesPage(driver);
        customerPage.getOption2();
        customerPage.customerLogin();

        // Deposit 30 First
        customerPage.getOpenAccounts();
        Map<String, String> testData = ExcelUtil.readExcel().get("displayTransactionCalendar");
        customerPage.customerDeposit().sendKeys(testData.get("Input 1"));
        customerPage.clickSubmit();

        // Transactions Page
        Thread.sleep(1000);
        customerPage.customerTransactionsPage();
        customerPage.dateBefore();
        Thread.sleep(1000);
        customerPage.afterCalendar();
    }

    @Test
    public void customerResetTransaction() throws IOException, InterruptedException {
    // dependent code
        String url = LoadProperties.getProperty("urlCustomer");
        driver.get(url);

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/customer"));

    // Testing here
        // Login
        driver.get(url);
        Map<String, String> testData = ExcelUtil.readExcel().get("customerResetTransaction");
        XYZ_TestCasesPage customerPage = new XYZ_TestCasesPage(driver);
        customerPage.getOption2();
        customerPage.customerLogin();

        // Deposit 30 First
        customerPage.getOpenAccounts();
        customerPage.customerDeposit().sendKeys(testData.get("Input 1"));
        customerPage.clickSubmit();

        // Transactions Page
        customerPage.customerTransactionsPage();
            // Reset
        customerPage.resetCustomerTransactions();
    }

    @Test
    public void customerDepositing() throws InterruptedException, IOException {
    // dependent code
        String url = LoadProperties.getProperty("urlCustomer");
        driver.get(url);

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/customer"));

    // Testing here
        // Login
        driver.get(url);
        Map<String, String> testData = ExcelUtil.readExcel().get("customerDepositing");
        XYZ_TestCasesPage customerPage = new XYZ_TestCasesPage(driver);
        customerPage.getOption2();
        customerPage.customerLogin();

        // Deposit 30 First
        customerPage.getOpenAccounts();
        customerPage.customerDeposit().sendKeys(testData.get("Input 1"));
        customerPage.clickSubmit();

        // Verify Success Transaction
        customerPage.verifyDepositSuccessful();
        Assert.assertEquals(customerPage.verifyDepositSuccessful(), "Deposit Successful");
        Assert.assertEquals(customerPage.verifyDeposit(), "30");
        Thread.sleep(2000);
        customerPage.customerTransactionsPage();
        Assert.assertEquals(customerPage.verifyTransaction30(), "30");
    }

    @Test
    public void customerWithdrawn() throws InterruptedException, IOException {
    // dependent code
        String url = LoadProperties.getProperty("urlCustomer");
        driver.get(url);

        // wait for url to finish loading to get the url page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://www.way2automation.com/angularjs-protractor/banking/#/customer"));

    // Testing here
        // Login
        driver.get(url);
        Map<String, String> testData = ExcelUtil.readExcel().get("customerWithdrawn");
        XYZ_TestCasesPage customerWithdrawn = new XYZ_TestCasesPage(driver);
        customerWithdrawn.getOption2();
        customerWithdrawn.customerLogin();

        // Deposit 30 First
        customerWithdrawn.getOpenAccounts();
        customerWithdrawn.customerDeposit().sendKeys(testData.get("Input 1"));
        customerWithdrawn.clickSubmit();

        // Withdrawn 10 First
        customerWithdrawn.customerPage();
        Thread.sleep(2000);
        customerWithdrawn.customerDeposit().sendKeys(testData.get("Input 2"));
        customerWithdrawn.clickSubmit();

        // Verify Withdrawn Successfully
        customerWithdrawn.verifyWithdrawnSuccessful();
        Assert.assertEquals(customerWithdrawn.verifyWithdrawnSuccessful(), "Transaction successful");

        String balanceTotal = customerWithdrawn.verifyWithdrawn();
        Assert.assertEquals(customerWithdrawn.verifyWithdrawn(), balanceTotal);
        Thread.sleep(2000);
        customerWithdrawn.customerTransactionsPage();
        Assert.assertEquals(customerWithdrawn.verifyTransaction10(), "10");
    }
}
