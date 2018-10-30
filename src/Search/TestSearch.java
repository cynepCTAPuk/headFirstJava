package Search;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static java.lang.String.format;

class TestSearch {

    public static void main(String[] args) {
        Random random = new Random();
        int size = 1_000;
        int maxElement = 100_000;
        Integer[] integers = Stream.generate(() -> random.nextInt(maxElement))
                .limit(size).sorted().toArray(Integer[]::new);
        //the element that should be found
        Integer shouldBeFound = integers[random.nextInt(size - 1)];

        BinarySearch binarySearch = new BinarySearch();
        double t0 = System.nanoTime();
        int atIndex = binarySearch.find(integers, shouldBeFound);
        double t1 = System.nanoTime() - t0;
        System.out.println(String.format("Should be found: %d. Found %d at index %d. An array length %d"
                , shouldBeFound, integers[atIndex], atIndex, size));
        int toCheck = Arrays.binarySearch(integers, shouldBeFound);
        System.out.println(format("Found by system method at an index: %d. Is equal: %b"
                , toCheck, toCheck == atIndex));
        System.out.println(String.format("binarySearch time sourch = %,.0f nanoseconds", t1));

        System.out.println();
        IterativeBinarySearch iterativeBinarySearch = new IterativeBinarySearch();
        t0 = System.nanoTime();
        int index = iterativeBinarySearch.find(integers, shouldBeFound);
        double t2 = System.nanoTime() - t0;
        System.out.println(String.format("Should be found: %d. Found %d at index %d. An array length %d"
                , shouldBeFound, integers[index], index, size));
        int check = Arrays.binarySearch(integers, shouldBeFound);
        System.out.println(format("Found by system method at an index: %d. Is equal: %b"
                , check, check == index));
        System.out.println(String.format("IterativeBinarySearch time sourch = %,.0f nanoseconds", t2));
    }
}
