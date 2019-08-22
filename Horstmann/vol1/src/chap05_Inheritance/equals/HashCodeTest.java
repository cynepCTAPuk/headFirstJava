package chap05_Inheritance.equals;

import java.util.Objects;

public class HashCodeTest {
    public static void main(String[] args) {
        var s = "Ok";
        var sb = new StringBuilder(s);
        System.out.println(s.hashCode() + " " + sb.hashCode());

        var t = new String("Ok");
        var tb = new StringBuilder(t);
        System.out.println(t.hashCode() + " " + tb.hashCode());


        System.out.printf("CTAPuk: %,d\n", Objects.hash("CTAPuk", "Hi", "!"));
        System.out.printf("CTAPuk: %,d\n", Objects.hash("!", "Hi", "CTAPuk"));

        System.out.printf("%,d\n", Integer.MAX_VALUE);

        System.out.println("Binary: " + 0b1111_1111);
        System.out.println("Octal:  " + 0377);
        System.out.println("Hex:    " + 0xf_f);

        System.out.println("Hello".hashCode());
        System.out.println("Harry".hashCode());
        System.out.println("Hacker".hashCode());

    }
}
