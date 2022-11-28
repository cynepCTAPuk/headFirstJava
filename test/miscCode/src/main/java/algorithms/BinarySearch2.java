package algorithms;

import java.util.Arrays;

public class BinarySearch2 {
    public static void main(String[] args) {
        double[] array = generateRandomArray(100_000_000);
        Arrays.sort(array); // нужно сначала отсортировать
        /*
        Строго говоря, измерять время выполнения так не совсем корректно,
        лучше использовать benchmarks см. https://habr.com/ru/post/349914/
        Но масштаб будет понятен
        */
        long time = System.currentTimeMillis(); // текущее время, unix-time
        int i = bruteForce(array, 0.5);
        System.out.println("index=" + i + " " + (System.currentTimeMillis() - time));

        long time1 = System.currentTimeMillis();
        int i1 = binarySearchRecursively(array, 0.5);
        System.out.println("index=" + i1 + " " + (System.currentTimeMillis() - time1));
    }

    /*    Просто перебираем, пока не найдет. Если ничего не найдём, вернём -1    */
    public static int bruteForce(double[] array, double key) {
        for (int i = 0; i < array.length; i++) if (array[i] == key) return i;
        return -1;
    }

    /*Двоичный поиск*/
    public static int binarySearchRecursively(double[] sortedArray, double key) {
        return binarySearchRecursively(sortedArray, key, 0, sortedArray.length);
    }

    /**
     * Вспомогательный метод для {@link #binarySearchRecursively(double[], double)}
     * <p>
     * Будем делить отрезок пополам, но не копировать, а просто "сдвигать границы",
     * и вызывать этот же метод рекурсивно. Для этого используем low и high
     *
     * @param sortedArray сортированный массив
     * @param key         искомое значение
     * @param low         от какого значения ищем
     * @param high        до какого значения ищем
     * @return индекс элемента
     */
    private static int binarySearchRecursively(double[] sortedArray, double key, int low, int high) {
        int middle = (low + high) / 2; // середина
        // больше делить нечего
        if (high < low) return -1;
        if (key == sortedArray[middle]) return middle;
        // если нашёлся ищем в левой половине
        if (key < sortedArray[middle]) return binarySearchRecursively(sortedArray, key, low, middle - 1);
        // ищем в правой половине
        return binarySearchRecursively(sortedArray, key, middle + 1, high);
    }
    // Вспомогательный метод для тестов

    private static double[] generateRandomArray(int length) {
        double[] array = new double[length];
        for (int i = 0; i < array.length; i++) array[i] = Math.random();
        return array;
    }
}
