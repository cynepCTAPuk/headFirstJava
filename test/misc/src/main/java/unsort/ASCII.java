package unsort;

import java.util.Random;

/*
 * ASCII (англ. American standard code for information interchange,
 * [ˈæs.ki][1]) — название таблицы (кодировки, набора),
 * в которой некоторым распространённым печатным и непечатным символам сопоставлены числовые коды.
 * Таблица была разработана и стандартизована в США, в 1963 году.
 * Название «ASCII» по-русски часто произносится как [аск(и)и]
 */
public class ASCII {
    public static void main(String[] args) {
        int a = 32; // start symbol (33 - start printable symbols)
        int b = 128 - a;
        int c = 16; // qty symbols in row
        int n = 0;

        for (int i = a; i < a + b; i++) {
            System.out.format("%4d:%2c", i, (char) i);
            if (++n % c == 0) System.out.format("%n");
        }

        System.out.println("_".repeat(60));
        String s = String.join(",", "interfac", "b", "c");
        System.out.println(s);
        int size = 30;
        int[] ints = new int[size];
        new Random().ints(30, 10, 100)
                .forEach(result -> System.out.format("%2d ", result));
    }
}
