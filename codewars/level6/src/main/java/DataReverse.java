import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReverse {
    public static int[] dataReverse(int[] data) {
        List<Integer> list = new ArrayList<>();
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i += 8) {
            for (int j = data.length - i - 8; j < data.length - i; j++) {
                list.add(data[j]);
            }
        }
        for (int i = 0; i <data.length ; i++) result[i] = list.get(i);
        return result;
    }

    public static void main(String[] args) {
        int[] data1 = {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0};
        int[] data2 = {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(dataReverse(data1)));
    }
}