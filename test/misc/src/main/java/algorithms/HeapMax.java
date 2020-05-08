package algorithms;

/**
 * Parent(i) return i/2
 * LeftChild(i) return 2i;
 * RightChild(i) return 2i+1;
 */
public class HeapMax {
    private static final int startSize = 10;
    private int[] heap;
    private int size;
    private int maxSize;

    public HeapMax() {
        heap = new int[startSize];
//        heap[0] = Integer.MAX_VALUE;
        size = 0;
    }

    public HeapMax(int maxSize) {
        this.maxSize = maxSize;
//        heap = new int[maxSize + 1];
        heap = new int[maxSize];
//        heap[0] = Integer.MAX_VALUE;
        size = -1;
//        size = 0;
    }

    private int parent(int i) {
        return (i - 1) / 2;
//        return i / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
//        return 2 * i;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
//        return 2 * i + 1;
    }

    private void grow() {
        maxSize = maxSize + maxSize >> 1;
        int[] temp = new int[maxSize];
        for (int i = 0; i < size + 1; i++) temp[i] = heap[i];
        heap = temp;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void siftUp(int i) {
        while (i > 0 && heap[i] > heap[parent(i)]) {
//        while (i > 1 && heap[i] > heap[parent(i)]) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    private void siftDown(int i) {
        int maxIndex = i;
        int l = leftChild(i);
        if (l <= size && heap[l] > heap[maxIndex]) maxIndex = l;
        int r = rightChild(i);
        if (r <= size && heap[r] > heap[maxIndex]) maxIndex = r;
        if (i != maxIndex) {
            swap(i, maxIndex);
            siftDown(maxIndex);
        }
    }

    void insert(int p) {
        if (size == maxSize - 1) grow();
        heap[++size] = p;
        siftUp(size);
    }

    int extractMax() {
        int result = heap[0];
//        int result = heap[1];
        heap[0] = heap[size--];
        siftDown(0);
//        siftDown(1);
        return result;
    }

    void remove(int i) {
        heap[i] = Integer.MAX_VALUE;
        siftUp(i);
        extractMax();
    }

    void changePriority(int i, int p) {
        int oldP = heap[i];
        heap[i] = p;
        if (p > oldP) siftUp(i);
        else siftDown(i);
    }

    int max() {
        return heap[0];
//        return heap[1];
    }
}
