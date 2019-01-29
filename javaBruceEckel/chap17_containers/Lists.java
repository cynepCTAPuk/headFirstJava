//: containers/Lists.java
// Things you can do with Lists.
package chap17_containers;
import java.util.*;
import util.*;
import static util.Print.*;
public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;
    public static void basicTest(List<String> list) {
        list.add(1, "x"); // Add at location 1
        list.add("x"); // Add at end
//        System.out.println(list);
        // Add list collection:
        list.addAll(Countries.names(9));
//        System.out.println(list);
        // Add list collection starting at location 3:
        list.addAll(3, Countries.names(9));
//        System.out.println(list);
        b = list.contains("1"); // Is it in there?
        // Is the entire collection in there?
        b = list.containsAll(Countries.names(9));
        // Lists allow random access, which is cheap for ArrayList, expensive for LinkedList:
        s = list.get(1); // Get (typed) object at location 1
        i = list.indexOf("1"); // Tell index of object
        b = list.isEmpty(); // Any elements inside?
        it = list.iterator(); // Ordinary Iterator
        lit = list.listIterator(); // ListIterator
        lit = list.listIterator(3); // Start at loc 3
        i = list.lastIndexOf("1"); // Last match
        list.remove(1); // Remove location 1
        list.remove("3"); // Remove this object
        list.set(1, "y"); // Set location 1 to "y"
        // Keep everything that’s in the argument (the intersection of the two sets):
        list.retainAll(Countries.names(9));
        // Remove everything that’s in the argument:
        list.removeAll(Countries.names(9));
        i = list.size(); // How big is it?
        list.clear(); // Remove all elements
    }
    public static void iterMotion(List<String> list) {
        ListIterator<String> it = list.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();
        s = it.next();
        i = it.nextIndex();
        s = it.previous();
        i = it.previousIndex();
    }
    public static void iterManipulation(List<String> list) {
        ListIterator<String> it = list.listIterator();
        it.add("47");
        // Must move to an element after add():
        it.next();
        // Remove the element after the newly produced one:
        it.remove();
        // Must move to an element after remove():
        it.next();
        // Change the element after the deleted one:
        it.set("47");
    }
    public static void testVisual(List<String> list) {
        System.out.println("-----testVisual-----");
        print("a0 - " + list);
        List<String> b = Countries.names(5);
        print("b0 = " + b);
        list.addAll(b);
        print("a1 - " + list);
        list.addAll(b);
        print("a2 - " + list);
        // Insert, remove, and replace elements using list ListIterator:
        ListIterator<String> it = list.listIterator(list.size()/2);
        it.add("one");
        System.out.println(list.indexOf("one"));
        print("a3 - " + list);
        print( "list.size()/2 - " + list.size()/2 + " index " + list.get(list.size() / 2));
        print("x1 - " + it.next());
        it.remove();
        print("a4 - " + list);
        print("x2 - " + it.next());
        it.set("47");
        print("a5 - " + list);
        // Traverse the list backwards:
        it = list.listIterator(list.size());
        int i = 0;
        while(it.hasPrevious()) printnb(++i + ": " + it.previous() + " ");
        print();
        print("-----testVisual finished\n");
    }
    // There are some things that only LinkedLists can do:
    public static void testLinkedList() {
        System.out.println("-----testLinkedList-----");
        LinkedList<String> list = new LinkedList<>();
        print("0 - " + list);
        list.addAll(Countries.names(7));
        print("1 - " + list);
        // Treat it like a stack, pushing:
        list.addFirst("one");
        list.addFirst("two");
        print("2 - " + list);
        // Like "peeking" at the top of a stack:
        print(list.getFirst());
        // Like popping a stack:
        print(list.removeFirst());
        print(list.removeFirst());
        // Treat it like a queue, pulling elements off the tail end:
        print(list.removeLast());
        print("3 - " + list);
        print("-----testLinkedList finished\n");
    }
    public static void main(String[] args) {
        // Make and fill a new list each time:
        basicTest( new LinkedList<String>(Countries.names(8)));
        basicTest( new ArrayList<String>(Countries.names(8)));

        iterMotion( new LinkedList<String>(Countries.names(8)));
        iterMotion( new ArrayList<String>(Countries.names(8)));

        iterManipulation( new LinkedList<String>(Countries.names(8)));
        iterManipulation( new ArrayList<String>(Countries.names(8)));

        testVisual( new LinkedList<String>(Countries.names(8)));
        testLinkedList();
    }
} /* (Execute to see output) *///:~