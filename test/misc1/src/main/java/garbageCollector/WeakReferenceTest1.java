package garbageCollector;

import java.lang.ref.WeakReference;

public class WeakReferenceTest1 {
    public static void main(String[] args) throws InterruptedException {
        // Create catty reference points to Cat("Obj1").
        Cat catty = new Cat("Catty");
        // Create WeakReference object using catty reference.
        WeakReference<Cat> weakRef = new WeakReference<>(catty);

        System.out.println("weakRef.get(): " + weakRef.get());

        int i = 0;
        while (true) {
            Cat weakCat = weakRef.get();
            if (weakCat == null) {
                System.out.println("Inner object is removed by Garbage Collector");
                System.out.println(++i + " weakRef.get(): " + weakCat);
                break;
            }
            System.out.println(++i + " weakRef.get(): " + weakCat);
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
