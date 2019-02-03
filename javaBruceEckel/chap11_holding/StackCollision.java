package chap11_holding;

import util.*;

//: holding/StackCollision.java
public class StackCollision {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for(String s : "My dog has fleas (util.Stack)".split(" ")) stack.push(s);
        while(!stack.empty()) System.out.print(stack.pop() + " ");
        System.out.println();

        java.util.Stack<String> stack2 = new java.util.Stack<>();
        for(String s : "My dog has fleas (java.util.Stack)".split(" ")) stack2.push(s);
        while(!stack2.empty()) System.out.print(stack2.pop() + " ");
    }
} /* Output:
fleas has dog My
fleas has dog My
*///:~