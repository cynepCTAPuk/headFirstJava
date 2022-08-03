package integer.task3714;

import java.io.IOException;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Input a roman number to be converted to decimal: ");
//        String romanString = bufferedReader.readLine();
        String romanString = "MMDDCCLLXXVVII";
        System.out.println("Conversion result equals " + romanToInteger(romanString));
        System.out.println("Conversion result equals " + toArabic(romanString));
    }

    public static int romanToInteger(String s) {
        String roman = "IVXLCDM";
        int[] dec = new int[]{1, 5, 10, 50, 100, 500, 1000};
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = dec[roman.indexOf(s.toCharArray()[i])];
            int next = current;
            if (i + 1 < s.length()) next = dec[roman.indexOf(s.toCharArray()[i + 1])];
            if (next > current) current = -current;
            result += current;
        }
        return result;
    }
    public static int toArabic(String number) {
        if (number == null || number.equals("")) return 0;
        if (number.startsWith("M")) return 1000 + toArabic(number.substring(1));
        if (number.startsWith("CM")) return 900 + toArabic(number.substring(2));
        if (number.startsWith("D")) return 500 + toArabic(number.substring(1));
        if (number.startsWith("CD")) return 400 + toArabic(number.substring(2));
        if (number.startsWith("C")) return 100 + toArabic(number.substring(1));
        if (number.startsWith("XC")) return 90 + toArabic(number.substring(2));
        if (number.startsWith("L")) return 50 + toArabic(number.substring(1));
        if (number.startsWith("XL")) return 40 + toArabic(number.substring(2));
        if (number.startsWith("X")) return 10 + toArabic(number.substring(1));
        if (number.startsWith("IX")) return 9 + toArabic(number.substring(2));
        if (number.startsWith("V")) return 5 + toArabic(number.substring(1));
        if (number.startsWith("IV")) return 4 + toArabic(number.substring(2));
        if (number.startsWith("I")) return 1 + toArabic(number.substring(1));
        return 0;
    }
}
