public class Count extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100 ; i++) {
            System.out.print(i + " ");
            try {
                sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
