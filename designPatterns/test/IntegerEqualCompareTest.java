package test;

public class IntegerEqualCompareTest {
    public static void main(String[] args) {
        Integer a = 100, b = 100;
        System.out.println(a == b);

        Integer c = new Integer(100);
        Integer d = new Integer(100);
        System.out.println(c == d);

        System.out.println(c.compareTo(d));
    }
}
