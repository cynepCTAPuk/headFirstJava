package ru.otus.jmm;

public class Factory {
    static class Item {
        int i;
        String s;

        public Item(int i, String s) {
            this.i = i;
            this.s = s;
        }
    }

    static volatile Item instance;

    public static Item get(int i, String s) {
        if (instance == null) {
            synchronized (Factory.class) {
                if (instance == null) {
                    instance = new Item(i, s);
                }
            }
        }
        return instance;
    }
}
