package concurrency.javarush.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread t : threads) {
            switch (t.getState()) {
                case NEW:
                    t.start();
                    break;
                case BLOCKED:
                case TIMED_WAITING:
                case WAITING:
                    t.interrupt();
                    break;
                case TERMINATED:
                    System.out.println(t.getPriority());
                    break;
                case RUNNABLE:
                    t.isInterrupted();
                    break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
