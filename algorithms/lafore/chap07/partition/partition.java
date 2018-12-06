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
        System.out.print("Array = [");
        for (int j = 0; j < nElems; j++)    // for each element,
            System.out.print(theArray[j] + " ");  // display it
        System.out.println("]");
    }

    //--------------------------------------------------------------
    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;           // right of first elem
        int rightPtr = right + 1;         // left of pivot
        while (true) {
            while (leftPtr < right &&       // search bigger item
                    theArray[++leftPtr] < pivot)
                ;  // (nop)

            while (rightPtr > left &&       // search smaller item
                    theArray[--rightPtr] > pivot)
                ;  // (nop)
            if (leftPtr >= rightPtr)        // if pointers cross,
                break;                      //    partition done
            else                           // not crossed, so
                swap(leftPtr, rightPtr);    //    swap elements
        }  // end while(true)
        return leftPtr;                   // return partition
    }  // end partitionIt()

    //--------------------------------------------------------------
    public void swap(int dex1, int dex2) {     // swap two elements
        long temp;
        temp = theArray[dex1];             // A into temp
        theArray[dex1] = theArray[dex2];   // B into A
        theArray[dex2] = temp;             // temp into B
    }  // end swap()
//--------------------------------------------------------------
}  // end class ArrayPar

////////////////////////////////////////////////////////////////
class PartitionApp {
    public static void main(String[] args) {
        int maxSize = 30;             // array size
        ArrayPar arr = new ArrayPar(maxSize);  // reference to array & create the array
        ArrayPar arr1 = new ArrayPar(maxSize / 2);
        ArrayPar arr2 = new ArrayPar(maxSize / 2);

        for (int i = 0; i < maxSize; i++) {     // fill array with random numbers
            long n = (int) (java.lang.Math.random() * 199);
            arr.insert(n);
            if(i<maxSize/2) arr1.insert(n);
            else arr2.insert(n);
        }
        arr.display();                // display unsorted array
        arr1.display();
        arr2.display();

        long pivot = 99;              // pivot value
        System.out.print("Pivot is " + pivot);
        int size = arr.size();
        // partition array
        int partDex = arr.partitionIt(0, size - 1, pivot);

        System.out.println(", Partition is at index " + partDex);
        arr.display();                // display partitioned array
        System.out.println();
    }  // end main()
}  // end class PartitionApp
////////////////////////////////////////////////////////////////
