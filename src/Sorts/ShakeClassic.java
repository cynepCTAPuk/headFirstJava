package Sorts;

class ShakeClassic {
    static void sort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int swap;
        int count = 0;
        while (left <= right) {
            for (int i = left; i < right; i++) {
                count++;
                if (array[i] > array[i + 1]) {
                    swap = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swap;
                }
            }
            right--;

            for (int i = right; i > left; i--) {
                count++;
                if (array[i - 1] > array[i]) {
                    swap = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = swap;
                }
            }
            left++;
        }
        System.out.println(String.format("ShakeCl\tcycles\t%,d", count));
    }
}
