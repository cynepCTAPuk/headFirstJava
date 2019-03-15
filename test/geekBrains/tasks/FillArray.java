package tasks;

public class FillArray {
    public static void random(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
    }

    public static void symbol(char[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) (i + 33); //begin from 33
            if (i > 93) array[i] = (char) (i + 67);
        }
    }

    public static void main(String[] args) {
        System.out.println((int)'A');
        System.out.println((int)'a');
        for (int i = 65; i < 128 ; i++) {
            System.out.print((char)i + " ");
        }
    }
}
