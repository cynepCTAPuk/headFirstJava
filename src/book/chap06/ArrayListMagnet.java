/*
 * Copyright (c) 2018/7/1 11:41
 * CTAPuk
 */

package book.chap06;

import java.util.ArrayList;

public class ArrayListMagnet {

    static public ArrayList<String> al = new ArrayList<String>();

    static public void printAll(ArrayList<String> a) {
        for (String element : a) System.out.print(element + "\t");
        System.out.println();
    }

    public static void main(String[] args) {
        al.add(0, "zero");
        al.add(1, "one");
        al.add(2, "two");
        al.add(3, "three");
        printAll(al);
        al.remove(2);
        printAll(al);
    }
}
