package test;

public class StringEqualCompareTest {
    public static void main(String[] args) {
        String a = "100";
        String b = "100";
        System.out.println(a == b);

        String c = new String("100");
        String d = new String("100");
        System.out.println(c == d);

        System.out.println(c.compareTo(d));
    }
}
