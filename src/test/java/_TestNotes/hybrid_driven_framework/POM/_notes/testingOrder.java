package _TestNotes.hybrid_driven_framework.POM._notes;

import org.testng.annotations.Test;

public class testingOrder {
    //--------------------- if testing order ----------------
    @Test(priority = 0)
    public void test1() {
        System.out.println("from test 1");
    }

    @Test(priority = 1)
    public void test3() {
        System.out.println("forom test 3");
    }

    // can use "dependsOnMethods" to give a following code "{as many testcases here}"
    @Test(dependsOnMethods = {"test1", "test3"})
    public void atest2() {
        System.out.println("from test 2");
    }
}
