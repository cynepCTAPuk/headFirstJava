public class CompareTest {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);
        System.out.println(a.compareTo(b));

        Integer c = new Integer(100);
        Integer d = new Integer(100);
        System.out.println(c == d);
        System.out.println(c.compareTo(d));
    }
}
