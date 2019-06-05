package ru.otus.l71.structural.facade;

import java.util.ArrayList;
import java.util.List;

public class CollectionFacadeTest {
    public static void main(String[] args) {
        CollectionsFacadeImpl collectionsFacade = new CollectionsFacadeImpl();
        List<String> list = new ArrayList<>();
        list.add("d");
        list.add("a");
        list.add("c");
        list.add("b");
        System.out.println(collectionsFacade.getPermutations(list));
        System.out.println(list);
        collectionsFacade.sort(list);
        System.out.println(list);


    }
}
