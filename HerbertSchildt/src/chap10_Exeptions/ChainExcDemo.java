package chap10_Exeptions;

// Demonstrate exception chaining
public class ChainExcDemo {
    static void demoProc() {
        // create an exception
        NullPointerException e = new NullPointerException("top layer");
        // add a cause
        e.initCause(new ArithmeticException("cause"));
        throw e;
    }

    public static void main(String[] args) {
        try {
            demoProc();
        } catch (NullPointerException e) {
            // display top level exception
            System.out.println("Caught: " + e);
            // displya cause exception
            System.out.println("Original cause: " + e.getCause());
        }
    }
}
