package algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Stepik Algorithm2: 115 Проверка правильности расстановки скобок
 */
public class Brackets {
    public static void main(String[] args) {
        String brackets = "{([])({})}";
        System.out.println(isBalanced(brackets));
    }

    private static boolean isBalanced(String string) {
        Deque<Character> stack = new ArrayDeque<>();
        String brackets = "[({])}";
        for (char ch : string.toCharArray()) {
            int in = brackets.indexOf(ch);
            if (in == -1) {
                continue;
            }
            if (in < brackets.length()/2) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                int out = brackets.indexOf(stack.peek());
                if (out != in - 3) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
