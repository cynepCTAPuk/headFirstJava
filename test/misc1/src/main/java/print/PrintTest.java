package print;

public class PrintTest {
    public static void main(String[] args) {
        System.out.println("print.PrintTest.main");
        System.out.println("args = " + args);
        System.out.printf("printf %,d\n", 1_000);
        System.err.println("print.PrintTest");
    }
}
