package t22;

public class Q220602_1 {
    public static void main(String[] args) {
        int var1 = 42;
        int var2 = ~var1;
        System.out.println(var1 + " " + var2);

        String a = new String("hello");
        String b = new String(a);
        String c = a;
        char[] d = {'h', 'e', 'l', 'l', '0'};

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
    }
}

