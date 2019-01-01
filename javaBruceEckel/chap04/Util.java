package chap04;

//: control/ForEachInt.java
public class Util {
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

    static void print(String string) {
        System.out.println(string);
    }
}