//: containers/References.java
// Demonstrates Reference objects
package chap17_containers;
import java.lang.ref.*;
import java.util.*;
class VeryBig {
    private static final int SIZE = 10_000;
    private long[] la = new long[SIZE];
    private String ident;
    public VeryBig(String id) { ident = id; }
    public String toString() { return ident; }
    @SuppressWarnings("deprecation")
    protected void finalize() {
        System.out.println("Finalizing " + ident);
    }
}
public class References {
    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<>();
    public static void checkQueue() {
        Reference<? extends VeryBig> inq = rq.poll();
        if(inq != null)
            System.out.println("In queue: " + inq.get());
    }
    public static void main(String[] args) {
        int size = 10;
        // Or, choose size via the command line:
        if(args.length > 0) size = Integer.valueOf(args[0]);

        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<>();
        for(int i = 0; i < size; i++) {
            sa.add(new SoftReference<VeryBig>( new VeryBig("Soft " + i), rq));
            System.out.println("Just created sa: " + sa.getLast());
            checkQueue();
        }
        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<>();
        for(int i = 0; i < size; i++) {
            wa.add(new WeakReference<VeryBig>( new VeryBig("Weak " + i), rq));
            System.out.println("Just created wa: " + wa.getLast());
            checkQueue();
        }
        SoftReference<VeryBig> s = new SoftReference<>(new VeryBig("Soft"));
        WeakReference<VeryBig> w = new WeakReference<>(new VeryBig("Weak"));
        System.gc();
        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<>();
        for(int i = 0; i < size; i++) {
            pa.add(new PhantomReference<VeryBig>( new VeryBig("Phantom " + i), rq));
            System.out.println("Just created pa: " + pa.getLast());
            checkQueue();
        }
    }
} /* (Execute to see output) *///:~