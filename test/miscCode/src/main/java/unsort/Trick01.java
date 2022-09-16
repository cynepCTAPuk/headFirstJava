package unsort;

public class Trick01 {
    public static void main(String[] args) {
        int n = 33;
        int s = 0;
        while (n > 0) {
            s = s + n % 2;
            System.out.printf("s:%d d:%d%n", s, n);
            n = n / 2;
        }
        System.out.println(s);
    }
}
