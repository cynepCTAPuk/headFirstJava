//: exceptions/FinallyWorks.java
// The finally clause is always executed.
package chap12_exceptions;
class ThreeException extends Exception {}

public class FinallyWorks {
    static int count = 0;
    public static void main(String[] args) {
        while (true) {
            try {
                if ((++count)%3 == 0) throw new ThreeException();
                System.out.println("No exception " + count);
            } catch (ThreeException e) {
                System.out.println("ThreeException");
            } finally {
                System.out.println("In finally clause");
                if (count == 5) break; // out of "while"
            }
        }
    }
} /* Output:
ThreeException
In finally clause
No exception
In finally clause
*///:~