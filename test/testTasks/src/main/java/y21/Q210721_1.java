package y21;

public class Q210721_1 {
    public static void main(String[] args) {
        byte[] a = {49, 50, 51, 52, 53, 54, 55};
        String b = new String(a);
        System.out.println(b);

        String c = new String(a, 2, 4);
        System.out.print(c);
    }
}