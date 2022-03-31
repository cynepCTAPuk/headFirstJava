package garbageCollector;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        //создание объекта Cat
        Cat catty = new Cat("Catty");

        //создание слабой ссылки на объект Cat
        WeakReference<Cat> catRef = new WeakReference<>(catty);
        System.out.println("catRef1=" + catRef.get());

        //теперь на объект ссылается только слабая ссылка catRef.
        catty = null;
        System.out.println("catRef2=" + catRef.get());

        System.gc();
//        Thread.sleep(3_000);

        //теперь на объект ссылается еще и обычная переменная catty
        catty = catRef.get();
        System.out.println("catRef3=" + (catty == null ? "null" : catty));

        //очищаем слабую ссылку
        catRef.clear();
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
