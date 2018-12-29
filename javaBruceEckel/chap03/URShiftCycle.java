package chap03;

//: operators/URShift.java
// Test of unsigned right shift.
public class URShiftCycle {
    public static void main(String[] args) {
        int j = 1;
        int k = 0;
        for (int i = 0; i < 33; i++) {
            System.out.format("%33s", Integer.toBinaryString(j << i));
            System.out.format("%-33s\n", Integer.toBinaryString((j << i)-1));
        }
    }
}