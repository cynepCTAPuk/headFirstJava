public class Thread40 {

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> System.out.println("Hello World");
        new Thread(task).start();
    }
}
