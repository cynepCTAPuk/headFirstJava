//: chap20_annotations/Testable.java
package chap20_annotations;
import atunit.*;

public class Testable {
    public void execute() {
        System.out.println("Executing..");
    }

    @Test
    void testExecute() {
        execute();
    }
} ///:~