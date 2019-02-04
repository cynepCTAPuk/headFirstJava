package chap13_strings;

import java.util.*;

public class Exercise20 {
    public static void main(String[] args) {
        ScannerTest st1 = new ScannerTest();
        ScannerTest st2 = new ScannerTest("1 2 3 4 5");
        System.out.println(st1);
        System.out.println(st2);
    }
}

class ScannerTest {
    private int i;
    private long l;
    private float f;
    private double d;
    private String s;
    ScannerTest() {
        i = 0;
        l = 0l;
        f = 0.0f;
        d = 0.0;
        s = "";
    }

    ScannerTest(String string) {
        Scanner sc = new Scanner(string);
        // java.util.InputMismatchException
//        sc.useDelimiter("\\s*\\,\\s*");
        i = sc.nextInt();
        l = sc.nextLong();
        f = sc.nextFloat();
        d = sc.nextDouble();
        s = sc.next();
    }

    @Override
    public String toString() {
        return "i=" + i + ", l=" + l + ", f=" + f + ", d=" + d + ", s='" + s +"'";
    }
}
