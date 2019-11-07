package clusters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ClustersFP {

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 2, 3, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 4, 0, 0, 0, 0, 0, 0, 0},
                {0, 3, 5, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 7, 2, 8, 0, 0},
                {0, 0, 0, 0, 0, 8, 0, 9, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        Stream stream = Arrays.stream(arr);


        System.out.println(Arrays.toString(
                Arrays.stream(arr)
                .flatMapToInt(new Function<int[], IntStream>() {
                    @Override
                    public IntStream apply(int[] array) {
                        return Arrays.stream(array);
                    }
                })
                .toArray()));
    }
}
