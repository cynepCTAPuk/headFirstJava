public class BinarySearch implements SearchAlgorithm {

    /**
     * @param array is an array where the element should be found
     * @param key   is an element which should be found
     * @param <T>   is any comparable type
     * @return index of the element
     */
    @Override
    public <T extends Comparable<T>> int find(T array[], T key) {
        return search(array, key, 0, array.length);
    }

    /**
     * This method implements the Generic Binary Search
     *
     * @param array The array to make the binary search
     * @param key   The number you are looking for
     * @param left  The lower bound
     * @param right The  upper bound
     * @return the location of the key
     **/
    private <T extends Comparable<T>> int search(T array[], T key, int left, int right) {
        if (right < left) return -1; // this means that the key not found
        int median = (left + right) >>> 1;
        int comp = key.compareTo(array[median]);
        if (comp < 0) return search(array, key, left, median - 1);
        if (comp > 0) return search(array, key, median + 1, right);
        return median;
    }
}
