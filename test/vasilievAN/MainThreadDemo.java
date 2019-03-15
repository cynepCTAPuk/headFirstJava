package vasilievAN;

public class MainThreadDemo {
//    public static void main(String[] args) throws InterruptedException {
    public static void main(String[] args){
        Thread t = Thread.currentThread();
        long time = 2500;
        System.out.println(t);
        t.setName("Это самый главный поток");
        int p = t.getPriority();
        t.setPriority(++p);
        System.out.println(t);
        System.out.println("Выполнение потока приостановлено на " + (double) time / 1000 + " секунда.");
        try {
            t.sleep(time);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Работа программы завершена!");
    }
}
