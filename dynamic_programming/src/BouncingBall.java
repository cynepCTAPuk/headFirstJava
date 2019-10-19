/**
 * На вершине лесенки, содержащей N ступенек, находится мячик,
 * который начинает прыгать по ним вниз, к основанию.
 * Мячик может прыгнуть на следующую ступеньку, на ступеньку через одну или через 2.
 * (То есть, если мячик лежит на 8-ой ступеньке, то он может переместиться на 5-ую, 6-ую или 7-ую.)
 * Определить число всевозможных «маршрутов» мячика с вершины на землю.
 */
public class BouncingBall {
    public static void main(String[] args) {
        int n = 36;
        long t0;

        t0 = System.nanoTime();
        System.out.println(f(n));
        System.out.printf("%,15d\n",System.nanoTime()-t0);

        t0 = System.nanoTime();
        System.out.println(f1(n));
        System.out.printf("%,15d\n",System.nanoTime()-t0);
    }

    public static int f(int n) { // Реализация через рекурсию
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        return f(n - 1) + f(n - 2) + f(n - 3);
    }

    public static int f1(int n) { // Реализация через массив значений
        int[] array = new int[3];
        array[0] = 1;
        array[1] = 2;
        array[2] = 4;

        for (int i = 3; i < n; i++)
            array[i % 3] = array[0] + array[1] + array[2];
        return array[(n - 1) % 3];
    }
}
