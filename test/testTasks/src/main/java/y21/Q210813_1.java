package y21;

public class Q210813_1 {
    public static void main(String... args) {
        for (int i = 2; i < 10; i = (i++) + i--, i++) {
            System.out.println(--i);
        }
    }
}

