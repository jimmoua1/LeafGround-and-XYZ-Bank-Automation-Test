// useful for BVA(Boundary Value Analysis) and EPT(Equivalence Partitioning Testing)

package _TestNotes.hybrid_driven_framework.POM._notes._DataProviderNotes;

import org.testng.annotations.*;

public class _DataProviderNotes {

    // Let's say you have repetitive driver XPATH
    //  you can do two test cases into one
    @Test(dataProvider = "data1") // -----> lastly, include the data provider on Test
    public void loginTest1(String username, String password, String text){
        System.out.println(username);
        System.out.println(password);
        System.out.println(text);
    }

    // diagram of a table for "@DataProvider"
        // valid username, valid password, login successful
        // invalid username, invalid password, login failed

    // what you can do is use Data Provider (can be put into the "BaseTest")
    @org.testng.annotations.DataProvider    // this or "@DataProvider"
    public Object[][] data1(){
        return new Object[][]{
            // depends on how many xpath, will run that many times
                {"valid username", "valid password", "login successful"}, // xpath go here
                {"invalid username", "invalid password", "login failed"}, // 2nd xpath go here
        };
    }



}
