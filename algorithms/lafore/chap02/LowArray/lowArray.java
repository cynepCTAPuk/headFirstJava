package lafore.chap02.LowArray;

// lowArray.java demonstrates array class with low-level interface
// to run this program: C>java LowArrayApp
class LowArray {
  private long[] a;

  public LowArray(int size) {
    a = new long[size];
  }

  public void setElem(int index, long value) {
    a[index] = value;
  }

  public long getElem(int index) {
    return a[index];
  }
}  // end class LowArray

class LowArrayApp {
  public static void main(String[] args) {
    LowArray lowArray;                     // reference
    lowArray = new LowArray(100);     // create LowArray object
    int nElems = 0;                      // number of items in array
    int searchKey;
    int i;                                 // loop variable

    lowArray.setElem(0, 77);   // insert 10 items
    lowArray.setElem(1, 99);
    lowArray.setElem(2, 44);
    lowArray.setElem(3, 55);
    lowArray.setElem(4, 22);
    lowArray.setElem(5, 88);
    lowArray.setElem(6, 11);
    lowArray.setElem(7, 00);
    lowArray.setElem(8, 66);
    lowArray.setElem(9, 33);
    nElems = 10;                          // now 10 items in array

    for (i = 0; i < nElems; i++) System.out.print(lowArray.getElem(i) + " ");
    System.out.println();

    searchKey = 66;                         // search for data item
    for (i = 0; i < nElems; i++) if (lowArray.getElem(i) == searchKey) break;
    if (i == nElems) System.out.println("Can't find " + searchKey);
    else System.out.println("Found " + searchKey + " \"Index\" = " + i);

    searchKey = 55;                         // delete value 55
    for (i = 0; i < nElems; i++) if (lowArray.getElem(i) == searchKey) break;
    for (int k = i; k < nElems; k++) lowArray.setElem(k, lowArray.getElem(k + 1));
    nElems--;                             // decrement size

    for (i = 0; i < nElems; i++) System.out.print(lowArray.getElem(i) + " ");
    System.out.println();
  }
}
