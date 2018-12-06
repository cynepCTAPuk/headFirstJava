package tools;

import java.util.*;

public class Utility {
  /****************
   * @param coll an ArrayList of Comparable objects
   * @return the medianA of coll
   *****************/

  public static <T extends Number> double median(ArrayList<T> coll, Comparator<T> comp) {
    double result;
    int n = coll.size() / 2;

    if (coll.size() % 2 == 0) { // even number of items; find the middle two and average them
      result = (nth(coll, n - 1, comp).doubleValue() + nth(coll, n, comp).doubleValue()) / 2.0;
    } else                      // odd number of items; return the one in the middle
      result = nth(coll, n, comp).doubleValue();
    return result;
  } // medianA(coll)

  /*****************
   * @param coll a collection of Comparable objects
   * @param n  the position of the desired object, using the ordering defined on the list elements
   * @return the nth smallest object
   *******************/

  public static <T> T nth(ArrayList<T> coll, int n, Comparator<T> comp) {
    T result, pivot;
    ArrayList<T> underPivot = new ArrayList<>();
    ArrayList<T> overPivot = new ArrayList<>();
    ArrayList<T> equalPivot = new ArrayList<>();

    // choosing a pivot is a whole topic in itself.
    // this implementation uses the simple strategy of grabbing something from the middle of the ArrayList.

    pivot = coll.get(n / 2);
    System.out.println("----------------- n = " + n + " pivot = " + pivot);

    // split coll into 3 lists based on comparison with the pivot
    for (T obj : coll) {                        // for each obj in coll
      int order = comp.compare(obj, pivot);
      if (order < 0) underPivot.add(obj);       // obj < pivot
      else if (order > 0) overPivot.add(obj);   // obj > pivot
      else equalPivot.add(obj);                 // obj = pivot
    }
    System.out.println("Under " + underPivot.toString() + " size = " + underPivot.size());
    System.out.println("Equal " + equalPivot.toString() + " size = " + equalPivot.size());
    System.out.println("Over  " + overPivot.toString() + " size = " + overPivot.size());

    if (n < underPivot.size()) result = nth(underPivot, n, comp);       // recurse on the appropriate list
    else if (n < underPivot.size() + equalPivot.size()) result = pivot; // equal to pivot; just return it
    else  // everything in underPivot and equalPivot is too small.  Adjust n accordingly in the recursion.
      result = nth(overPivot, n - underPivot.size() - equalPivot.size(), comp);

    return result;
  } // nth(coll, n)


  public static void main(String[] args) {
    Comparator<Integer> comp = Comparator.naturalOrder();
    Random rnd = new Random();
    int arr = 10;
    for (int size = arr; size <= arr; size++) {
      ArrayList<Integer> coll = new ArrayList<>(size);
      for (int i = 0; i < size; i++) coll.add(rnd.nextInt(10));
      System.out.println(coll.toString());
      System.out.println("Median of " + coll.size() + " is " + median(coll, comp));
    } // for a range of possible input sizes
  } // main(args)
} // Utility