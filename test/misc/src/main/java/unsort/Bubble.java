package unsort;

class Bubble {
    static void sort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int temp;
        int count = 0;
        while (left <= right) {
            for (int i = left; i < right; i++) {
                count++;
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            right--;
        }
        System.out.println(String.format("unsort.Bubble\tcycles\t%,d", count));
    }
}
