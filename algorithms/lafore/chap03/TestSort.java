package lafore.chap03;

import lafore.chap03.BubbleSort.*;
import lafore.chap03.InsertSort.*;
import lafore.chap03.SelectSort.*;

public class TestSort {
  public static void main(String[] args) {
    int size = 10_000;
    ArrayBub arrayBub = new ArrayBub(size);
    ArrayIns arrayIns = new ArrayIns(size);
    ArraySel arraySel = new ArraySel(size);
    for (int i = 0; i < size; i++) {
      long n = (long) (java.lang.Math.random() * (size - 1) + 10_000);
      arrayBub.insert(n);
      arrayIns.insert(n);
      arraySel.insert(n);
    }
    System.out.println(String.format("Кол-во элементов = %,d", size));

    double t0 = System.nanoTime();
    arrayBub.bubbleSort();
    double tBub = System.nanoTime() - t0;
    System.out.println(String.format("tBub\t\ttime nanoseconds\t%,.0f", tBub));

    t0 = System.nanoTime();
    arrayIns.insertionSort();
    double tIns = System.nanoTime() - t0;
    System.out.println(String.format("tIns\t\ttime nanoseconds\t%,.0f", tIns));

    t0 = System.nanoTime();
    arraySel.selectionSort();
    double tSel = System.nanoTime() - t0;
    System.out.println(String.format("tSel\t\ttime nanoseconds\t%,.0f", tSel));


  }
}
