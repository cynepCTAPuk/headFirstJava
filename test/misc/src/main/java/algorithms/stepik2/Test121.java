package algorithms.stepik2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Stepik Algorithm2: Расстановка скобок в коде<p>
 * Sample Input 1:<p>
 * ([](){([])})<p>
 * Sample Output 1:<p>
 * Success<p>
 * Sample Input 2:<p>
 * ()[]}<p>
 * Sample Output 2:<p>
 * 5<p>
 * Sample Input 3:<p>
 * {{[()]]<p>
 * Sample Output 3:<p>
 * 7
 */
public class Test121 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String brackets = scanner.nextLine();
        int result = isBalanced(brackets);
        if (result == -1) System.out.println("Success");
        else System.out.println(result);
    }

    private static int isBalanced(String string) {
        Deque<Character> stackBracket = new ArrayDeque<>();
        Deque<Integer> stackIndex = new ArrayDeque<>();
        String brackets = "[({])}";
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            int in = brackets.indexOf(ch);
            if (in == -1) {
                continue;
            }
            if (in < brackets.length() / 2) {
                stackBracket.push(ch);
                stackIndex.push(i + 1);
            } else {
                if (stackBracket.isEmpty()) {
                    return i + 1;
                }
                int out = brackets.indexOf(stackBracket.peek());
                if (out != in - 3) {
                    return i + 1;
                } else {
                    stackBracket.pop();
                    stackIndex.pop();
                }
            }
        }
        return stackBracket.isEmpty() ? -1 : stackIndex.pop();
    }
}
