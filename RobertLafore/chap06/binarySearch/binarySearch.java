package lafore.chap06.binarySearch;

// binarySearch.java
// demonstrates recursive binary search
// to run this program: C>java BinarySearchApp
////////////////////////////////////////////////////////////////
class ordArray {
    private long[] array;             // ref to array array
    private int nElems;               // number of data items

    //-----------------------------------------------------------
    public ordArray(int maxSize) {        // constructor
        array = new long[maxSize];        // create array
        nElems = 0;
    }

    //-----------------------------------------------------------
    public int size() {
        return nElems;
    }

    //-----------------------------------------------------------
    public int find(long searchKey) {
        return recursiveFind(searchKey, 0, nElems - 1);
    }

    //-----------------------------------------------------------
    private int recursiveFind(long searchKey, int lowerBound, int upperBound) {
        int curIn;

        curIn = (lowerBound + upperBound) / 2;
        if (array[curIn] == searchKey) return curIn;    // found it
        else {
            if (lowerBound > upperBound) return nElems; // can't search it
            else {                                      // divide range
                if (array[curIn] < searchKey) {         // it's in upper half
                    return recursiveFind(searchKey, curIn + 1, upperBound);
                } else {                                // it's in lower half
                    return recursiveFind(searchKey, lowerBound, curIn - 1);
                }
            }  // end else divide range
        }
    }  // end recursiveFind()

    //-----------------------------------------------------------
    public void insert(long value) {            // put element into array
        int i;
//        int j = find(value);
        if (value == array[find(value)]) {
            System.out.println(value+" is already exist in array");
        } else {
            for (i = 0; i < nElems; i++) if (array[i] > value) break;   // search where it goes (linear search)

            for (int k = nElems; k > i; k--) array[k] = array[k - 1];   // move bigger ones up

            array[i] = value;                                   // insert it
            nElems++;                                           // increment size
        }
    }  // end insert()

    //-----------------------------------------------------------
    public void display() {                         // displays array contents
        for (int j = 0; j < nElems; j++) System.out.print(array[j] + " ");  // for each element, display it
        System.out.println();
    }
    //-----------------------------------------------------------
}  // end class ordArray

////////////////////////////////////////////////////////////////
class BinarySearchApp {
    public static void main(String[] args) {
        int maxSize = 100;                  // ordArray size
        ordArray ordArray;                  // reference to ordArray
        ordArray = new ordArray(maxSize);   // create the ordArray

        ordArray.insert(72);          // insert items
        ordArray.insert(90);
        ordArray.insert(45);
        ordArray.insert(126);
        ordArray.insert(54);
        ordArray.insert(99);
        ordArray.insert(144);
        ordArray.insert(27);
        ordArray.insert(135);
        ordArray.insert(81);
        ordArray.insert(18);
        ordArray.insert(108);
        ordArray.insert(9);
        ordArray.insert(117);
        ordArray.insert(63);
        ordArray.insert(36);

        ordArray.insert(117);
        ordArray.insert(144);

        ordArray.display();                 // display ordArray

        int searchKey = 27;                 // search for item
        System.out.println(searchKey + " index of = " + ordArray.find(searchKey));
        if (ordArray.find(searchKey) != ordArray.size()) System.out.println("Found " + searchKey);
        else System.out.println("Can't search " + searchKey);
    }  // end main()
}  // end class BinarySearchApp
////////////////////////////////////////////////////////////////
