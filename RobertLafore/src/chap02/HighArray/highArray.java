package lafore.chap02.HighArray;

// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray {
  private long[] a;                     // ref to array a
  private int nElems;                   // number of data items

  //-----------------------------------------------------------
  HighArray(int max) {                  //constructor
    a = new long[max];                  // create the array
    nElems = 0;                         // no items yet
  }

  public int getnElems() {
    return nElems;
  }

  //-----------------------------------------------------------
  public boolean find(long searchKey) {
    int i;
    System.out.println("Looking for " + searchKey);
    for (i = 0; i < nElems; i++) if (a[i] == searchKey) break;
    return i != nElems;
  }

  //-----------------------------------------------------------
  public void insert(long value) {
    a[nElems] = value;             // insert it
    nElems++;                      // increment size
//    System.out.println("Inserted " + value);
  }

  //-----------------------------------------------------------
  public boolean delete(long value) {
    int j;
    for (j = 0; j < nElems; j++) if (value == a[j]) break;
    if (j == nElems) return false;
    else {
      for (int k = j; k < nElems; k++) a[k] = a[k + 1];
      nElems--;                   // decrement size
//      System.out.println("Deleted " + value);
      return true;
    }
  }  // end delete()

  //-----------------------------------------------------------
  public void display() {
    for (int j = 0; j < nElems; j++) System.out.print(a[j] + " ");
    System.out.println();
  }

  //-----------------------------------------------------------
  public long removeMax() {
    if (nElems == 0) return -1;
    int index = 0;
    long max;
    for (int i = 0; i < nElems; i++) {
      if (a[i + 1] > a[index]) index = i + 1;
    }
    max = a[index];
//    System.out.println("Удаляем максимальный элемент");
    delete(max);
    return max;
  }

}  // end class HighArray

////////////////////////////////////////////////////////////////
class HighArrayApp {
  public static void main(String[] args) {
    int maxSize = 100;            // array size
    HighArray highArray1 = new HighArray(maxSize);
    HighArray highArray2 = new HighArray(maxSize);

    highArray1.insert(77);               // insert 10 items
    highArray1.insert(99);
    highArray1.insert(44);
    highArray1.insert(55);
    highArray1.insert(22);
    highArray1.insert(88);
    highArray1.insert(11);
    highArray1.insert(00);
    highArray1.insert(66);
    highArray1.insert(33);

    highArray1.display();                // display items
//    highArray1.removeMax();

//    int searchKey = 35;           // search for item
//    if (highArray1.find(searchKey)) System.out.println("Found " + searchKey);
//    else System.out.println("Can't search " + searchKey);

    highArray2.display();                // display items again
    int size = highArray1.getnElems();
    for (int i = 0; i < size; i++) highArray2.insert(highArray1.removeMax());
    highArray1.display();                // display items again
    highArray2.display();                // display items again

  }  // end main()
}  // end class HighArrayApp
