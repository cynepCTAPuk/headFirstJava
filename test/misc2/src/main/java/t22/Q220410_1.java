package t22;

public class Q220410_1 {
    public static void main(String[] args) {
        String s = "Java";
        s.replace('a', 'o');
        System.out.println(s);
        if (s.endsWith("a"))
            System.out.println(4 ^ 2);
        else
            System.out.println(6 ^ 2);
    }
}

