package lafore.chap03.BubbleSort;

////////////////////////////////////////////////////////////////
class BubbleSortApp {
  public static void main(String[] args) {
    int maxSize = 100;            // array size
    ArrayBub arr = new ArrayBub(maxSize);  // reference to array ? сreate the array

    arr.insert(77);               // insert 10 items
    arr.insert(99);
    arr.insert(44);
    arr.insert(55);
    arr.insert(22);
    arr.insert(88);
    arr.insert(11);
    arr.insert(00);
    arr.insert(66);
    arr.insert(33);

    arr.display();                // display items
    arr.bubbleSort();             // bubble sortB them
    arr.display();                // display them again

    int size = 100_000;
    ArrayBub array = new ArrayBub(size);  // reference to array ? сreate the array
    for (int i = 0; i < size; i++) {
      long n = (long) (java.lang.Math.random()*(size-1)+10_000);
      array.insert(n);
    }
//    array.display();
    double t0 = System.nanoTime();
    array.bubbleSort();
    System.out.println(System.nanoTime()-t0);
//    array.display();
  }  // end main()
}  // end class BubbleSortApp
////////////////////////////////////////////////////////////////
