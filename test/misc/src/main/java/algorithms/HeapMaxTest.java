package algorithms;

import util.Util;

public class HeapMaxTest {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 2, 4, 6, 8};
        Util.printArray(array, "original");

//        int[] sortedArray = heapSort1(array);
//        Util.printArray(sortedArray);

//        buildHeap(array);

        heapSort2(array);
        Util.printArray(array,"heapSort");
    }

    private static int[] heapSort1(int[] array) {
        int size = array.length;
        int[] result = new int[size];
        HeapMax heapMax = new HeapMax(size);
        for (int i = 0; i < size; i++) heapMax.insert(array[i]);
//        for (int i = 0; i < size; i++) result[i] = heapMax.extractMax();        // по убыванию
        for (int i = size - 1; i >= 0; i--) result[i] = heapMax.extractMax(); // по возрастанию
        return result;
    }

    private static void heapSort2(int[] array) {
        buildHeap(array);
//        Util.printArray(array, "buildHeap");
        for (int i = array.length - 1; i > 0; i--) {
            swap(0, i, array);
//            Util.printArray(array, i + " --- swap");
            siftDown(0, array, i);
//            Util.printArray(array, "siftDown");
        }
    }

    private static void buildHeap(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            siftDown(i, array, array.length);
        }
    }

    private static void siftDown(int i, int[] array, int size) {
        int maxIndex = i;
        int l = 2 * i + 1;
        if (l < size && array[l] > array[maxIndex]) maxIndex = l;
        int r = 2 * i + 2;
        if (r < size && array[r] > array[maxIndex]) maxIndex = r;
        if (i != maxIndex) {
            swap(i, maxIndex, array);
            siftDown(maxIndex, array, size);
        }
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
