package chap08_Generic.pair1;

/**
 * @author Cay Horstmann
 * @version 1.01 2012-01-26
 */
public class PairTest1 {
    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
        System.out.println(ArrayAlg.getMiddle(words));

        var middle = ArrayAlg.getMiddle(3.14, 1729, "text", mm, null, 1L);
        System.out.println(middle + ":" + middle.getClass());

        System.out.println(ArrayAlg.getMiddle("Hello", 0, "middle", null, 1.0).getClass());
    }
}

class ArrayAlg {
    /**
     * Gets the minimum and maximum of an array of strings.
     *
     * @param a an array of strings
     * @return a pair with the min and max values, or null if a is null or empty
     */
    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
    }

    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }
}
