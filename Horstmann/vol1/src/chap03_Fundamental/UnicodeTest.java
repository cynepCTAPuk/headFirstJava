package chap03_Fundamental;

import java.util.Arrays;

public class UnicodeTest {
    public static void main(String[] args) {
/*
        int k = 128_149;
        for (int i = k; i < k + 60; i++) System.out.print((char) i);
        System.out.println();
        for (int i = k; i < k + 60; i++) System.out.print(Arrays.toString(Character.toChars(i)));
        System.out.println();
*/

// this character:  http://www.isthisthingon.org/unicode/index.php?page=1F&subpage=4&glyph=1F495
// using code points here, not U+n notation for equivalence with U+n, below would be 0xnnnn
        int codePoint = 127_744 - 1;
        System.out.printf("%,d\n", codePoint);
        for (int i = codePoint; i < 128_704 + 2; i++) {
            char[] charPair = Character.toChars(i); // converting to char[] pair
//            System.out.print(charPair.length);
//            System.out.print(charPair);
            // and to String, containing the character we want
            String symbol = new String(charPair);
            System.out.print(symbol);
            System.out.print(" ");
        }
// we now have str with the desired character as the first item confirm
// that we indeed have character with code point 128149
/*
        System.out.println("First code point: " + symbol.codePointAt(0));
        System.out.println("Second code point: " + symbol.codePointAt(1));
        System.out.println();

        String str = new String(charPair, 0, 2);
        System.out.println("First code point: " + str.codePointAt(0));    // 128149, worked
        String str2 = charPair.toString();
        System.out.println("Second code point: " + str2.codePointAt(0));  // 91, didn't work
        String str3 = new String(charPair);
        System.out.println("Third code point: " + str3.codePointAt(0));   // 128149, worked
        String str4 = String.valueOf(codePoint);
        System.out.println("Fourth code point: " + str4.codePointAt(0));  // 49, didn't work
        String str5 = new String(new int[] {codePoint}, 0, 1);
        System.out.println("Fifth code point: " + str5.codePointAt(0));   // 128149, worked
*/
    }
}
