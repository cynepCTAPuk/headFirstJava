package test.Sorting;

class Shake {
    static void sort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int swappedLeft, swappedRight;
        int swap;
        while (left <= right) {
            swappedRight = 0;
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    swap = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swap;
                    swappedRight = i;
                }
            }
//            right--;
            right = swappedRight;
            swappedLeft =  array.length-1;
            for (int i = right; i > left; i--) {
                if (array[i - 1] > array[i]) {
                    swap = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = swap;
                    swappedLeft = i;
                }
            }
//            left++;
            left = swappedLeft;
        }
    }

}
