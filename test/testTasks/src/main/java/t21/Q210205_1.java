package t21;

public class Q210205_1 {
    public static void main(String[] args) {
        int a, b;
        a = 10;
        b = 20;
        while (++a < --b);
        System.out.println(a);
    }
}
