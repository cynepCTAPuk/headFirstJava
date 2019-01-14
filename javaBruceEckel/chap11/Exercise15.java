package chap11;

public class Exercise15 {
    public static void main(String[] args) {
        String s = "+U+n+c—+e+r+t—+a-+i-+n+t+y—+ -+r+u—+l+e+s—";
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) stack.push(s.charAt(i));
        for (int i = 0; i < s.length(); i++) System.out.println(stack.pop());
    }
}

