package lafore.chap03.InsertSort;

import java.util.*;

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
  //--------------------------------------------------------------
  public long medianSort() {
    insertionSort();
    if (nElems % 2 == 0) return (a[nElems / 2] + a[nElems / 2 - 1]) / 2;
    else return a[nElems / 2];
  }

  public long median() {
    long median = 0;
    int qty = 0;
    long med;
    Stack stack1 = new Stack();
    Stack stack2 = new Stack();
    Stack stack3 = new Stack();
    Stack stack4 = new Stack();
    Stack stack5 = new Stack();
    stack1.push(median);
    stack2.push(median);
    stack3.push(median);
    stack4.push(median);
    stack5.push(median);
    for (int i = 0; i < nElems; i++) {
      int increment = 0;
      for (int j = 0; j < nElems; j++) {
        if (a[i] > a[j]) increment++;
        if (a[i] < a[j]) increment--;
      }
      System.out.print(increment + "\t");
      if (increment == 0) {
        System.out.println();
        return a[i];
      }
      if (increment == 1 || increment == -1) stack1.push(a[i]);
      if (increment == 2 || increment == -2) stack2.push(a[i]);
      if (increment == 3 || increment == -3) stack3.push(a[i]);
      if (increment == 4 || increment == -4) stack4.push(a[i]);
      if (increment == 5 || increment == -5) stack5.push(a[i]);
    }
    System.out.println();
    if (stack1.size() > 1) {
      for (int k = 0; k < stack1.size(); k++) {
        qty++;
        med = (long) stack1.pop();
        System.out.println("stack1 " + qty + " med " + med);
        median += med;
      }
      return median / qty;
    }
    if (stack2.size() > 1) {
      for (int k = 0; k < stack2.size(); k++) {
        qty++;
        med = (long) stack2.pop();
        System.out.println("stack2 " + qty + " med " + med);
        median += med;
      }
      return median / qty;
    }
    if (stack3.size() > 1) {
      for (int k = 0; k < stack3.size(); k++) {
        qty++;
        med = (long) stack3.pop();
        System.out.println("stack3 " + qty + " med " + med);
        median += med;
      }
      return median / qty;
    }
    if (stack4.size() > 1) {
      for (int k = 0; k < stack4.size(); k++) {
        qty++;
        med = (long) stack4.pop();
        System.out.println("stack3 " + qty + " med " + med);
        median += med;
      }
      return median / qty;
    }
    if (stack5.size() > 1) {
      for (int k = 0; k < stack5.size(); k++) {
        qty++;
        med = (long) stack5.pop();
        System.out.println("stack3 " + qty + " med " + med);
        median += med;
      }
      return median / qty;
    }
    System.out.println("-=Увы, алгоритм не работает хорошо при повторяющихся элементах=-");
    return -1;
  }

  public static void main(String[] args) {
    int size = 64;
    ArrayIns array = new ArrayIns(size);
    for (int i = 0; i < size; i++) array.insert((long) (Math.random() * 10 + 10));
    System.out.println("Число элементов в массиве = " + array.nElems);
    System.out.println("Среднее арифметическое = " + array.average());
    array.display();
    System.out.println("Медиана через сравнение  = " + array.median());
    System.out.println("Медиана через сортировку = " + array.medianSort());
    array.display();
  }
//--------------------------------------------------------------
}  // end class ArrayIns
