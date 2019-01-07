package util;

//: control/ForEachInt.java
public class Range {
    // Produce a sequence [0..n)
    public static int[] range(int end) {
        return range(0, end, 1);
    }

    // Produce a sequence [start..end)
    public static int[] range(int start, int end) {
        return range(start, end, 1);
    }

    // Produce a sequence [start..end) incrementing by step
    public static int[] range(int start, int end, int step) {
        int size = (end - start) / step;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) array[i] = (start + (step * i));
        return array;
    }
}