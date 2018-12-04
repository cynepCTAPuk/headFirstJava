package lafore.chap06.projects;
/**
 * Роберт Лафоре
 * проект 6.1
 */

import static lafore.chap06.projects.PowerApp.*;

public class BinaryTreeBuildApp {
    static int i = 0;
    static int left = 2, right = 4;
    static int size = (int) power(left, right);
    static char[][] chars = new char[right][size];


    public static void main(String[] args) {
        System.out.println("left = " + left + " right = " + right + " size = " + size);
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; i < chars[i].length; j++) {
                chars[i][j] = '-';
            }
        }
//        drawTree(size);
//        Display();
        System.out.println(chars.length);
    }

    public static void drawTree(int size) {
        recTree(0, size - 1);
    }

    public static int recTree(int left, int right) {

/*
        int middle = (left + right + 1) >>> 1;

        if (middle == 1) {
            for (int i = 0; i < chars.length; i++) chars[i] = '-';
            chars[size / 2] = 'X';
            for (int i = 0; i < chars.length; i++) System.out.print(chars[i]);
            System.out.println(" middle = " + middle);
            return middle;
        } else {
            for (int i = 0; i < chars.length; i++) chars[i] = '-';
            middle = recTree(left, middle) + 1;
            chars[middle] = 'X';
            for (int i = 0; i < chars.length; i++) System.out.print(chars[i]);
            System.out.println(" middle = " + middle);
            return middle;
        }
*/
        return -1;
    }

    public static void Display() {
        for (int i = 0; i < right - 1; i++) {
            System.out.print("[");
            for (int j = 0; i < size - 1; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println("]");
        }
    }
}
