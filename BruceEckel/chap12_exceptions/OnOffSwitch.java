//: exceptions/OnOffSwitch.java
// Why use finally?
package chap12_exceptions;
import static util.Print.print;
public class OnOffSwitch {
    private static Switch sw = new Switch();
    static void f() throws OnOffException1,OnOffException2 { print("f()"); }
    public static void main(String[] args) {
        try {
            sw.on();
            // Code that can throw exceptions...
            f();
            sw.off();
        } catch(OnOffException1 e) {
            System.out.println("OnOffException1");
            sw.off();
        } catch(OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off();
        }
    }
} /* Output:
on
off
*///:~