package oop;

public class OutOfMemoryErrorTest1 {
    public static void main(String[] args) {
        while (true) {
            new Object();
        }
    }
}
