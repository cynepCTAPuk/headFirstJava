package lafore.chap02.HighArray;

// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray {
  private long[] a;                 // ref to array a
  private int nElems;               // number of data items

  //-----------------------------------------------------------
  public HighArray(int max) {
    a = new long[max];                 // create the array
    nElems = 0;                        // no items yet
  }

  //-----------------------------------------------------------
  public boolean find(long searchKey) {
    int i;
    System.out.println("Looking for " + searchKey);
    for (i = 0; i < nElems; i++) if (a[i] == searchKey) break;
    if (i == nElems) return false;
    else return true;
  }

  //-----------------------------------------------------------
  public void insert(long value) {
    a[nElems] = value;             // insert it
    nElems++;                      // increment size
    System.out.println("Inserted " + value);
  }

  //-----------------------------------------------------------
  public boolean delete(long value) {
    int j;
    for (j = 0; j < nElems; j++)
      if (value == a[j]) break;
    if (j == nElems)
      return false;
    else {
      for (int k = j; k < nElems; k++)
        a[k] = a[k + 1];
      nElems--;                   // decrement size
      System.out.println("Deleted " + value);
      return true;
    }
  }  // end delete()

  //-----------------------------------------------------------
  public void display() {
    for (int j = 0; j < nElems; j++) System.out.print(a[j] + " ");
    System.out.println("");
  }
  //-----------------------------------------------------------
}  // end class HighArray

////////////////////////////////////////////////////////////////
class HighArrayApp {
  public static void main(String[] args) {
    int maxSize = 100;            // array size
    HighArray highArray = new HighArray(maxSize);

    highArray.insert(77);               // insert 10 items
    highArray.insert(99);
    highArray.insert(44);
    highArray.insert(55);
    highArray.insert(22);
    highArray.insert(88);
    highArray.insert(11);
    highArray.insert(00);
    highArray.insert(66);
    highArray.insert(33);

    highArray.display();                // display items

    int searchKey = 35;           // search for item
    if (highArray.find(searchKey)) System.out.println("Found " + searchKey);
    else System.out.println("Can't find " + searchKey);

    highArray.delete(00);               // delete 3 items
    highArray.delete(55);
    highArray.delete(99);

    highArray.display();                // display items again
  }  // end main()
}  // end class HighArrayApp
