package chap11;

import java.util.*;

class MyObject {
    String str;
    MyObject(String i) { this.str = i; }
//    @Override public String toString() { return "MyObject{" + "str=" + str + '}'; }
    @Override public String toString() { return str; }
}

public class Exercise7 {
    public static void main(String[] args) {
        MyObject[] myObjects = new MyObject[10];
        for (int i = 0; i < myObjects.length; i++)
            myObjects[i] = new MyObject("" + (char)(i + 65));
        System.out.println(Arrays.toString(myObjects));

        ArrayList<MyObject> list = new ArrayList<>(Arrays.asList(myObjects));
        System.out.println(list);

        List<MyObject> sub = list.subList(1,3);
        System.out.println(sub);
        list.removeAll(sub);
        System.out.println(list);

    }

}

