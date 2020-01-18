package oop;

import java.lang.ref.SoftReference;

public class SoftRefernceTest {
    public static void main(String[] args) {
        //создание объекта Cat
        Cat cat = new Cat();
        //создание мягкой ссылки на объект Cat
        SoftReference<Cat> catRef = new SoftReference<>(cat);
        //теперь на объект ссылается только мягкая ссылка catRef.
        cat = null;
        //теперь на объект ссылается еще и обычная переменная cat
        cat = catRef.get();
        //очищаем мягкую ссылку
        catRef.clear();
    }

    static class Cat {
    }

}
