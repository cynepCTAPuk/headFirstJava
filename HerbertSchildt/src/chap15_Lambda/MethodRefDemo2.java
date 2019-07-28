package chap15_Lambda;

class MyStringOps1 {
    String strReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) result += str.charAt(i);
        return result;
    }
}

public class MethodRefDemo2 {
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lambdas add power to Java";
        String outStr;

        MyStringOps1 strOps = new MyStringOps1();

        outStr = stringOp(strOps::strReverse, inStr);
        System.out.println("Original string: " + inStr);
        System.out.println("String reversed: " + outStr);
    }
}
