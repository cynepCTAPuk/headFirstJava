package chap03;

public class Exercise14 {
    public static void main(String[] args) {
        String a = "aString";
        String b = "bString";
        stringOps(a, b);
        stringOps("aaa", "aaa");
    }

    static void stringOps(String first, String second) {
        System.out.println(first + " & " + second);

        System.out.println("== " + (first == second));
        System.out.println("!= " + (first != second));
        System.out.println("equals " + first.equals(second));
        System.out.println();
    }
}
