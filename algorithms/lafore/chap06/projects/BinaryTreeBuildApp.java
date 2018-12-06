package lafore.chap06.projects;
/**
 * Роберт Лафоре
 * проект 6.1
 */

import static lafore.chap06.projects.PowerApp.*;

public class BinaryTreeBuildApp {
    static int index = 0;
    static int left = 2, right = 4;
    static int size = (int) power(left, right);
    static String[][] strings = new String[right][size];


    public static void main(String[] args) {
        System.out.println("index = " + index + " left = " + left + " right = " + right + " size = " + size);
        fillArray();
        drawTree();
        display();
    }

    public static void drawTree() {
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                if ((size % (j / 4 + 1) == 0)) strings[i][j] = "X";
            }
        }
    }

    public static int recTree(int left, int right) {
        return (left + right) >>> 1;
//        strings[index++][middle] = "X";
    }


    public static void fillArray() {
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) strings[i][j] = "-";
        }
    }

    public static void display() {
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) System.out.print(strings[i][j]);
            System.out.println();
        }
    }
}
