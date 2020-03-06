package primitive;

public class BooleanTest {
    static boolean b;
    public static void main(String[] args) {
        System.out.println(new Boolean("TrUe"));
        System.out.println(Boolean.valueOf("TrUE"));

        System.out.println(new Boolean("false"));
        System.out.println(new Boolean("1"));
        System.out.println(new Boolean("0"));
        System.out.println(Boolean.valueOf("0"));

        System.out.println(b);
    }
}
