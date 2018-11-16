package utils;

class Bubble {
    static void sort(int[] array) {
        int left = 0;
        int s = array.length;
        int right = array.length - 1;
        int swap;
        int count = 0;
        while (left <= right) {
            for (int i = left; i < right; i++) {
                if ((count % (s*s>>5)) == 0) System.out.print("X");
                count++;
                if (array[i] > array[i + 1]) {
                    swap = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swap;
                }
            }
            right--;
        }
        System.out.println();
        System.out.println(String.format("Bubble\tcycles\t%,d", count));

    }
}
