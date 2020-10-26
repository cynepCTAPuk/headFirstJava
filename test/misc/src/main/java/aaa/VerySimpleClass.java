package aaa;

public class VerySimpleClass {
    public static void main(String... args) {
        for (byte i = 6, j = 0; (j += i++) <= 10; i >>= 1, System.out.println(--j));
    }
}
