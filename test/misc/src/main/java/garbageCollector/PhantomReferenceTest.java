package garbageCollector;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

public class PhantomReferenceTest {
    public static void main(String[] args) {
        //специальная очередь для призрачных объектов
        ReferenceQueue<Integer> queue = new ReferenceQueue<>();
        //список призрачных ссылок
        ArrayList<PhantomReference<Integer>> list = new ArrayList<>();
        //создаем 10 объектов и добавляем их в список через призрачные ссылки
        for (int i = 0; i < 10; i++) {
            Integer x = i;
            list.add(new PhantomReference<Integer>(x, queue));
        }
//        System.out.println(queue);
//        System.out.println(list);

        //взываем сборщик мусора, надеемся, что он нас послушается :)
        //он должен убить все «призрачно достижимые» объекты и поместить их в очередь призраков
        System.gc();

        //достаем из очереди все объекты
        Reference<? extends Integer> referenceFromQueue;
        while ((referenceFromQueue = queue.poll()) != null) {
            System.out.println(referenceFromQueue.get());           //выводим объект на экран
            referenceFromQueue.clear();                             //очищаем ссылку
        }

//        System.out.println(list);
    }
}
