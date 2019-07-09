public class Now extends Thread {
    @Override
    public void run() {
        for (;;){
            System.out.print("now ");
        }
    }
}
