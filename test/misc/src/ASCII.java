package src;

import java.util.*;

/*
 * ASCII (англ. American standard code for information interchange,
 * [ˈæs.ki][1]) — название таблицы (кодировки, набора),
 * в которой некоторым распространённым печатным и непечатным символам сопоставлены числовые коды.
 * Таблица была разработана и стандартизована в США, в 1963 году.
 * Название «ASCII» по-русски часто произносится как [аск(и)и]
 */
public class ASCII {
    public static void main(String[] args) {
        int a = 30;         // start symbol (33 - start printable symbols)
        int b = 150;        // qty all symbols
        int c = 15;         // qty symbols in row
        int n = 0;
        System.out.println("Space = " + (int) (' '));
        for (int i = a; i < a + b; i++) {
            System.out.format("%3d: ", i);
            System.out.format("%2c\t\t", (char) i);
            if (++n % c == 0) System.out.format("%n");
        }
        String s = String.join(",", "a", "b", "c");
        int size = 30;
        int[] ints = new int[size];
//        new Random().ints(30, 10, 100).forEach(result -> System.out.format("%2d ", result));
    }
}
