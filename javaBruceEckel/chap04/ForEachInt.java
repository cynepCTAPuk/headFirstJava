package chap04;

import static chap04.Util.range;

//: control/ForEachInt.java
public class ForEachInt {
    public static void main(String[] args) {
        for (int i : range(10)) System.out.print(i + " ");   // 0..9
        System.out.println();

        for (int i : range(5, 10)) System.out.print(i + " ");  // 5..9
        System.out.println();

        for (int i : range(5, 20, 3)) System.out.print(i + " ");   // 5..20 step 3
        System.out.println();
    }
} /* Output:
0 1 2 3 4 5 6 7 8 9
5 6 7 8 9
5 8 11 14 17
*///:~