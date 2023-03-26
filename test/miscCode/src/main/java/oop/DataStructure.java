package oop;

import java.util.Iterator;

public class DataStructure {
    private static final int SIZE = 15;
    private final int[] arrayOfInts = new int[SIZE];     // Create an array

    public DataStructure() {
        // fill the array with ascending integer values
        for (int i = 0; i < SIZE; i++) arrayOfInts[i] = i * 2;
    }

    public void printEven() {
        // Print out values of even indices of the array
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println();
    }

    interface DataStructureIterator extends Iterator<Integer> {
    }

    // Inner class implements the DataStructureIterator interface,
    // which extends the Iterator<Integer> interface
    private class EvenIterator implements DataStructureIterator {
        private int nextIndex = 0;        // Start stepping through the array from the beginning

        // Check if the current element is the last in the array
        public boolean hasNext() {
            return (nextIndex <= SIZE - 1);
        }

        public Integer next() {
            // Record a value of an even index of the array
            Integer next = arrayOfInts[nextIndex];
            nextIndex += 2;            // Get the next even element
            return next;
        }
    }

    public static void main(String[] s) {
        // Fill the array with integer values and print out only values of even indices
        DataStructure ds = new DataStructure();
        ds.printEven();
    }
}