package chap04_control;

//: control/IfElse2.java
public class IfElse2b {
    static int compare(int testval, int begin, int end) {
        if (begin > end) return -100;
        if (testval > end) {
            return +1;
        } else if (testval < begin) {
            return -1;
        } else return 0; // Match
    }

    public static void main(String[] args) {
        System.out.println(compare(11, 6, 10));
        System.out.println(compare(5, 6, 10));
        System.out.println(compare(6, 6, 10));
        System.out.println(compare(5, 10, 6));
    }
} /* Output:
1
-1
0
*///:~