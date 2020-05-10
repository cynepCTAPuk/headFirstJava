package algorithms.stepik2;

import util.Util;
/**
 * Stepik Algorithm2: Построение кучи<p>
 * Переставить элементы заданного массива чисел так, чтобы он удовлетворял свойству мин-кучи.<p>
 * Вход: Первая строка содержит число n. Следующая строка - массив чисел A[0 ... n-1].<p>
 * Выход: Переставить элементы массива так, чтобы выполнялись неравенства A[i] <= A[2i + 1]<p>
 * и A[i] <= A[2i + 2] для всех i. Первая строка выхода должна содержать число обменов m, которое
 * должно удовлетворять неравенству 0 <= m <= 4n.Каждая из последующих m строк должна задавать обмен
 * двух элементов массива A. Каждый обмен задаётся парой различных индексов 0 <= i != j <= n-1.<p>
 * Ограничения: 1 <= n <= 10<sup>5</sup>; 0 <= A[i] <= 10<sup>9</sup> для всех 0 <= i <= n-1;
 * все A[i] попарно различны; i != j.
 */

public class Test231 {
    private static int count = 0;
    private static StringBuilder change = new StringBuilder();

    public static void main(String[] args) {
//        int[] array = {1, 3, 5, 7, 9, 2, 4, 6, 8};
        int[] array = {7, 6, 5, 4, 3, 2};
//        int[] array = {5, 4, 3, 2, 1};
        Util.printArray(array, "original");

        buildHeap(array);
        System.out.println(count);
        System.out.print(change);
        Util.printArray(array, "buildHeap");
    }

    private static void buildHeap(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            siftDown(i, array, array.length);
        }
    }

    private static void siftDown(int e, int[] array, int size) {
        int minIndex = e;
        int left = 2 * e + 1;
        int right = 2 * e + 2;

        if (left < size && array[left] < array[minIndex]) minIndex = left;
        if (right < size && array[right] < array[minIndex]) minIndex = right;

        if (e != minIndex) {
            swap(e, minIndex, array);
            siftDown(minIndex, array, size);
        }
    }

    private static void swap(int i, int j, int[] array) {
        change.append(i).append(' ').append(j).append('\n');
        count++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
