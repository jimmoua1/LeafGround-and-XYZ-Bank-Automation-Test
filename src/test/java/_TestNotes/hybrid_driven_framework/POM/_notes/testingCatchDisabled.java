package _TestNotes.hybrid_driven_framework.POM._notes;

import org.testng.annotations.Test;

public class testingCatchDisabled {
    // catch error and pass catching an error
    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void test1 () {
        throw new ArrayIndexOutOfBoundsException();
    }

    // disable testing
    @Test(enabled = false)
    public void test2 () {
        System.out.println("from test 2");
    }

    // repeat testing (doing this test 3 times)
    @Test(invocationCount = 3)
    public void test4() {
        System.out.println("from test 4");
    }

    @Test()
    public void test3(){
        System.out.println("from test 3");
    }

    // Can do timeout on how long test takes BUT problem is dont know how long test takes
    // "1000" = 1 second
    @Test(timeOut = 1000)
    public void test5(){
        System.out.println("from test 5");
    }

}
