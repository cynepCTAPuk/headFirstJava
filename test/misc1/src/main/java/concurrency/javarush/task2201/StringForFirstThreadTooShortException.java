package concurrency.javarush.task2201;

public class StringForFirstThreadTooShortException extends RuntimeException {
    public StringForFirstThreadTooShortException(RuntimeException e) {
        initCause(e);
    }
}
