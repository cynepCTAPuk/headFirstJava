package test.Sorting;

class OddEven {
    static void sort(int[] array) {
        int left;
        int right = array.length - 1;
        int swap;
        boolean b = true;
        while (b) {
            b = false;
            left = 0;
            for (int i = left; i < right; i = i + 2) {
                if (array[i] > array[i + 1]) {
                    b = true;
                    swap = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swap;
                }
            }
            left = 1;
            for (int i = left; i < right; i = i + 2) {
                if (array[i] > array[i + 1]) {
                    b = true;
                    swap = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swap;
                }
            }
        }
    }

}
