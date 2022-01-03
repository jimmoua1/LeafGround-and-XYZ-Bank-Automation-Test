package _TestNotes.hybrid_driven_framework.POM._notes._DataProviderNotes.java;

import org.testng.annotations.Test;

public class DataProviderTest extends BaseTest {

    // dataProvider = (variable of dataProvider)
    // dataProviderClass = (where it is located)
    // threadPoolSize = (depends on computer hardware support|number is how many tests run same time)

    @Test(dataProvider = "data1", dataProviderClass = BaseTest.class, threadPoolSize = 2)
    public void testToolTip(String username, String password, String text){
        System.out.println(username);
        System.out.println(password);
        System.out.println(text);
    }

}
