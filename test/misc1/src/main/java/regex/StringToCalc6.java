package regex;

import java.util.Stack;

/**
 * https://algs4.cs.princeton.edu/13stacks/Evaluate.java.html
 *
 * Необходимо доработать.
 * Нв вход for() подавать не символы, а готовые выражения в виде чисел и функций.
 * Разбить входящцю строку на массив выражений и уже его обходить.
 * На данный момент, алгоритм работает корректно лишь с односимвольными выражениями.
 */
public class StringToCalc6 {

    public static void main(String[] args) {
        eval("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )");
    }

    public static void eval(String string) {
        string = string.replaceAll(" ", "");
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            String s = string.substring(i, i + 1);
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            } else vals.push(Double.parseDouble(s));
        }
        System.out.println(vals.pop());
    }
}
