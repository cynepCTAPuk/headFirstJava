package oop;

import java.util.Iterator;

public class DataStructure {
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];     // Create an array

    public DataStructure() {
        for (int i = 0; i < SIZE; i++) arrayOfInts[i] = i; // fill the array with ascending integer values
    }

    public void printEven() {
        // Print out values of even indices of the array
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println();
    }

    interface DataStructureIterator extends Iterator<Integer> {
    }

    // Inner class implements the DataStructureIterator interface, which extends the Iterator<Integer> interface
    private class EvenIterator implements DataStructureIterator {
        private int nextIndex = 0;        // Start stepping through the array from the beginning

        public boolean hasNext() {
            return (nextIndex <= SIZE - 1); // Check if the current element is the last in the array
        }

        public Integer next() {
            // Record a value of an even index of the array
            Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
            nextIndex += 2;            // Get the next even element
            return retValue;
        }
    }

    public static void main(String[] s) {
        // Fill the array with integer values and print out only values of even indices
        DataStructure ds = new DataStructure();
        ds.printEven();
    }
}