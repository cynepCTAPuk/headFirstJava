package test;

/*
 * ASCII (англ. American standard code for information interchange,
 * [ˈæs.ki][1]) — название таблицы (кодировки, набора),
 * в которой некоторым распространённым печатным и непечатным символам сопоставлены числовые коды.
 * Таблица была разработана и стандартизована в США, в 1963 году.
 * Название «ASCII» по-русски часто произносится как [аск(и)и]
 */
public class ASCII {
    public static void main(String[] args) {
        int a = 33;         // start symbol (33 - start printable symbols)
        int b = 300;        // qty all symbols
        int c = 10;         // qty symbols in row
        int n = 0;
        for (int i = a; i < a + b; i++) {
            System.out.format("%3d ", i);
            System.out.format("%2c\t\t", (char) i);
            if (++n % c == 0) System.out.format("%n");
        }
//        System.out.println();
    }
}
