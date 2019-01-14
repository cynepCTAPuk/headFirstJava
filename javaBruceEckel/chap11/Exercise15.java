package chap11;

public class Exercise15 {
    public static void main(String[] args) {
        String s = "+U+n+c—+e+r+t—+a-+i-+n+t+y—+ -+r+u—+l+e+s—";
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '+') stack.push(s.charAt(j + 1));
            if (s.charAt(j) == '-') System.out.print(stack.pop());
        }
        System.out.println();
        System.out.println(stack.toString());
    }
}

