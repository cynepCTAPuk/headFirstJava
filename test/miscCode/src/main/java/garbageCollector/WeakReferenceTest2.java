package garbageCollector;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakReferenceTest2 {
    public static void main(String[] args) throws InterruptedException {
        Cat catty1 = new Cat("Catty1");
        Cat catty2 = new Cat("Catty2");

        ReferenceQueue<Cat> queue = new ReferenceQueue<Cat>();
        WeakReference<Cat> weakRef1 = new WeakReference<Cat>(catty1, queue);
        WeakReference<Cat> weakRef2 = new WeakReference<Cat>(catty2, queue);
        System.out.println("weakRef1: " + weakRef1);
        System.out.println("weakRef2: " + weakRef2);
        System.out.println("weakRef1.get(): " + weakRef1.get());
        System.out.println("weakRef2.get(): " + weakRef2.get());

        // Set catty1 reference to null (Points to null).
        catty1 = null;

        System.out.println("\nCall System.gc().\n");
        System.gc();
//        Thread.sleep(3000);

        // catty2 is still used.
        System.out.println("catty2: " + catty2);
        System.out.println("weakRef1.get(): " + weakRef1.get());
        System.out.println("weakRef2.get(): " + weakRef2.get());

        Reference<? extends Cat> removed = null;
        while ((removed = queue.poll()) != null) {
            System.out.println("removed: " + removed);
        }
    }

    private static class Cat {
        private String value;

        public Cat(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return '{' + value + '}';
        }
    }
}
