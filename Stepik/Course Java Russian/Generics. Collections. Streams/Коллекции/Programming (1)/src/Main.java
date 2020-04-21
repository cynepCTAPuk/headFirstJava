import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String string = reader.readLine();
            String[] array = string.split(" ");
            Stack<Integer> stack = new Stack<>();
            for (int i = 1; i < array.length; i = i + 2) {
                stack.push(Integer.parseInt(array[i]));
            }
            while (!stack.empty()) {
                System.out.print(stack.pop() + " ");
            }
        } catch (Exception e) {
        }
    }
}
