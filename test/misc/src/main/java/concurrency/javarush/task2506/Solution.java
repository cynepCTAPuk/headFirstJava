package concurrency.javarush.task2506;

/* 
Мониторинг состояния нити
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start(); //NEW
        Thread.sleep(100);
        target.start();  //RUNNABLE
        Thread.sleep(100);
        target.interrupt(); //TERMINATED
    }

}