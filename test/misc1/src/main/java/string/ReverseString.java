/**
 * http://java.svlugovoy.com/reverse-string/
 * 5 способов перевернуть (инвертировать) строку в Java
 */
package string;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String string = "I love Java";

        StringBuilder stringBuilder = new StringBuilder(string);
        System.out.println("1) " + stringBuilder.reverse());

        char[] array = string.toCharArray();
        System.out.print("2) ");
        for (int i = array.length - 1; i >= 0; i--) System.out.print(array[i]);
        System.out.println();

        System.out.println("3) " + recursiveReverse(string));

        StringBuilder newStr = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) newStr.append(string.charAt(i));
        System.out.println("4) " + newStr);

        System.out.println("5) " + reverseByStack(string));
    }

    static String recursiveReverse(String s) {
        if ((null == s) || (s.length() <= 1)) return s;
        return recursiveReverse(s.substring(1)) + s.charAt(0);
    }

    public static String reverseByStack(String s) {
        Stack<Character> st = new Stack<Character>();
        for (Character character : s.toCharArray()) st.add(character);
        StringBuilder sb = new StringBuilder();
        while (st.size() > 0) sb.append(st.pop());
        return sb.toString();
    }
}
