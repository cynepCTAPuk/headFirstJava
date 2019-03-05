package lafore.chap12.PriorityQ;

// priorityQ.java
// demonstrates priority queue
// to run this program: C>java PriorityQApp
////////////////////////////////////////////////////////////////
class PriorityQ { // array in sorted order, from max at 0 to min at size-1
    private int maxSize;
    private long[] queArray;
    private int nItems;

    //-------------------------------------------------------------
    public PriorityQ(int maxSize) {             // constructor
        this.maxSize = maxSize;
        queArray = new long[this.maxSize];
        nItems = 0;
    }

    //-------------------------------------------------------------
    public void insert(long item) {             // insert item
        int i;
        if (isFull()) {
            System.out.println("Priority Queue is Full");
        } else {
            if (nItems == 0) {
                queArray[nItems++] = item;      // if no items, insert at 0
            } else {                            // if items,
                for (i = nItems - 1; i >= 0; i--) {     // start at end,
                    // if new item larger, shift upward
                    if (item > queArray[i]) {
                        queArray[i + 1] = queArray[i];
                    } else break;                 // if smaller, done shifting
                }                               // end for
                queArray[i + 1] = item;         // insert it
                nItems++;
            }
        } // end else (nItems > 0)
    }  // end insert()

    //-------------------------------------------------------------
    public long remove() {                      // remove minimum item
        return queArray[--nItems];
    }

    //-------------------------------------------------------------
    public long peekMin() {                     // peek at minimum item
        return queArray[nItems - 1];
    }

    //-------------------------------------------------------------
    public boolean isEmpty() {                  // true if queue is empty
        return (nItems == 0);
    }

    //-------------------------------------------------------------
    public boolean isFull() {                   // true if queue is full
        return (nItems == maxSize);
    }
//-------------------------------------------------------------
}  // end class PriorityQ

////////////////////////////////////////////////////////////////
class PriorityQApp {
    public static void main(String[] args) {
        int maxSize = 5;
        PriorityQ priorityQ = new PriorityQ(maxSize);
        priorityQ.insert(30);
        priorityQ.insert(50);
        priorityQ.insert(10);
        priorityQ.insert(40);
        priorityQ.insert(20);
        priorityQ.insert(90);

        while (!priorityQ.isEmpty()) {
            long item = priorityQ.remove();
            System.out.print(item + " ");       // 10, 20, 30, 40, 50
        }  // end while
        System.out.println();
    }  // end main()
//-------------------------------------------------------------
}  // end class PriorityQApp
////////////////////////////////////////////////////////////////
