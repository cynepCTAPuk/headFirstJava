package chap13_strings;

import java.util.*;

public class Exercise20 {
    public static void main(String[] args) {
        ScannerTest st1 = new ScannerTest();
        ScannerTest st2 = new ScannerTest("1 2 3 4 string");
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
        i = 0;
        i = sc.nextInt();
        l = 0l;
        l = sc.nextLong();
        f = 0.0f;
        f = sc.nextFloat();
        d = 0.0;
        d = sc.nextDouble();
        s = "";
        s = sc.next();
    }

    @Override
    public String toString() {
        return "i=" + i + ", l=" + l + ", f=" + f + ", d=" + d + ", s='" + s +"'";
    }
}
