package util;

//: control/ForEachInt.java
public class Range {
    public static int[] range(int end) {
        return range(0, end, 1);
    }

    public static int[] range(int start, int end) {
        return range(start, end, 1);
    }

    public static int[] range(int start, int end, int step) {
        int size = (end - start) / step;
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) array[i] = (start + (step * i));
        return array;
    }
}