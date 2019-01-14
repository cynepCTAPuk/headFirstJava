package chap11;

//: holding/StackTest.java
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        for (String s : "My dog has fleas".split(" ")) stack.push(s);
        for (String s : "0 1 2 3 4 5 6 7 8 9".split(" ")) stack2.push(s);
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
            if(stack.empty()) System.out.println();
        }
        while (!stack2.empty()) {
            System.out.print(stack2.pop() + " ");
            if(stack.empty()) System.out.println();
        }
    }
} /* Output:
fleas has dog My
*///:~