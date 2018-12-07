package lafore.chap07.quickSort1;

// quickSort1.java
// demonstrates simple version of quick sort
// to run this program: C>java QuickSort1App
////////////////////////////////////////////////////////////////
class ArrayIns {
    private long[] theArray;          // ref to array theArray
    private int nElems;               // number of data items

    //--------------------------------------------------------------
    public ArrayIns(int max) {     // constructor
        theArray = new long[max];      // create the array
        nElems = 0;                    // no items yet
    }

    //--------------------------------------------------------------
    public void insert(long value) { // put element into array
        theArray[nElems] = value;      // insert it
        nElems++;                      // increment size
    }

    //--------------------------------------------------------------
    public void display() {     // displays array contents
        System.out.print("A= ");
        for (int j = 0; j < nElems; j++)    // for each element,
            System.out.print(theArray[j] + " ");  // display it
        System.out.println();
    }

    //--------------------------------------------------------------
    public void quickSort() {
        recQuickSort(0, nElems - 1);
    }

    //--------------------------------------------------------------
    public void recQuickSort(int left, int right) {
        if (right - left <= 0)                  // if size <= 1,
            return;                             //    already sorted
        else {                                  // size is 2 or larger
            long pivot = theArray[right];       // rightmost item
            // partition range
            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition - 1);   // sort left side
            recQuickSort(partition + 1, right);  // sort right side
        }
    }  // end recQuickSort()

    //--------------------------------------------------------------
    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;           // left    (after ++)
        int rightPtr = right;           // right-1 (after --)
        while (true) {
            while (theArray[++leftPtr] < pivot) ;  // search bigger item (nop)
            while (rightPtr > 0 && theArray[--rightPtr] > pivot) ;  // search smaller item (nop)

            if (leftPtr >= rightPtr) break;     // if pointers cross, partition done
            else swap(leftPtr, rightPtr);       // not crossed, so swap elements
        }  // end while(true)
        swap(leftPtr, right);           // restore pivot
        return leftPtr;                 // return pivot location
    }  // end partitionIt()

    //--------------------------------------------------------------
    public void swap(int dex1, int dex2) { // swap two elements
        long temp = theArray[dex1];        // A into temp
        theArray[dex1] = theArray[dex2];   // B into A
        theArray[dex2] = temp;             // temp into B
    }  // end swap(
//--------------------------------------------------------------
}  // end class ArrayIns

////////////////////////////////////////////////////////////////
class QuickSort1App {
    public static void main(String[] args) {
        double t0;
        double t1;
        int maxSize = 100_000_000;                       // array size
        System.out.println(String.format("Кол-во элементов = %,d", maxSize));

        ArrayIns arr = new ArrayIns(maxSize);            // create array
        for (int j = 0; j < maxSize; j++) {     // fill array with random numbers
            long n = (int) (100+java.lang.Math.random() * (999-100));
            arr.insert(n);
        }
//        arr.display();                          // display items
        t0 = System.nanoTime();
        arr.quickSort();                        // quicksort them
        t1 = System.nanoTime();
        System.out.println(String.format("QuickSort\ttime nanoseconds =\t%,.0f", t1-t0));
//        arr.display();                          // display them again
    }  // end main()
}  // end class QuickSort1App
////////////////////////////////////////////////////////////////
