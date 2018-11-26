package lafore.chap03.InsertSort;

// InsertSortApp.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
//--------------------------------------------------------------
public class ArrayIns {
  private long[] a;                // ref to array a
  private int nElems;              // number of data items

  //--------------------------------------------------------------
  public ArrayIns(int size) {       // constructor
    a = new long[size];             // create the array
    nElems = 0;                    // no items yet
  }

  //--------------------------------------------------------------
  public void insert(long value) { // put element into array
    a[nElems] = value;             // insert it
    nElems++;                      // increment size
  }

  //--------------------------------------------------------------
  public void display() { // displays array contents
    for (int j = 0; j < nElems; j++) System.out.print(a[j] + "\t");  // for each element, display it
    System.out.println();
  }

  //--------------------------------------------------------------
  public void insertionSort() {
    for (int out = 1; out < nElems; out++) {  // out is dividing line
      long temp = a[out];                     // remove marked item
      int in = out;                           // start shifts at out
      while (in > 0 && a[in - 1] >= temp) {   // until one is smaller,
        a[in] = a[in - 1];                    // shift item to right
        --in;                                 // go left one position
      }
      a[in] = temp;                           // insert marked item
    }  // end for
  }  // end insertionSort()

  //--------------------------------------------------------------
  public void insertionSortReverse() {
    for (int out = 1; out < nElems; out++) {  // out is dividing line
      long temp = a[out];                     // remove marked item
      int in = out;                           // start shifts at out
      while (in > 0 && a[in - 1] < temp) {    // until one is smaller,
        a[in] = a[in - 1];                    // shift item to right
        --in;                                 // go left one position
      }
      a[in] = temp;                           // insert marked item
    }  // end for


  }  // end insertionSort()

  //--------------------------------------------------------------
  public long average() {
    long median = 0;
    for (int i = 0; i < nElems - 1; i++) {
      median = median + a[i];
    }
    return median / nElems;
  }

  //--------------------------------------------------------------
  public long median() {
    long median = 0;
    for (int i = 0; i < nElems; i++) {
      int increment = 0;
      for (int j = 0; j < nElems; j++) {
        if (a[i] > a[j]) increment++;
        if (a[i] < a[j]) increment--;
      }
      System.out.print(increment + "\t");
      if(increment == 0) {
        System.out.println();
        return a[i];
      }
    }
    System.out.println();
    return median / nElems;
  }

  //--------------------------------------------------------------
  public long medianSort() {
    insertionSort();
    if (nElems % 2 == 0) return (a[nElems / 2] + a[nElems / 2 - 1]) / 2;
    else return a[nElems / 2];
  }

  public static void main(String[] args) {
    int size = 31;
    ArrayIns array = new ArrayIns(size);
    for (int i = 0; i < size; i++) array.insert((long) (Math.random() * 900 + 100));
    System.out.println("Число элементов в массиве = " + array.nElems);
    array.display();
    array.median();
    System.out.println("Среднее арифметическое = " + array.average());
    System.out.println("Медиана через сортировку = " + array.medianSort());
    array.display();


  }
//--------------------------------------------------------------
}  // end class ArrayIns
