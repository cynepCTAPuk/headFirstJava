//: exceptions/CleanupIdiom.java
// Each disposable object must be followed by a try-finally
package chap12;
class NeedsCleanup { // Construction can’t fail
    private static long counter = 1;
    private final long id = counter++;
    public void dispose() { System.out.println("NeedsCleanup " + id + " disposed"); }
}
class ConstructionException extends Exception {}
class NeedsCleanup2 extends NeedsCleanup { // Construction can fail:
    public NeedsCleanup2() throws ConstructionException {}
}
public class CleanupIdiom {
    public static void main(String[] args) {
        NeedsCleanup nc1 = new NeedsCleanup();
        NeedsCleanup nc2 = new NeedsCleanup();
        NeedsCleanup nc3 = new NeedsCleanup();

// Section 1:
        try { // ...
        } finally { nc1.dispose(); }

// Section 2: If construction cannot fail you can group objects:
        try { // ...
        } finally {
            nc3.dispose(); // Reverse order of construction
            nc2.dispose();
        }

// Section 3: If construction can fail you must guard each one:
        try { NeedsCleanup2 nc4 = new NeedsCleanup2();
            try { NeedsCleanup2 nc5 = new NeedsCleanup2();
                try { // ...
                } finally { nc5.dispose(); }
            } catch(ConstructionException e) { System.out.println(e); // nc5 constructor
            } finally { nc4.dispose(); }
        } catch(ConstructionException e) { System.out.println(e); // nc4 constructor
        }
    }
} /* Output:
NeedsCleanup 1 disposed
NeedsCleanup 3 disposed
NeedsCleanup 2 disposed
NeedsCleanup 5 disposed
NeedsCleanup 4 disposed
*///:~