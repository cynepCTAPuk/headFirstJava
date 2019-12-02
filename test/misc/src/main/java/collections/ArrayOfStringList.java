package collections;

import java.util.ArrayList;

public class ArrayOfStringList {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("first");
        list1.add("second");
        System.out.println(list1);
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("первый");
        list2.add("второй");
        System.out.println(list2);

        ArrayList<String>[] arrayOfStringList = new ArrayList[2];
        arrayOfStringList[0] = list1;
        arrayOfStringList[1] = list2;

        return arrayOfStringList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList)
            for (String s : list) System.out.println(s);
    }
}
