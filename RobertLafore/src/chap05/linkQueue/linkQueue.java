package lafore.chap05.linkQueue;

// linkQueue.java
// demonstrates queue implemented as double-ended list
// to run this program: C>java LinkQueueApp
////////////////////////////////////////////////////////////////
class Link {
    public long dData;                // data item
    public Link next;                 // next link in list

    // -------------------------------------------------------------
    public Link(long dd) { // constructor
        dData = dd;
    }

    // -------------------------------------------------------------
    public void displayLink() { // display this link
        System.out.print(dData + " ");
    }
// -------------------------------------------------------------
}  // end class Link

////////////////////////////////////////////////////////////////
class FirstLastList {
    private Link first;               // ref to first item
    private Link last;                // ref to last item

    // -------------------------------------------------------------
    public FirstLastList() {   // constructor
        first = null;                  // no items on list yet
        last = null;
    }

    // -------------------------------------------------------------
    public boolean isEmpty() { // true if no links
        return first == null;
    }

    // -------------------------------------------------------------
    public void insertLast(long dd) {           // insert at end of list
        Link newLink = new Link(dd);            // make new link
        if (isEmpty()) first = newLink;         // if empty list, first --> newLink
        else last.next = newLink;               // old last --> newLink
        last = newLink;                         // newLink <-- last
    }

    // -------------------------------------------------------------
    public long deleteFirst() {                 // delete first link (assumes non-empty list)
        if (!isEmpty()) {
            long temp = first.dData;
            if (first.next == null) last = null;    // if only one item null <-- last
            first = first.next;                     // first --> old next
            return temp;
        }
        return -1;
    }

    // -------------------------------------------------------------
    public void displayList() {
        Link current = first;          // start at beginning
        while (current != null) {   // until end of list,
            current.displayLink();      // print data
            current = current.next;     // move to next link
        }
        System.out.println("");
    }
// -------------------------------------------------------------
}  // end class FirstLastList

////////////////////////////////////////////////////////////////
class LinkQueue {
    private FirstLastList firstLastList;

    //--------------------------------------------------------------
    public LinkQueue() { // constructor
        firstLastList = new FirstLastList();
    }  // make a 2-ended list

    //--------------------------------------------------------------
    public void insert(long j) { // insert, rear of queue
        firstLastList.insertLast(j);
    }

    //--------------------------------------------------------------
    public long remove() { // remove, front of queue
        return firstLastList.deleteFirst();
    }

    //--------------------------------------------------------------
    public boolean isEmpty() { // true if queue is empty
        return firstLastList.isEmpty();
    }

    //--------------------------------------------------------------
    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        firstLastList.displayList();
    }
//--------------------------------------------------------------
}  // end class LinkQueue

////////////////////////////////////////////////////////////////
class LinkQueueApp {
    public static void main(String[] args) {
        LinkQueue theQueue = new LinkQueue();
        theQueue.insert(20);                 // insert items
        theQueue.insert(40);

        theQueue.displayQueue();             // display queue

        theQueue.insert(60);                 // insert items
        theQueue.insert(80);

        theQueue.displayQueue();             // display queue

        theQueue.remove();                   // remove items
        theQueue.remove();

        theQueue.displayQueue();             // display queue
    }  // end main()
}  // end class LinkQueueApp
////////////////////////////////////////////////////////////////
