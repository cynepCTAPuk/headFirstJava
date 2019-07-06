package ru.otus.jmm;

public class Factory {
    static class Item {
        int i = 1;
        String s = "string";
    }

    static Item instance;

    public static Item get() {
        if (instance == null) {
            instance = new Item();
        }
        return instance;
    }
}
