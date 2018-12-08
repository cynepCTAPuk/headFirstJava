package lafore.chap06.mergeSort;

// TreeBuild.java
// demonstrates recursive merge sort
// to run this program: C>java MergeSortApp
////////////////////////////////////////////////////////////////
class DArray {
    private long[] theArray;          // ref to array theArray
    private int nElems;               // number of data items

    //-----------------------------------------------------------
    public DArray(int max) {            // constructor
        theArray = new long[max];      // create array
        nElems = 0;
    }

    //-----------------------------------------------------------
    public void insert(long value) {    // put element into array
        theArray[nElems] = value;      // insert it
        nElems++;                      // increment size
    }

    //-----------------------------------------------------------
    public void display() {                         // displays array contents
        for (int j = 0; j < nElems; j++)            // for each element,
            System.out.format("%,3d ", theArray[j]);    // display it
        System.out.println();
    }

    //-----------------------------------------------------------
    public void mergeSort() {           // called by main() & provides workspace
        long[] workSpace = new long[nElems];
        recMergeSort(workSpace, 0, nElems - 1);
    }

    //-----------------------------------------------------------
    private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound)                       // if range is 1,
            return;                                         // no use sorting
        else {                                              // search midpoint
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);                  // sort low half
            recMergeSort(workSpace, mid + 1, upperBound);    // sort high half
            merge(workSpace, lowerBound, mid + 1, upperBound);  // merge them
        }  // end else

    }  // end recMergeSort()

    //-----------------------------------------------------------
    private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int j = 0;                                  // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;        // # of items

        while (lowPtr <= mid && highPtr <= upperBound) {
            for (long i : workSpace) System.out.format("%,3d ", i);
            System.out.println();
            if (theArray[lowPtr] < theArray[highPtr])
                workSpace[j++] = theArray[lowPtr++];
            else
                workSpace[j++] = theArray[highPtr++];
        }

        while (lowPtr <= mid) {
            for (long i : workSpace) System.out.format("%,3d ", i);
            System.out.println();
            workSpace[j++] = theArray[lowPtr++];
        }

        while (highPtr <= upperBound) {
            for (long i : workSpace) System.out.format("%,3d ", i);
            System.out.println();
            workSpace[j++] = theArray[highPtr++];
        }

        for (j = 0; j < n; j++) {
            theArray[lowerBound + j] = workSpace[j];
        }

        System.out.println();
    }  // end merge()
    //-----------------------------------------------------------
}  // end class DArray

////////////////////////////////////////////////////////////////
class MergeSortApp {
    public static void main(String[] args) {
        double t0;
        double t1;
        int maxSize = 10;                       // array size
        System.out.println(String.format("Кол-во элементов = %,d", maxSize));

        DArray arr = new DArray(maxSize);     // reference to array & create the array
        for (int i = 0; i < maxSize; i++) {      // fill array with random numbers
            long n = (int) (10 + java.lang.Math.random() * (99 - 10));
            arr.insert(n);
        }
        arr.display();                 // display items
//        t0 = System.nanoTime();
        arr.mergeSort();
//        t1 = System.nanoTime();
//        System.out.println(String.format("MergeSort\tnanoseconds =\t%,.0f", t1 - t0));
//        arr.display();                 // display items again
    }  // end main()
}  // end class MergeSortApp
////////////////////////////////////////////////////////////////
