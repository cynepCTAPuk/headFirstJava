import java.util.Arrays;

public class DataReverse1 {
    public static int[] dataReverse(int[] data) {
        int size = data.length;
        if (size % 8 != 0) throw new RuntimeException("Array must have 8x elements");
        int[] result = new int[size];
        for (int i = 0; i < size; i += 8) {
            int k = 0;
            int j = size - (i + 8);
            while (j < size - i) result[i + k++] = data[j++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data1 = {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0};
        System.out.println(Arrays.toString(dataReverse(data1)));
        int[] data2 = {1, 2, 3, 4, 5, 6, 7, 8, 11, 12, 13, 14, 15, 16, 17, 18, 21, 22, 23, 24, 25, 26, 27, 28};
        System.out.println(Arrays.toString(dataReverse(data2)));
        int[] data3 = {1, 2, 3, 4, 5, 6, 7, 8, 11, 12, 13, 14, 15, 16, 17};
//        System.out.println(Arrays.toString(dataReverse(data3)));
    }
}