package Assignments.XYZBankDemo.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class XYZ_TestCasesPage {

    public WebDriver driver;

    public XYZ_TestCasesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // verifyHomeButton | bvaFirstName | bvaLastName | bvaPostCode | checkAlertPopUp(some uses here)
    @FindBy(xpath = "//div//button[text()='Home']")
    public WebElement HomePage;

    // verifyCustomerLogin
    @FindBy(xpath = "//button[text()='Customer Login']")
    public WebElement CustomerLoginButton;

    // verifyBankManagerLogin
    @FindBy(xpath = "//button[text()='Bank Manager Login']")
    public WebElement BankManagerLoginButton;

    // verifyAddingDeletingCustomer
    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    public WebElement addCustomerButton;

    @FindBy(xpath = "//strong[text()='XYZ Bank']")
    public WebElement BankManagerPage;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement FirstNameFieldBox;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement LastNameFieldBox;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    public WebElement PostCodeFieldBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonClick;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    public WebElement showAllCustomer;

    @FindBy(xpath = "//tr//td[1]")
    public List<WebElement> firstNameList;

    @FindBy(xpath = "//tr//td[2]")
    public List<WebElement> lastNameList;

    @FindBy(xpath = "//tr[5]//td[5]//button")
    public WebElement deletePath;

    // checkAllAccountsOnCustomerName
    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    public WebElement openAccount;

    @FindBy(xpath = "//option[@value='2']")
    public WebElement option2;

    @FindBy(xpath = "//option[@value='3']")
    public WebElement option3;

    @FindBy(xpath = "//option[@value='4']")
    public WebElement option4;

    @FindBy(xpath = "//option[@value='5']")
    public WebElement option5;

    @FindBy(xpath = "//option[@value='6']")
    public WebElement option6;

    // checkAllAccountsOnCustomerNameArrowKeys
    @FindBy(xpath = "//select[@id='userSelect']")
    public WebElement customerName;

    // checkAllAccountsOnCustomerNameCurrency
    @FindBy(xpath = "//option[@value='Dollar']")
    public WebElement dollar;

    @FindBy(xpath = "//option[@value='Pound']")
    public WebElement pound;

    @FindBy(xpath = "//option[@value='Rupee']")
    public WebElement rupee;

    // checkAllAccountsOnCustomerNameCurrencyArrowKeys
    @FindBy(xpath = "//select[@id='currency']")
    public WebElement currency;

    // checkSearchCustomer
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    public WebElement searchBar;

    // clickSortFirstName
    @FindBy(xpath = "//*[contains(text(), 'First Name')]")
    public WebElement sortFirstName;

    // clickSortLastName
    @FindBy(xpath = "//*[contains(text(), 'Last Name')]")
    public WebElement sortLastName;

    // clickSortPostCode
    @FindBy(xpath = "//*[contains(text(), 'Post Code')]")
    public WebElement sortPostCode;

    // deleteCustomer
    @FindBy(xpath = "//tr[1]//button[@ng-click='deleteCust(cust)']")
    public WebElement deleteCustomer;

    // customerLoginLogout
    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    public WebElement loggIn;

    @FindBy(xpath = "//button[contains(text(), 'Logout')]")
    public WebElement logout;

    // customerAccountChange
    @FindBy(xpath = "//option[@label='1005']")
    public WebElement account1005;

    @FindBy(xpath = "//option[@label='1006']")
    public WebElement account1006;

    // displayTransaction
    @FindBy(xpath = "//button[contains(text(), 'Transactions')]")
    public WebElement transactions;

    @FindBy(xpath = "//input[@placeholder='amount']")
    public WebElement deposit;

    // displayTransactionCalendar
    @FindBy(xpath = "//input[@id='start']")
    public WebElement startCalendar;

    @FindBy(xpath = "//input[@id='end']")
    public WebElement endCalendar;

    // customerResetTransaction
    @FindBy(xpath = "//button[contains(text(), 'Reset')]")
    public WebElement reset;

    // customerDepositing
    @FindBy(xpath = "//span[contains(text(), 'Deposit Successful')]")
    public WebElement depositSuccess;

    @FindBy(xpath = "//div//strong[contains(text(), '30')]")
    public WebElement deposit30;

    @FindBy(xpath = "//tbody//tr//td[2]")
    public WebElement transactions30;

    // customerWithdrawn
    @FindBy(xpath = "//span[contains(text(), 'Transaction successful')]")
    public WebElement withdrawnSuccess;

    @FindBy(xpath = "//div[2]//div[2]//strong[2]")
    public WebElement depositText;

    @FindBy(xpath = "//tr//td[contains(text(), '10')]")
    public WebElement transactions10;

//-------------------------------------------------------------------------------
    // verifyHomeButton
    public XYZ_TestCasesPage getHomeButton(){
        HomePage.click();
        return this;
    }

    public String HomeButtonText(){
        return HomePage.getText();
    }
//-------------------------------------------------------------------------------
    // verifyCustomerLogin
    public void getCustomerButton(){
        CustomerLoginButton.click();
    }

//-------------------------------------------------------------------------------
    // verifyBankManagerLogin
    public void getBankManagerButton(){
        BankManagerLoginButton.click();
    }

//-------------------------------------------------------------------------------
    // verifyAddingDeletingCustomer | bvaFirstName | bvaLastName | bvaPostCode | checkAlertPopUp(some uses here) | openNewAccount(some here) | verifyNewAccountAlert(some here) | checkSearchCustomer(some here) | clickSortFirstName(some here) | clickSortLastName(some here) | deleteCustomer(some here) | displayTransactionCalendar(some here) | customerResetTransaction(some here) | customerDepositing(some here) | customerWithdrawn(some here)
    public void clickAddCustomer(){
        addCustomerButton.click();
    }

    public WebElement waitUntilPageLoad(){
        return BankManagerPage;
    }

    public WebElement firstName(){
        return FirstNameFieldBox;
    }

    public WebElement lastName(){
        return LastNameFieldBox;
    }

    public WebElement postCode(){
        return PostCodeFieldBox;
    }

    public void clickSubmit(){
        buttonClick.click();
    }

    public void customerPage(){
        showAllCustomer.click();
    }

    public List<WebElement> getCustomerFirstNameList(){
        return firstNameList;
    }

    public List<WebElement> getCustomerLastNameList(){
        return lastNameList;
    }

    public WebElement getDeleteButton(){
        return deletePath;
    }

//-------------------------------------------------------------------------------
    // checkAlertPopUp | openNewAccount(some here) | verifyNewAccountAlert(some here)
    public Alert gotAlerted(){
        return this.driver.switchTo().alert();
    }

    public String getAlertText(){
        return this.driver.switchTo().alert().getText();
    }

    public void acceptAlert(){
        this.driver.switchTo().alert().accept();
    }

//-------------------------------------------------------------------------------
    // checkAllAccountsOnCustomerName | checkAllAccountsOnCustomerNameArrowKeys(some here) | checkAllAccountsOnCustomerNameCurrency(some here) | checkAllAccountsOnCustomerNameCurrencyArrowKeys(some here) | openNewAccount(some here) | verifyNewAccountAlert(some here) | customerLoginLogout(some here) | customerAccountChange(some here) | displayTransaction(some here) | displayTransactionCalendar(some here) | customerResetTransaction(some here) | customerDepositing(some here) | customerWithdrawn(some here)
    public void getOpenAccounts(){
        openAccount.click();
    }

    public void getOption2(){
        option2.click();
    }

    public void getOption3(){
        option3.click();
    }

    public void getOption4(){
        option4.click();
    }


    public WebElement getOption5(){
        return option5;
    }

    public WebElement getOption6(){
        return option6;
    }

//-------------------------------------------------------------------------------
    // checkAllAccountsOnCustomerNameArrowKeys
    public void getCustomerNameByArrowKeys(){
        customerName.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        customerName.click();
    }

//-------------------------------------------------------------------------------
    // checkAllAccountsOnCustomerNameCurrency | openNewAccount(some here) | verifyNewAccountAlert(some here)
    public void selectDollar(){
        dollar.click();
    }

    public void selectPound(){
        pound.click();
    }

    public void selectRupee(){
        rupee.click();
    }

//-------------------------------------------------------------------------------
    // checkAllAccountsOnCustomerNameCurrencyArrowKeys
    public void getCurrencyByArrowKeys(){
        currency.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        currency.click();
    }

//-------------------------------------------------------------------------------
    // checkSearchCustomer
    public void searchBarWords(String words){
        searchBar.click();
        searchBar.sendKeys(words);
    }

//-------------------------------------------------------------------------------
    // clickSortFirstName
    public void clickFirstName(){
        sortFirstName.click();
    }


//-------------------------------------------------------------------------------
    // clickSortLastName
    public void clickLastName(){
        sortLastName.click();
    }

//-------------------------------------------------------------------------------
    // clickSortPostCode
    public void clickPostCode(){
        sortPostCode.click();
    }
//-------------------------------------------------------------------------------
    // deleteCustomer
    public void deleteButton(){
        deleteCustomer.click();
    }

//-------------------------------------------------------------------------------
    // customerLoginLogout | customerAccountChange(some here) | displayTransaction(some here) | displayTransactionCalendar(some here) | customerResetTransaction(some here) | customerDepositing(some here) | customerWithdrawn(some here)
    public void customerLogin(){
        loggIn.click();
    }

    public void customerLogout(){
        logout.click();
    }

//-------------------------------------------------------------------------------
    // customerAccountChange
    public void customerAccount1005(){
        account1005.click();
    }

    public void customerAccount1006(){
        account1006.click();
    }

    public void implicitlyWait5seconds(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

//-------------------------------------------------------------------------------
    // displayTransaction | displayTransactionCalendar(some here) | customerResetTransaction(some here)
    public void customerTransactionsPage(){
        transactions.click();
    }

//-------------------------------------------------------------------------------
    // displayTransactionCalendar | customerResetTransaction(some here) | customerDepositing(some here) | customerWithdrawn(some here)
    public WebElement customerDeposit(){
        return deposit;
    }

    public void dateBefore(){
        startCalendar.click();
    }

    public void afterCalendar(){
        endCalendar.click();
    }

//-------------------------------------------------------------------------------
    // customerResetTransaction
    public void resetCustomerTransactions(){
        reset.click();
    }

//-------------------------------------------------------------------------------
    // customerDepositing | customerDepositing
    public String verifyDepositSuccessful(){
        return depositSuccess.getText();
    }

    public String verifyDeposit(){
        return deposit30.getText();
    }

    public String verifyTransaction30(){
        return transactions30.getText();
    }

//-------------------------------------------------------------------------------
    // customerWithdrawn
    public String verifyWithdrawnSuccessful(){
        return withdrawnSuccess.getText();
    }

    public String verifyWithdrawn(){
        return depositText.getText();
    }

    public String verifyTransaction10(){
        return transactions10.getText();
    }

}
