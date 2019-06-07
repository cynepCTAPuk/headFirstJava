package ru.otus.l081.gson;

import com.google.gson.Gson;

/**
 * Created by tully.
 */
public class Main {
    public static void main(String[] args) {
        BagOfPrimitives obj = new BagOfPrimitives(22, "test", 10);
        System.out.println("1 " + obj);                 // 1
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        System.out.println("2 " + json);                // 2

        BagOfPrimitives obj2 = gson.fromJson(json, BagOfPrimitives.class);
        System.out.println("3 " + obj.equals(obj2));    // 3
        System.out.println("4 " + obj2);                // 4
    }
}
