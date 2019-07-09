public class Thread12 {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        currentThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                System.out.println("Возникла ошибка: " + throwable.getMessage());
            }
        });
        System.out.println(2 / 0);
    }
}
