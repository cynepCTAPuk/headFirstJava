package lafore.chap05.linkList;

// linkList.java
// demonstrates linked list
// to run this program: C>java LinkListApp
////////////////////////////////////////////////////////////////
class Link {
   private int iData;              // data item
   private double dData;           // data item
   public Link next;              // next link in list

   // -------------------------------------------------------------
   public Link(int id, double dd) { // constructor
      iData = id;                   // initialize data
      dData = dd;                   // ('next' is automatically set to null)
   }

   // -------------------------------------------------------------
   public void displayLink() {      // display ourself
      System.out.print("{" + iData + ", " + dData + "} ");
   }
}  // end class Link

////////////////////////////////////////////////////////////////
class LinkList {
   private Link first;            // ref to first link on list

   // -------------------------------------------------------------
   public LinkList() {            // constructor
      first = null;               // no links on list yet
   }

   // -------------------------------------------------------------
   public boolean isEmpty() {      // true if list is empty
      return (first == null);
   }

   // -------------------------------------------------------------
   // insert at start of list
   public void insertFirst(int id, double dd) {
      Link newLink = new Link(id, dd);          // make new link and new object Link
      newLink.next = first;                     // newLink --> old first
      first = newLink;                          // first --> newLink
   }

   // -------------------------------------------------------------
   public Link deleteFirst() {                  // delete first item (assumes list not empty)
      Link temp = first;                        // save reference to link
      first = first.next;                       // delete it: first-->old next
      return temp;                              // return deleted link
   }

   // -------------------------------------------------------------
   public void displayList() {
      System.out.print("List (first-->last): ");
      Link current = first;                     // start at beginning of list
      while (current != null) {                 // until end of list,
         current.displayLink();                 // print data
         current = current.next;                // move to next link
      }
      System.out.println();
   }
// -------------------------------------------------------------
}  // end class LinkList

////////////////////////////////////////////////////////////////
class LinkListApp {
   public static void main(String[] args) {
      LinkList linkList = new LinkList();       // make new list

      linkList.insertFirst(22, 2.99);    // insert four items
      linkList.insertFirst(44, 4.99);
      linkList.insertFirst(66, 6.99);
      linkList.insertFirst(88, 8.99);

      linkList.displayList();                   // display list
      linkList.deleteFirst();                   // delete link
      linkList.displayList();                   // display list


      while (!linkList.isEmpty())               // until it's empty,
      {
         Link aLink = linkList.deleteFirst();   // delete link
         System.out.print("Deleted ");          // display it
         aLink.displayLink();
         System.out.println();                  // перенос строки
      }
      linkList.displayList();              // display list
   }  // end main()
}  // end class LinkListApp
////////////////////////////////////////////////////////////////
