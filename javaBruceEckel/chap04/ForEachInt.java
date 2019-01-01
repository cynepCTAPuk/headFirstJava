package chap04;

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

    static int[] range(int end) {
        return range(0, end, 1);
    }

    static int[] range(int start, int end) {
        return range(start, end, 1);
    }

    static int[] range(int start, int end, int step) {
        int length = (end - start) / step;
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) array[i] = (start + (step * i));
        return array;
    }
} /* Output:
0 1 2 3 4 5 6 7 8 9
5 6 7 8 9
5 8 11 14 17
*///:~