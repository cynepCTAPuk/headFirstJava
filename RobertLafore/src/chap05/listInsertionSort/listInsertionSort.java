package lafore.chap05.listInsertionSort;


// listInsertionSort.java
// demonstrates sorted list used for sorting
// to run this program: C>java ListInsertionSortApp
////////////////////////////////////////////////////////////////
class Link {
    public long dData;                  // data item
    public Link next;                   // next link in list

    // -------------------------------------------------------------
    public Link(long dd) {              // constructor
        dData = dd;
    }
// -------------------------------------------------------------
}  // end class Link

////////////////////////////////////////////////////////////////
class SortedList {
    private Link first;                     // ref to first item on list

    // -------------------------------------------------------------
    public SortedList() {                   // constructor (no args)
        first = null;
    }                                       // initialize list

    // -------------------------------------------------------------
    public SortedList(Link[] linkArr)  // constructor (array
    {                               // as argument)
        first = null;                        // initialize list
        for (int j = 0; j < linkArr.length; j++)  // copy array
            insert(linkArr[j]);             // to list
    }

    // -------------------------------------------------------------
    public void insert(Link k) {            // insert (in order)
        Link previous = null;               // start at first
        Link current = first;

        // until end of list or key > current,
        while (current != null && k.dData > current.dData) {
            previous = current;
            current = current.next;         // go to next item
        }
        if (previous == null) first = k;    // at beginning of list first --> k
        else previous.next = k;             // not at beginning old prev --> k
        k.next = current;                   // k --> old current
    }  // end insert()

    // -------------------------------------------------------------
    public Link remove() {          // return & delete first link (assumes non-empty list)
        Link temp = first;          // save first
        first = first.next;         // delete first
        return temp;                // return value
    }
// -------------------------------------------------------------
}  // end class SortedList

////////////////////////////////////////////////////////////////
class ListInsertionSortApp {
    public static void main(String[] args) {

        int size = 10_000;
        System.out.println(String.format("Кол-во элементов = %,d", size));
        // create array of links
        Link[] linkArray = new Link[size];

        double t0;
        double t1;

        t0 = System.nanoTime();
        for (int j = 0; j < size; j++) {   // fill array with links
            int n = (int) (java.lang.Math.random() * 99);   // random number
            Link newLink = new Link(n);  // make link
            linkArray[j] = newLink;      // put in array
        }
        t1 = System.nanoTime();
        System.out.println(String.format("Filling array by random numbers = %,.0f", t1 - t0));

//        System.out.print("Unsorted array: ");   // display array contents
//        for (int j = 0; j < size; j++) System.out.print(linkArray[j].dData + " ");
//        System.out.println();

        t0 = System.nanoTime();
        SortedList theSortedList = new SortedList(linkArray);
        t1 = System.nanoTime();
        System.out.println(String.format("Array to Sorted List = %,.0f", t1 - t0));

        t0 = System.nanoTime();
        for (int j = 0; j < size; j++)  // links from list to array
            linkArray[j] = theSortedList.remove();
        t1 = System.nanoTime();
        System.out.println(String.format("Sorted List to Array = %,.0f", t1 - t0));

//        System.out.print("Sorted Array:   ");   // display array contents
//        for (int i = 0; i < size; i++) System.out.print(linkArray[i].dData + " ");
//        System.out.println();

    }  // end main()
}  // end class ListInsertionSortApp
////////////////////////////////////////////////////////////////
