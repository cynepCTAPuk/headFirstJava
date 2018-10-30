package Search;

import static java.lang.String.format;

/**
 * Binary search is one of the most popular algorithms
 * This class represents iterative version  {@link BinarySearch}
 * Iterative binary search is likely to have lower constant factors because it doesn't involve the overhead of manipulating the call stack.
 * But in java the recursive version can be optimized by the compiler to this version.
 * <p>
 * Worst-case performance	O(log n)
 * Best-case performance	O(1)
 * Average performance	O(log n)
 * Worst-case space complexity	O(1)
 *
 * @see SearchAlgorithm
 * @see BinarySearch
 */

public final class IterativeBinarySearch implements SearchAlgorithm {

    /**
     * This method implements an iterative version of binary search algorithm
     *
     * @param array a sorted array
     * @param key   the key to search in array
     * @return the index of key in the array or -1 if not found
     */
    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        int left, right, k, cmp;
        left = 0;
        right = array.length - 1;
        while (left <= right) {
            k = (left + right) / 2;
            cmp = key.compareTo(array[k]);
            if (cmp == 0) {
                return k;
            } else if (cmp < 0) {
                right = --k;
            } else {
                left = ++k;
            }
        }
        return -1;
    }
}
