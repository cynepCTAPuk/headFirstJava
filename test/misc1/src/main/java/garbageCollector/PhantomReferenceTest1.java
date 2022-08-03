package garbageCollector;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

public class PhantomReferenceTest1 {
    public static void main(String[] args) {
        //специальная очередь для призрачных объектов
        ReferenceQueue<Integer> queue = new ReferenceQueue<Integer>();
        //список призрачных ссылок
        List<PhantomInteger> list = new ArrayList<>();
        //создаем 10 объектов и добавляем их в список через призрачные ссылки
        for (int i = 0; i < 10; i++) {
            Integer x = i;
            list.add(new PhantomInteger(x, queue));
        }

        Thread referenceThread = new Thread() {
            public void run() {
                while (true) try {
                    //получаем новый объект из очереди, если объекта нет - ждем!
                    PhantomInteger ref = (PhantomInteger) queue.remove();
                    //вызвваем у него метод close
                    ref.close();
                    ref.clear();
                } catch (Exception ex) {
                    // пишем в лог ошибки
                }
            }
        };
        //запускаем поток в служебном режиме.
        referenceThread.setDaemon(true);
        referenceThread.start();
    }

    static class PhantomInteger extends PhantomReference<Integer> {

        /**
         * Creates a new phantom reference that refers to the given object and
         * is registered with the given queue.
         *
         * <p> It is possible to create a phantom reference with a {@code null}
         * queue, but such a reference is completely useless: Its {@code get}
         * method will always return {@code null} and, since it does not have a queue,
         * it will never be enqueued.
         *
         * @param referent the object the new phantom reference will refer to
         * @param q        the queue with which the reference is to be registered,
         *                 or {@code null} if registration is not required
         */
        public PhantomInteger(Integer referent, ReferenceQueue<? super Integer> q) {
            super(referent, q);
        }

        private void close() {
            System.out.println("Bad Integer totally destroyed");
        }
    }
}
