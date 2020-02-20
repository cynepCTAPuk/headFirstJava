package concurrency.javarush.task2201;

import java.util.Objects;

/*
Строки нитей или строковые нити? Вот в чем вопрос
*/
public class Solution {
    public static void main(String[] args) {
        new Solution();
//        System.out.println(new Solution().getPartOfString(
//                "A\tB\tC\tD\tE\tF\tG\tH\tI","t"));
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this,
                "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this,
                "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this,
                "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new OurUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {
        try {
            int start = string.indexOf("\t");
            int end = string.lastIndexOf("\t");
            return string.substring(start + 1, end);
        } catch (RuntimeException e) {
            if (Objects.equals(threadName, Solution.FIRST_THREAD_NAME))
                throw new StringForFirstThreadTooShortException(e);
            else if (Objects.equals(threadName, Solution.SECOND_THREAD_NAME))
                throw new StringForSecondThreadTooShortException(e);
            else throw new RuntimeException(e);
        }
    }
}
