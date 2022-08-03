package collections;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("0");
        stringList.add("1");
        stringList.add("2");
        int size = stringList.size();
        System.out.println(stringList + " size:" + size);

//access via index
        String e0 = stringList.get(0);
        String e1 = stringList.get(1);
        String e2 = stringList.get(2);
        System.out.println(e0 + " " + e1 + " " + e2 + "  access via index");

//print all elements
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println(" iterator.hasNext()");

//foreach-loop
        for (String s : stringList) System.out.print(s + " ");
        System.out.println(" foreach-loop");

//classic for loop
        for (int i = 0; i < stringList.size(); i++) System.out.print(stringList.get(i) + " ");
        System.out.println(" classic for loop");

        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.addAll(Arrays.asList(100, 300, 200, 400));
        System.out.println(integerList);
//sorting
        Collections.sort(integerList);//ascending order
        System.out.println(integerList + " ascending order");
        Collections.sort(integerList, Comparator.reverseOrder());
        System.out.println(integerList + " descending order");

//filtering and remove all numbers more than 200
        integerList.removeIf(i -> i > 200);
        System.out.println(integerList + " remove elements by list.removeIf(i -> i > 200)");
        integerList = new ArrayList<>(Arrays.asList(100, 300, 200, 400));
        List<Integer> list = integerList.stream().filter(i -> i > 200).collect(Collectors.toList());
        System.out.println(list + " remove elements by list.stream().filter(i -> i > 200).collect(Collectors.toList())");

        List<Integer> newList = new ArrayList<>();
        newList.add(1);
        newList.add(2);
        newList.add(3);
        System.out.println(newList);
// ConcurrentModificationException
//        for(Integer integer: list) list.remove(1);
        Iterator<Integer> listIterator = newList.iterator();
        while (listIterator.hasNext()) if (listIterator.next() == 1) listIterator.remove();
        System.out.println(newList);
    }
}
