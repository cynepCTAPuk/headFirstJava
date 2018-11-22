package lafore.chap02.OrderedArray;

// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray {
  private long[] a;                 // ref to array a
  private int nElems;               // number of data items

  //-----------------------------------------------------------
  public OrdArray(int max) {
    a = new long[max];             // create array
    nElems = 0;
  }

  //-----------------------------------------------------------
  public int size() {
    return nElems;
  }

  //-----------------------------------------------------------
  public int find(long searchKey) {
    int lowerBound = 0;
    int upperBound = nElems - 1;

    while (true) {
      int curIn = (lowerBound + upperBound) / 2;
      if (a[curIn] == searchKey) return curIn;              // found it
      else {
        if (lowerBound > upperBound) return nElems;         // can't search it
        else {
          if (a[curIn] < searchKey) lowerBound = curIn + 1; // it's in upper half
          else upperBound = curIn - 1;                      // it's in lower half
        } // end else divide range
      }
    } // end while
  } // end search()

  //-----------------------------------------------------------
  public void insert(long value) {
    int j;
    for (j = 0; j < nElems; j++) if (a[j] > value) break;   // linear search & search where it goes
    for (int k = nElems; k > j; k--) a[k] = a[k - 1];       // move bigger ones up
    a[j] = value;                  // insert it
    nElems++;                      // increment size
  }  // end insert()

  //-----------------------------------------------------------
  public boolean delete(long value) {
    int j = find(value);
    if (j == nElems) return false; // can't search it
    else {
      for (int k = j; k < nElems; k++) a[k] = a[k + 1];     // move bigger ones down
      nElems--;                                             // decrement size
      return true;
    }
  }  // end delete()

  //-----------------------------------------------------------
  public void display() {
    for (int j = 0; j < nElems; j++) System.out.print(a[j] + " ");
    System.out.println();
  } // end display()
}  // end class OrdArray

////////////////////////////////////////////////////////////////
class OrderedApp {
  public static void main(String[] args) {
    int maxSize = 100;                    // array size
    OrdArray arr = new OrdArray(maxSize); // reference to array &create the array

    arr.insert(77);                 // insert 10 items
    arr.insert(99);
    arr.insert(44);
    arr.insert(55);
    arr.insert(22);
    arr.insert(88);
    arr.insert(11);
    arr.insert(00);
    arr.insert(66);
    arr.insert(33);

    int searchKey = 55;                   // search for item
    if (arr.find(searchKey) != arr.size()) System.out.println("Found " + searchKey);
    else System.out.println("Can't search " + searchKey);

    arr.display();                        // display items
    arr.delete(00);                 // delete 3 items
    arr.delete(55);
    arr.delete(99);
    arr.display();                        // display items again
  } // end main()
} // end class OrderedApp
