//: exceptions/InheritingExceptions.java
// Creating your own exceptions.
package chap12;
class SimpleException extends Exception {}

public class InheritingExceptions {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        } catch (SimpleException e) {
            System.out.println("Caught it!");
        } finally {
            System.out.println("Finally!");
        }
    }
} /* Output:
Throw SimpleException from f()
Caught it!
*///:~