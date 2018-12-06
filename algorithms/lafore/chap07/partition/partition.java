package lafore.chap07.partition;

// partition.java
// demonstrates partitioning an array
// to run this program: C>java PartitionApp
////////////////////////////////////////////////////////////////
class ArrayPar {
    private long[] theArray;            // ref to array theArray
    private int nElems;                 // number of data items

    //--------------------------------------------------------------
    public ArrayPar(int max) {          // constructor
        theArray = new long[max];       // create the array
        nElems = 0;                     // no items yet
    }

    public ArrayPar(ArrayPar arrayPar) {
        theArray = arrayPar.theArray;
        nElems = arrayPar.nElems;
    }

    //--------------------------------------------------------------
    public void insert(long value) {   // put element into array
        theArray[nElems] = value;      // insert it
        nElems++;                      // increment size
    }

    //--------------------------------------------------------------
    public int size() {     // return number of items
        return nElems;
    }

    //--------------------------------------------------------------
    public void display() {     // displays array contents
        System.out.print("Array = ");
        for (int i = 0; i < nElems; i++)    // for each element,
            System.out.print(theArray[i] + " ");  // display it
        System.out.println();
    }

    //--------------------------------------------------------------
    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;                 // right of first elem
        int rightPtr = right + 1;               // left of pivot
        while (true) {
            while (leftPtr < right && theArray[++leftPtr] < pivot) ; // search bigger item (nop)
            while (rightPtr > left && theArray[--rightPtr] > pivot) ;// search smaller item (nop)

            if (leftPtr >= rightPtr) break;     // if pointers cross, partition done
            else swap(leftPtr, rightPtr);       // not crossed, so swap elements
        }  // end while(true)
//        System.out.println("leftPtr - " + leftPtr + "  rightPtr -" + rightPtr);
        return leftPtr;                         // return partition
    }  // end partitionIt()

    //--------------------------------------------------------------
    public void swap(int dex1, int dex2) {     // swap two elements
        long temp;
        temp = theArray[dex1];             // A into temp
        theArray[dex1] = theArray[dex2];   // B into A
        theArray[dex2] = temp;             // temp into B
    }  // end swap()

    public long middle() {
        long sum = 0;
        if (nElems < 1) return -1;
        for (int i = 0; i < nElems; i++) {
            sum = sum + theArray[i];
        }
        return sum / nElems;
    }

    //--------------------------------------------------------------
    public ArrayPar cloneArrLeft() {
        ArrayPar arrayLeft = new ArrayPar(nElems / 2);
        for (int i = 0; i < nElems / 2; i++) arrayLeft.insert(theArray[i]);
        return arrayLeft;
    }

    //--------------------------------------------------------------
    public ArrayPar cloneArrRight() {
        ArrayPar arrayRight = new ArrayPar(nElems / 2);
        for (int i = 0; i < nElems / 2; i++) arrayRight.insert(theArray[nElems / 2 + i]);
        return arrayRight;
    }

//--------------------------------------------------------------
}  // end class ArrayPar

////////////////////////////////////////////////////////////////
class PartitionApp {
    public static void main(String[] args) {
        int maxSize = 32;             // array size
        ArrayPar arr = new ArrayPar(maxSize);  // reference to array & create the array

        for (int j = 0; j < maxSize; j++) {// Заполнение массива случайными числами
            long n = 10 + (int) (java.lang.Math.random() * ((99 - 10) + 1));
            arr.insert(n);
        }

        ArrayPar cloneArrLeft = arr.cloneArrLeft();
        ArrayPar cloneArrRight = arr.cloneArrRight();

        arr.display();                // display unsorted array
        cloneArrLeft.display();
        cloneArrRight.display();
        System.out.println("Middle cloneArrleft = " + cloneArrLeft.middle());
        System.out.println("Middle cloneArrRight = " + cloneArrRight.middle());

        long pivot = 54;              // pivot value
        System.out.print("Pivot is " + pivot);
        int size = arr.size();

        // partition array
        int partDex = arr.partitionIt(0, size - 1, pivot);
        System.out.println(", Partition is at index " + partDex);

        cloneArrLeft = arr.cloneArrLeft();
        cloneArrRight = arr.cloneArrRight();
        arr.display();                // display partitioned array
        cloneArrLeft.display();
        cloneArrRight.display();
        System.out.println("Middle Left = " + cloneArrLeft.middle());
        System.out.println("Middle Right = " + cloneArrRight.middle());
    }  // end main()
}  // end class PartitionApp
////////////////////////////////////////////////////////////////
