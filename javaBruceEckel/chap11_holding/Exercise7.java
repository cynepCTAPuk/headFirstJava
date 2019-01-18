package chap11_holding;
import java.util.*;
import static util.Print.*;

class MyObject {
    private String string;
    MyObject(String i) { this.string = i; }
//    @Override public String toString() { return "MyObject{" + "string=" + string + '}'; }
    @Override public String toString() { return string; }
}

public class Exercise7 {
    public static void main(String[] args) {
        MyObject[] myObjects = new MyObject[10];
        for (int i = 0; i < myObjects.length; i++)
            myObjects[i] = new MyObject("" + (char)(i + 65));
        print(Arrays.toString(myObjects));

        ArrayList<MyObject> list = new ArrayList<>(Arrays.asList(myObjects));
        List<MyObject> sub = list.subList(1,3);
        list.removeAll(sub);
        print(list);

        Iterator<MyObject> listItr = list.iterator();
        while(listItr.hasNext()) printnb(listItr.next() + " ");
    }

}

