/*
 * Copyright (c) 2018/7/1 11:39
 * CTAPuk
 */

package book.chap04;

public class calculateArea {
    public static void main(String[] args) {
        int a = calcArea(7, 12);
        short c = 7;
        calcArea(c, 15);
//        int d = calcArea(57);
        calcArea(2, 3);
        long t = 42;
//        int f = calcArea(t, 17);
//        int g=calcArea();
//        calcArea();
//        byte h=calcArea(4,20);
//        int j = calcArea(2,3,5);
    }

    static int calcArea(int height, int width) {
        return height * width;
    }
}
