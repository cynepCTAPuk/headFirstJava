package chap12;

public class Exercise3 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4};
        try {
            System.out.println(ints[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("index");
            e.printStackTrace(System.out);
        }
    }
}
