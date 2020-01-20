package gc;

import java.lang.ref.*;

public class PhantomReferenceTest3 {
    public static void main(String[] args) {
        Sedan sedan = new Sedan();
        HybridAuto hybrid = new HybridAuto();
        F1Car f1car = new F1Car();

        SoftReference<Sedan> softReference = new SoftReference<>(sedan);
        System.out.println(softReference.get());

        WeakReference<HybridAuto> weakReference = new WeakReference<>(hybrid);
        System.out.println(weakReference.get());

        ReferenceQueue<F1Car> referenceQueue = new ReferenceQueue<>();

        PhantomReference<F1Car> phantomReference = new PhantomReference<>(f1car, referenceQueue);
        System.out.println(phantomReference.get());
    }

    private static class Sedan {
    }

    private static class HybridAuto {
    }

    private static class F1Car {
    }
}


