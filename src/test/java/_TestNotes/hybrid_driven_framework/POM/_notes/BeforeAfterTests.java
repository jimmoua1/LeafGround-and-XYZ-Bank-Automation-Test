package _TestNotes.hybrid_driven_framework.POM._notes;

import org.testng.annotations.*;

public class BeforeAfterTests {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("From before suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("From before test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("From before class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("From before method");
    }
// ---------------------- After ---------------------------------
    @AfterSuite
    public void afterSuite(){
        System.out.println("From after suite");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("From after test");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("From after class");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("From after method");
    }
}
