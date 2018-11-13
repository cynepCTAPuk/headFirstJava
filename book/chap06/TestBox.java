/*
 * Copyright (c) 2018/7/9 0:50
 * CTAPuk
 */

package chap06;

public class TestBox {
    Integer i;
    int j;

    public static void main(String[] args) {
        TestBox t = new TestBox();
        t.go();
    }

    public void go() {
//        j = (int) i;
        i=j;
        System.out.println(i);
        System.out.println(j);
    }
}
