package collections;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> listA = new ArrayList<>();
        listA.add("element 0");
        listA.add("element 1");
        listA.add("element 2");
        int size = listA.size();
        System.out.println(listA + " size:" + size);

//access via index
        String element0 = listA.get(0);
        String element1 = listA.get(1);
        String element2 = listA.get(2);
        System.out.println(element0 + " " + element1 + " " + element2 + "  access via index");

//print all elements
        Iterator<String> iterator = listA.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println(" iterator.hasNext()");

//foreach-loop
        for (String s : listA) System.out.print(s + " ");
        System.out.println(" foreach-loop");

//classic for loop
        for (int i = 0; i < listA.size(); i++) System.out.print(listA.get(i) + " ");
        System.out.println(" classic for loop");

        ArrayList<Integer> listB = new ArrayList<>();
        listB.addAll(Arrays.asList(100, 200, 300));
        System.out.println(listB);
//sorting
        Collections.sort(listB, (o1, o2) -> o2.compareTo(o1));//descending order
        System.out.println(listB + " descending order");
        Collections.sort(listB);//ascending order
        System.out.println(listB + " ascending order");

//filtering and remove all numbers more than 200
        listB.removeIf(i -> i > 200);
        System.out.println(listB + " removeIf(i -> i > 200)");
        listB = new ArrayList<>(Arrays.asList(100, 200, 300, 400));
        List<Integer> listC = listB.stream().filter(i -> i > 200).collect(Collectors.toList());
        System.out.println(listC + " stream().filter(i -> i > 200)");
    }
}
