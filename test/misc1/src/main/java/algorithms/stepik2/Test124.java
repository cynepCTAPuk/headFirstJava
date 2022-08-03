package algorithms.stepik2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Stepik Algorithm2: Стек с поддержкой максимума
 * Реализовать стек с поддержкой операций push, pop и max.
 * Вход: последовательность запросов push, pop и max.
 * Выход: для каждого запроса max вывести максимальное число, находящееся на стеке.
 */
public class Test124 {
    public static void main(String[] args) throws IOException {
        MaxStack maxStack = new MaxStack();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] commands = new String[n];
        for (int i = 0; i < n; i++) commands[i] = reader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : commands) {
            String[] strings = str.split(" ");
            String command = strings[0];
            if ("push".equals(command)) {
                maxStack.push(Integer.parseInt(strings[1]));
            } else if ("pop".equals(command)) {
                maxStack.pop();
            } else if ("max".equals(command)) {
                stringBuilder.append(maxStack.max()).append('\n');
            }
        }
        System.out.println(stringBuilder);
    }

    public static class MaxStack {
        Stack<Integer> stack;

        public MaxStack() {
            stack = new Stack<>();
        }

        void push(int i) {
            if (stack.isEmpty()) stack.push(i);
            else stack.push(Math.max(i, stack.peek()));
        }

        void pop() {
            stack.pop();
        }

        int max() {
            return stack.peek();
        }
    }
}
