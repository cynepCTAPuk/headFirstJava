package collections.task3603;

import java.util.Arrays;
import java.util.List;

/* 
Поиск класса по описанию
*/
public class Solution {
    public static void main(String... args) {    //it's correct line
        java.util.concurrent.CopyOnWriteArrayList<String> list = new java.util.concurrent.CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.remove("B");
        List<String> collection = Arrays.asList(new String[]{"B", "C", "D", "B"});

        list.addAllAbsent(collection);

        for (String string : list) System.out.println(string);
    }

    private static class CopyOnWriteArrayList<T> {
        public void add(T a) {

        }

        public void remove(T b) {

        }

        public void addAllAbsent(List<T> collection) {

        }
    }
}