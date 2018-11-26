package lafore.chap03.InsertSort;

////////////////////////////////////////////////////////////////
class InsertSortApp {
  public static void main(String[] args) {
    int maxSize = 100;            // array size
    ArrayIns arr = new ArrayIns(maxSize);  // reference to array & create the array

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
    arr.insertionSortReverse();          // insertion-sort them
    arr.display();                // display them again

    int size = 1_000;
    ArrayIns array = new ArrayIns(size);  // reference to array ? сreate the array
    for (int i = 0; i < size; i++) {
      long n = (long) (java.lang.Math.random() * (size - 1) + 10_000);
      array.insert(n);
    }
    double t0 = System.nanoTime();
    array.insertionSort();
    double t1 = System.nanoTime() - t0;
    System.out.println(String.format("Время выполнения %,.0f наносекунд", t1));
  }  // end main()
}  // end class InsertSortApp
