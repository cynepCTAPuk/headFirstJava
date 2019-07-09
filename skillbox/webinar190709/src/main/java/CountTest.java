public class CountTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Count());
        thread.start();
    }
}
