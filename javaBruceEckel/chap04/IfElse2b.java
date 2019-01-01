package chap04;

//: control/IfElse2.java
public class IfElse2b {
    static int compare(int testval, int target) {
        if (testval > target) {
            return +1;
        } else if (testval < target) {
            return -1;
        } else return 0; // Match
    }

    public static void main(String[] args) {
        System.out.println(compare(10, 5));
        System.out.println(compare(5, 10));
        System.out.println(compare(5, 5));
    }
} /* Output:
1
-1
0
*///:~