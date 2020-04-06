package integer;

public class BitTest {
    public static void main(String[] args) {
        int n = 1;
        System.out.println(Integer.toString(n, 2));

        System.out.println(Integer.toString(rotateRight(n, 31), 2));
        System.out.println(Integer.toString(rotateLeft(n, 1), 2));

        System.out.println((Integer.rotateRight(n, -2)));
        System.out.println((Integer.rotateLeft(n, 2)));
    }

    public static int rotateRight(int i, int distance) {
        return (i >>> distance) | (i << -distance);
    }

    public static int rotateLeft(int i, int distance) {
        return (i << distance) | (i >>> -distance);
    }
}
