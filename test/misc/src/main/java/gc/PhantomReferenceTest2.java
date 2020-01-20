package gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10_000);
        ReferenceQueue<TestClass> queue = new ReferenceQueue<>();
        Reference ref = new MyPhantomReference<>(new TestClass(), queue);

        System.out.println("ref = " + ref);

        Thread.sleep(5_000);
        System.out.println("Вызывается сборка мусора!");

        System.gc();
        Thread.sleep(300);
        System.out.println("ref = " + ref);

        Thread.sleep(5_000);
        System.out.println("Вызывается сборка мусора!");

        System.gc();
    }
}

class TestClass {
    private StringBuffer data;

    public TestClass() {
        this.data = new StringBuffer();
        for (long i = 0; i < 50_000_000; i++) this.data.append('x');
    }

    @Override
    protected void finalize() {
        System.out.println("У объекта TestClass вызван метод finalize!!!");
    }
}

class MyPhantomReference<TestClass> extends PhantomReference<TestClass> {
    public MyPhantomReference(TestClass obj, ReferenceQueue<TestClass> queue) {
        super(obj, queue);
        Thread thread = new QueueReadingThread<TestClass>(queue);
        thread.start();
    }

    public void cleanup() {
        System.out.println("Очистка фантомной ссылки! Удаление объекта из памяти!");
        clear();
    }
}

class QueueReadingThread<TestClass> extends Thread {
    private ReferenceQueue<TestClass> referenceQueue;

    public QueueReadingThread(ReferenceQueue<TestClass> referenceQueue) {
        this.referenceQueue = referenceQueue;
    }

    @Override
    public void run() {
        System.out.println("Поток, отслеживающий очередь, стартовал!");
        Reference ref = null;
        //ждем, пока в очереди появятся ссылки
        while ((ref = referenceQueue.poll()) == null) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException("Поток " + getName() + " был прерван!");
            }
        }
        //как только в очереди появилась фантомная ссылка - очистить ее
        ((MyPhantomReference) ref).cleanup();
    }
}