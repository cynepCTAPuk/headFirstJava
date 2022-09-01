package t21;

import java.util.Arrays;

public class Q211115_1 {
    public enum Cat {
        Leopard,
        Puma,
        Lion
    }

    public static void main(String[] args) {
        for (Cat cat : Cat.values()) {
            System.out.println(cat.ordinal() + ":" + cat.name());
        }
        Arrays.stream(Cat.values()).map(cat -> cat.ordinal() + ":" + cat.name()).forEach(System.out::println);
    }
}

