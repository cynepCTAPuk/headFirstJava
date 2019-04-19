package ru.otus.l22;

public class Unicode {
    public static void main(String[] args) {
        int i = 0x1F0B1;
        String s = new String(new int[]{i}, 0, 1);
        System.out.println("s = " + s);

        int j = (char)0x1F0B1;
        s = new String(new int[]{j}, 0, 1);
        System.out.println("s = " + s);
    }
}
