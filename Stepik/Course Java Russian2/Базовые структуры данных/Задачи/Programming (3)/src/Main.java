import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        MaxStack maxStack = new MaxStack();
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(scanner.readLine());
        String[] commands = new String[n];
        for (int i = 0; i < n; i++) {
            commands[i] = scanner.readLine();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : commands) {
            String[] strings = s.split(" ");
            String command = strings[0];
            if ("push".equals(command)) {
                maxStack.push(Integer.parseInt(strings[1]));
            } else if ("max".equals(command)) {
                stringBuilder.append(maxStack.max()).append('\n');
            } else if ("pop".equals(command)) {
                maxStack.pop();
            }
        }
        System.out.println(stringBuilder);
    }

    public static class MaxStack {
        Stack<Integer> out = new Stack();

        void push(int i) {
            if (out.isEmpty()) out.push(i);
            else out.push(Math.max(i, out.peek()));
        }

        void pop() {
            out.pop();
        }

        int max() {
            return out.peek();
        }
    }
}
