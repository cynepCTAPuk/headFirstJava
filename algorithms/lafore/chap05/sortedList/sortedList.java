package lafore.chap05.sortedList;

import tools.Utils;

// sortedList.java
// demonstrates sorted list
// to run this program: C>java SortedListApp
////////////////////////////////////////////////////////////////
class Link {
    public long dData;                          // data item
    public Link next;                           // next link in list

    // -------------------------------------------------------------
    public Link(long dd) {                      // constructor
        dData = dd;
    }

    // -------------------------------------------------------------
    public void displayLink() {                 // display this link
        System.out.print(dData + " ");
    }
}  // end class Link

////////////////////////////////////////////////////////////////
class SortedList {
    private Link first;                         // ref to first item

    // -------------------------------------------------------------
    public SortedList() {                       // constructor
        first = null;
    }

    // -------------------------------------------------------------
    public boolean isEmpty() {                  // true if no links
        return (first == null);
    }

    // -------------------------------------------------------------
    public void insert(long key) {              // insert, in order
        Link newLink = new Link(key);           // make new link
        Link previous = null;                   // start at first
        Link current = first;

        // until end of list or key > current,
        while (current != null && key > current.dData) {
            previous = current;
            current = current.next;             // go to next item
        }
        if (previous == null) first = newLink;  // at beginning of list first --> newLink
        else previous.next = newLink;           // not at beginning old prev --> newLink
        newLink.next = current;                 // newLink --> old current
    }  // end insert()

    // -------------------------------------------------------------
    public Link remove() {                      // return & delete first link (assumes non-empty list)
        Link temp = first;                      // save first
        first = first.next;                     // delete first
        return temp;                            // return value
    }

    // -------------------------------------------------------------
    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;                   // start at beginning of list
        while (current != null) {               // until end of list,
            current.displayLink();              // print data
            current = current.next;             // move to next link
        }
        System.out.println();
    }
}  // end class SortedList

////////////////////////////////////////////////////////////////
class SortedListApp {
    public static void main(String[] args) {
/*
        SortedList sortedList = new SortedList();    // create new list
        sortedList.insert(20);                  // insert 2 items
        sortedList.insert(40);
        sortedList.displayList();                    // display list

        sortedList.insert(10);                  // insert 3 more items
        sortedList.insert(30);
        sortedList.insert(50);
        sortedList.displayList();                    // display list

        sortedList.remove();                         // remove an item
        sortedList.remove();                         // remove an item
        sortedList.displayList();                    // display list
*/

        int number = 1_000_000;
        System.out.println(String.format("Кол-во элементов = %,d", number));

        int[] array = new int[number];
        Utils.fillRandom100(array);
//        for (int i = 0; i < array.length; i++) array[i] = (int) (java.lang.Math.random() * 100);
//        for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
//        System.out.println();

        SortedList sortedListArray = new SortedList();
        double t0 = System.nanoTime();
        for (int i = 0; i < array.length; i++) sortedListArray.insert(array[i]);
        double t1 = System.nanoTime();
        System.out.println(String.format("Time in nanoseconds = %,.0f", t1 - t0));
//        sortedListArray.displayList();

    }  // end main()
}  // end class SortedListApp
////////////////////////////////////////////////////////////////
