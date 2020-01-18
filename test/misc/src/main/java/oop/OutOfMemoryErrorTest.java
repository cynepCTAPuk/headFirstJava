package oop;

public class OutOfMemoryErrorTest {
    public static void main(String[] args) {
        long[] l = new long[Integer.MAX_VALUE];
    }
}
