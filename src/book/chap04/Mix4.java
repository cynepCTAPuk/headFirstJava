/*
 * Copyright (c) 2018/7/1 11:39
 * CTAPuk
 */

package book.chap04;/*
 * chap4.Copyright (c) 2018/6/27 8:28
 * CTAPuk
 */

import java.util.Arrays;

public class Mix4 {
    int counter = 0;

    public static void main(String[] args) {
        int count = 0;
        Mix4[] m4a = new Mix4[20];
        int x = 0;
        while (x < 19) {
            m4a[x] = new Mix4();
            System.out.println("1 "+count + " " + m4a[x].counter);
            m4a[x].counter = m4a[x].counter + 1;
            System.out.println("2 "+count + " " + m4a[x].counter);
            count = count + 1;
            System.out.println("3 "+count + " " + m4a[x].counter);
            count = count + m4a[x].maybeNew(x);
            System.out.println("4 "+count + " " + m4a[x].counter);
            x = x + 1;
            System.out.println("-----");
        }
        System.out.println(count + " " + m4a[1].counter);
        System.out.println(Arrays.toString(m4a));
    }

    public int maybeNew(int index) {
        if (index < 1) {
            Mix4 m4 = new Mix4();
            m4.counter = m4.counter + 1;
            return 1;
        }
        return 0;
    }
}
