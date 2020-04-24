package lafore.chap07.quickSort2;

// quickSort2.java
// demonstrates quick sort with medianSort-of-three partitioning
// to run this program: C>java QuickSort2App
////////////////////////////////////////////////////////////////
class ArrayIns {
    private long[] theArray;          // ref to array theArray
    private int nElems;               // number of data items

    //--------------------------------------------------------------
    public ArrayIns(int max) {      // constructor
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
        System.out.print("A=");
        for (int j = 0; j < nElems; j++)    // for each element,
            System.out.print(theArray[j] + " ");  // display it
        System.out.println("");
    }

    //--------------------------------------------------------------
    public void quickSort() {
        recQuickSort(0, nElems - 1);
    }

    //--------------------------------------------------------------
    public void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 3) manualSort(left, right);     // manual sort if small
        else {                                      // quicksort if large
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }  // end recQuickSort()

    //--------------------------------------------------------------
    public long medianOf3(int left, int right) {
        int center = (left + right) / 2;
        // order left & center
        if (theArray[left] > theArray[center]) swap(left, center);
        // order left & right
        if (theArray[left] > theArray[right]) swap(left, right);
        // order center & right
        if (theArray[center] > theArray[right]) swap(center, right);

        swap(center, right - 1);             // put pivot on right
        return theArray[right - 1];          // return medianSort value
    }  // end medianOf3()

    //--------------------------------------------------------------
    public void swap(int dex1, int dex2) {  // swap two elements
        long temp = theArray[dex1];         // A into temp
        theArray[dex1] = theArray[dex2];    // B into A
        theArray[dex2] = temp;              // temp into B
    }  // end swap(

    //--------------------------------------------------------------
    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left;             // right of first elem
        int rightPtr = right - 1;       // left of pivot

        while (true) {
            while (theArray[++leftPtr] < pivot) ;   // search bigger (nop)
            while (theArray[--rightPtr] > pivot) ;  // search smaller (nop)

            if (leftPtr >= rightPtr) break;         // if pointers cross, partition done
            else swap(leftPtr, rightPtr);           // not crossed, so swap elements
        }  // end while(true)
        swap(leftPtr, right - 1);         // restore pivot
        return leftPtr;                 // return pivot location
    }  // end partitionIt()

    //--------------------------------------------------------------
    public void manualSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1) return;                  // no sort necessary
        if (size == 2) {                        // 2-sort left and right
            if (theArray[left] > theArray[right]) swap(left, right);
            return;
        } else {                                // size is 3, 3-sort left, center, & right
            if (theArray[left] > theArray[right - 1]) swap(left, right - 1);    // left, center
            if (theArray[left] > theArray[right]) swap(left, right);            // left, right
            if (theArray[right - 1] > theArray[right]) swap(right - 1, right);  // center, right
        }
    }  // end manualSort()
//--------------------------------------------------------------
}  // end class ArrayIns

////////////////////////////////////////////////////////////////
class QuickSort2App {
    public static void main(String[] args) {
        double t0;
        double t1;
        int maxSize = 100_000_000;              // array size
        System.out.println(String.format("Кол-во элементов = %,d", maxSize));

        ArrayIns arr = new ArrayIns(maxSize);   // reference to array & create the array
        for (int j = 0; j < maxSize; j++) {     // fill array with random numbers
            long n = (int) (100 + java.lang.Math.random() * (999 - 100));
            arr.insert(n);
        }
//        arr.display();                        // display items
        t0 = System.nanoTime();
        arr.quickSort();                        // quicksort them
        t1 = System.nanoTime();
        System.out.println(String.format("QuickSort2\ttime nanoseconds =\t%,.0f", t1 - t0));
//        arr.display();                        // display them again
    }  // end main()
}  // end class QuickSort2App
////////////////////////////////////////////////////////////////
