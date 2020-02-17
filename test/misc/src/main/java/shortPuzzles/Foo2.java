package shortPuzzles;

public class Foo2 {
    public static void main(String[] args) {
        try {
            throw new NullPointerException("NPE 1");
        } catch (NullPointerException e) {
            throw new NullPointerException("NPE 2");
        } finally {
            return;
        }
    }

}
