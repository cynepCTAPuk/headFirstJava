package concurrency.javarush.task2508;

public interface CustomThreadManipulator {
    void start(String threadName);
    void stop();
}
