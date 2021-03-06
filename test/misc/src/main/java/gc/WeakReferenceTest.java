package gc;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class WeakReferenceTest {
    public static void main(String[] args) {
        //создание объекта Cat
        Cat cat = new Cat();
        //создание слабой ссылки на объект Cat
        WeakReference<Cat> catRef = new WeakReference<Cat>(cat);
        //теперь на объект ссылается только слабая ссылка catRef.
        cat = null;
        //теперь на объект ссылается еще и обычная переменная cat
        cat = catRef.get();
        //очищаем слабую ссылку
        catRef.clear();
    }

    static class Cat {
    }

}
