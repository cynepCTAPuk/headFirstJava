public class FindCubePiramide {

    public static long findNb(long m) {
        long i = 0L;
        while (m != 0) {
            i++;
            m = m - (i * i * i);
            if (m < 0) return -1;
        }
        return i;
    }
}