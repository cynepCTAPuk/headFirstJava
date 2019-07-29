public class Thread50 {

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> System.out.println("Task executed");
        Thread thread = new Thread(task);
        thread.start();
    }
}
