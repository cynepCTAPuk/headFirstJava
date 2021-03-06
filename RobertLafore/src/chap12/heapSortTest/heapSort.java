package lafore.chap12.heapSortTest;
// heapSort.java
// demonstrates heap sort
// to run this program: C>java HeapSortApp

import java.io.*;

////////////////////////////////////////////////////////////////
class Node {
    private int iData;             // data item (key)

    // -------------------------------------------------------------
    public Node(int key) {        // constructor
        iData = key;
    }

    // -------------------------------------------------------------
    public int getKey() {
        return iData;
    }
// -------------------------------------------------------------
}  // end class Node

////////////////////////////////////////////////////////////////
class Heap {
    private Node[] heapArray;
    private int maxSize;           // size of array
    private int currentSize;       // number of items in array

    // -------------------------------------------------------------
    public Heap(int maxSize) {        // constructor
        this.maxSize = maxSize;
        currentSize = 0;
        heapArray = new Node[this.maxSize];
    }

    // -------------------------------------------------------------
    public Node remove() {    // delete item with max key (assumes non-empty list)
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }  // end remove()

    // -------------------------------------------------------------
    public void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];        // save root
        while (index < currentSize / 2) {    // not on bottom row
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            // search larger child
            if (rightChild < currentSize &&   // right ch exists?
                    heapArray[leftChild].getKey() <
                            heapArray[rightChild].getKey())
                largerChild = rightChild;
            else
                largerChild = leftChild;
            // top >= largerChild?
            if (top.getKey() >= heapArray[largerChild].getKey())
                break;
            // shift child up
            heapArray[index] = heapArray[largerChild];
            index = largerChild;             // go down
        }  // end while
        heapArray[index] = top;             // root to index
    }  // end trickleDown()

    // -------------------------------------------------------------
    public void insertAt(int index, Node newNode) {
        heapArray[index] = newNode;
    }

    // -------------------------------------------------------------
    public void incrementSize() {
        currentSize++;
    }
// -------------------------------------------------------------
}  // end class Heap

////////////////////////////////////////////////////////////////
class HeapSortApp {
    public static void main(String[] args) throws IOException {
        int size = 1_000_000;
        int i;
        Heap theHeap = new Heap(size);

        for (i = 0; i < size; i++) {  // fill array with random nodes
            int random = (int) (10 + Math.random() * (99 - 10));
            Node newNode = new Node(random);
            theHeap.insertAt(i, newNode);
            theHeap.incrementSize();
        }

        for (i = size / 2 - 1; i >= 0; i--) {  // make random array into heap
            theHeap.trickleDown(i);
        }

        double t0 = System.nanoTime();
        for (i = size - 1; i >= 0; i--) {    // remove from heap and store at array end
            Node biggestNode = theHeap.remove();
            theHeap.insertAt(i, biggestNode);
        }
        double t1 = System.nanoTime();

        System.out.format("heapSort:%nsize array = %,d%nNanoseconds = %,.0f%n", size, t1 - t0);
    }  // end main()

    // -------------------------------------------------------------
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    //-------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
// -------------------------------------------------------------
}  // end class HeapSortApp
////////////////////////////////////////////////////////////////
