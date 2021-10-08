package aaa;

import java.util.*;

public class Q210902_2 {

    public static void main(String... args) {
        String[] str = new String[]{"1", "2", "3"};
        List list = Arrays.asList(str);
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            Object obj = (Object) iterator.next();
//            System.out.println(obj);
            iterator.remove();
        }
        System.out.println(list.size());
    }
}


