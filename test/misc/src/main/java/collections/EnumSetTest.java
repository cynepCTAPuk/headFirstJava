//https://www.baeldung.com/java-enumset
package collections;

import java.util.EnumSet;

public class EnumSetTest {
    public static void main(String[] args) {
        System.out.println(EnumSet.noneOf(Color.class));
        System.out.println(EnumSet.allOf(Color.class));
        System.out.println(EnumSet.range(Color.YELLOW, Color.BLUE));

        EnumSet<Color> blackAndWhite = EnumSet.of(Color.BLACK, Color.WHITE);
        System.out.println(blackAndWhite);

        EnumSet<Color> colors = EnumSet.complementOf(blackAndWhite);
        System.out.println(colors);

        EnumSet<Color> copyBlackAndWhite = EnumSet.copyOf(blackAndWhite);
        System.out.println(copyBlackAndWhite);

        colors.remove(Color.GREEN);
        colors.forEach(x -> System.out.print(x + " "));
    }

    enum Color {
        RED, YELLOW, GREEN, BLUE, BLACK, WHITE
    }
}

