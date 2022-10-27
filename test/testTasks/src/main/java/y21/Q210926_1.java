package y21;

import java.util.Arrays;

public class Q210926_1 {
    public static void main(String[] args) {
        Generic<Double> obj = new Generic<Double>();
        System.out.println(obj);
    }
}

class Generic<T extends Number> {
//    private T arr[] = {1, 2, 3, 4, 5};
    private int[] arr = {1, 2, 3, 4, 5};

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}

