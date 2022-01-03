// Example of using only one chrome/browser driver FORMAT
//  for the file it is located at "DriverUtil" in "utils" folder

package _TestNotes.hybrid_driven_framework.POM._notes;

public class OneDriver {
    static OneDriver singleton;

    private OneDriver(){

    }

    public static OneDriver getInstance(){
        if(singleton == null){
            singleton = new OneDriver(); // if null, initialize it
        }
        return singleton;
    }
}

class QA {
    public static void main(String[] args) {
        OneDriver singleton = OneDriver.getInstance();
        System.out.println(singleton);
    // checking again
        singleton = OneDriver.getInstance();
        System.out.println(singleton);
    }
}