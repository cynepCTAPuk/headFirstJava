package concurrency.javarush.task2201;

public class StringForSecondThreadTooShortException extends RuntimeException {
    public StringForSecondThreadTooShortException(RuntimeException e) {
        initCause(e);
    }
}
