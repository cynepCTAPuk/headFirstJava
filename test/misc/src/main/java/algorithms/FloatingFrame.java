package algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Stepik Algorithm2: 116
 * Вход: последовательность чисел a<sub>1</sub>, a<sub>2</sub>, ..., a<sub>n</sub> , число m.
 * Выход: пройтись по последовательности окном размера m и вывести минимум в каждом из них
 */
public class FloatingFrame {
    public static void main(String[] args) {
        int[] array = {5, 1, 3, 2, 4, 6, 1, 7, 3, 2, 8};
        int m = 3;
        min(array, m);
    }

    private static int[] min(int[] array, int m) {
        int[] result = new int[array.length - m + 1];
        Deque<Character> stack = new ArrayDeque<>();


        return result;
    }
}
