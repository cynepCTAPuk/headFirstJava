package chap10_Exeptions;

// Demonstrate throw
public class ThrowDemo {
    static void demoProc() {
        try {
            throw new NullPointerException("demo");
        } catch (NullPointerException e) {
            System.out.println("Caught inside demoProc");
            throw e; // rethrow the exception
        }
    }

    public static void main(String[] args) {
        try {
            demoProc();
        } catch (NullPointerException e) {
            System.out.println("Recaught: " + e);
        }
    }
}
