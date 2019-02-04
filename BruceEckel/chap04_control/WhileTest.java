package chap04_control;

//: control/WhileTest.java
// Demonstrates the while loop.
public class WhileTest {
    static boolean condition() {
        boolean result = Math.random() < 0.99;
        System.out.print(result + ", ");
        return result;
    }

    public static void main(String[] args) {
        int i = 0;
        while (condition()) {
            System.out.println("Inside ‘while’ " + (++i));
        }
        System.out.println("Exited ‘while’");
    }
} /* (Execute to see output) *///:~