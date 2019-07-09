public class NowTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Now());
        thread.start();
    }
}
