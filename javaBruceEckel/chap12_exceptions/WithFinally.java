//: exceptions/WithFinally.java
// Finally Guarantees cleanup.
package chap12_exceptions;
import static util.Print.print;
public class WithFinally {
    private static Switch sw = new Switch();
    static void f() throws OnOffException1,OnOffException2 { print("f()"); }
    public static void main(String[] args) {
        try {
            sw.on();
            // Code that can throw exceptions...
            f();
//            throw new RuntimeException();
        } catch(OnOffException1 e) {
            System.out.println("OnOffException1");
        } catch(OnOffException2 e) {
            System.out.println("OnOffException2");
        } finally {
            sw.off();
        }
    }
} /* Output:
on
off
*///:~