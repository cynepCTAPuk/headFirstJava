package chap19_Collections;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("Geeks");
        stack.add("for");
        stack.add("Geeks");
        stack.add("10");
        stack.add("20");

        System.out.println(stack);

        System.out.println(stack.set(2, "GFG"));
        System.out.println(stack.set(4, "50"));

        System.out.println(stack);
    }
}
