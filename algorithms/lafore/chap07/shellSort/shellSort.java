package lafore.chap07.shellSort;

// shellSort.java
// demonstrates shell sort
// to run this program: C>java ShellSortApp
//--------------------------------------------------------------
class ArraySh {
    private long[] theArray;          // ref to array theArray
    private int nElems;               // number of data items

    //--------------------------------------------------------------
    public ArraySh(int max) {           // constructor
        theArray = new long[max];       // create the array
        nElems = 0;                     // no items yet
    }

    //--------------------------------------------------------------
    public void insert(long value) {    // displays array contents
        theArray[nElems] = value;       // insert it
        nElems++;                       // increment size
    }

    //--------------------------------------------------------------
    public void display() {                         // displays array contents
        System.out.print("A= ");
        for (int j = 0; j < nElems; j++)            // for each element,
            System.out.print(theArray[j] + " ");    // display it
        System.out.println();
    }

    //--------------------------------------------------------------
    public void shellSort() {
        int inner, outer;
        long temp;

        int h = 1;                       // search initial value of h
        // 1, 4, 13, 40, 121, 364, 1_093, 3_280, 9_841, 29_524, 88_573, 265_720...)
        while (h <= nElems / 3) h = h * 3 + 1;

        while (h > 0) {                         // decreasing h, until h=1

            for (outer = h; outer < nElems; outer++) {  // h-sort the file

                for (int i = 0; i < theArray.length; i++) System.out.format("%,3d", theArray[i]);
                System.out.format("  h =%,2d ", h);

                temp = theArray[outer];
                inner = outer;

                while (inner > h - 1 && theArray[inner - h] >= temp) {  // one subpass (eg 0, 4, 8)
                    System.out.format("(%,2d = %,2d) <-> (%,2d = %,2d) ",
                            inner, temp, inner - h, theArray[inner - h]);
                    theArray[inner] = theArray[inner - h];
                    inner -= h;
                }
                System.out.println();
                theArray[inner] = temp;
            }  // end for

            h = (h - 1) / 3;              // decrease h
        }  // end while(h>0)
    }  // end shellSort()
//--------------------------------------------------------------
}  // end class ArraySh

////////////////////////////////////////////////////////////////
class ShellSortApp {
    public static void main(String[] args) {
        double t0;
        double t1;
        int maxSize = 20;            // array size
        System.out.println(String.format("Кол-во элементов = %,d", maxSize));

        ArraySh arr = new ArraySh(maxSize); // reference to array & create the array
        for (int j = 0; j < maxSize; j++) { // fill array with random numbers
            long n = (int) (java.lang.Math.random() * 99);
            arr.insert(n);
        }
//        arr.display();                    // display items
//        t0 = System.nanoTime();
        for (int i = 0; i < maxSize; i++) System.out.format("%,3d", i);
        System.out.println();
        System.out.println(" |--|--|--|--|--|--|--|--|--|--|--|--|--|--|--|--|--|--|--|");
        arr.shellSort();                    // shell sort the array
//        t1 = System.nanoTime();
//        System.out.println(String.format("ShellSort1\ttime nanoseconds =\t%,.0f", t1 - t0));
//        arr.display();                    // display them again
    }  // end main()
}  // end class ShellSortApp
////////////////////////////////////////////////////////////////
