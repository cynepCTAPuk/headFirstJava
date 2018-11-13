/*
 * Copyright (c) 2018/7/9 0:8
 * CTAPuk
 */

package chap06;

public class MathTest {
    public static void main(String[] args) {
//        for (int i = 0; i <10 ; i++) {
//            double r1 = Math.random();
//            System.out.print(r1 + "\t");
//        }
//        System.out.println();
//        for (int i = 0; i <10 ; i++) {
//            int r2 = (int) (Math.random() * 1000000);
//            System.out.print(r2+"\t");
//        }

//        int x = Math.abs(-240);
//        double d = Math.abs(240.45);
//        System.out.println(x + "\t" + d);

//        int x = Math.round(-24.8f);
//        int y = Math.round(24.45f);
//        System.out.println(x+"\t" +y);

//        int x = Math.min(24, 240);
//        double y = Math.min(90876.5, 90876.49);
//        System.out.println(x + "\t" + y);

//        int x = Math.max(24, 240);
//        double y = Math.max(90876.5, 90876.49);
//        System.out.println(x + "\t" + y);

//        int a = 32;
//        String s = "abc";
//        ArrayList list = new ArrayList();
//        list.add(a);
//        list.add(s);
//        list.add(5);
//        list.add("cba");
//        System.out.println(list);
//        int b = (int) list.get(0);
//        int c = (int) list.get(2);
//        System.out.println((int) list.get(0));
//        Integer i = new Integer(42);
//        Integer k = i+3;
//        i++;
//        System.out.println(++i);

        Integer i = 8;
        int l = 8;
        System.out.println(i);
        int k = Integer.reverse(l);
        System.out.println(k);
        System.out.println(Integer.sum(l, k));
        String str = "FF";
        System.out.println(str+"\t=\t"+Integer.parseInt(str,16));
    }
}