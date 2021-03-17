package aaa;

public class ForTest {
    public static void main(String[] args) {
/*
        int start = 3, target = 5, end = 8;

        int[] array = new int[target];
        for (int i = 0; i < array.length; i++) array[i] = i;
        for (int j : array) System.out.println(j);

        System.out.println("----- break");
        for (int i = start; i < end; i = i + 1) {
            if (i == target) break;
            System.out.println("i=" + i);
        }

        System.out.println("----- continue");
        for (int i = start; i < end; i = i + 1) {
            if (i == target) continue;
            System.out.println("i=" + i);
        }
*/
        boolean a = Math.random() > 0.5;
        boolean b = true;
        boolean c = true;
        if ((a && b) || c) {
            System.out.println(true);
        }
    }
}
