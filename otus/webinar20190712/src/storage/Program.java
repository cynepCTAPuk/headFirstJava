package storage;

import java.util.Random;

public class Program {
    public static void main(String[] args) {
        int size = 100_000;
        IBox single = new SingleBox();
        IBox factor = new FactorBox();
        IBox linked = new LinkedBox();
        IBox bitree = new BiTreeBox();

//        testPut(single, size);
        testPut(factor, size);
        testPut(linked, size);
        testPut(bitree, size);

//        testGet(single);
//        testGet(factor);
//        testGet(linked);
//        testGet(bitree);

//        testHas(single);
        testHas(factor);
        testHas(linked);
        testHas(bitree);
    }

    static void testPut(IBox box, int total) {
        long start = System.currentTimeMillis();
        for (int j = 0; j < total; j++) box.put(j + "");
        System.out.println(box + " testPut " + (System.currentTimeMillis() - start));
    }

    static void testGet(IBox box) {
        long start = System.currentTimeMillis();
        for (int j = 0; j < box.size(); j++) box.get(j);
        System.out.println(box + " testGet " + (System.currentTimeMillis() - start));
    }

    static void testHas(IBox box) {
        int size = 100_000;
        long start = System.currentTimeMillis();
        Random random = new Random(size);
        box.has(random + "");
        System.out.println(box + " testHas " + (System.currentTimeMillis() - start));
    }
}
