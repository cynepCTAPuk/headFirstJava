package patterns.chain_of_responsibility.task2912;

public interface Logger {
    void inform(String message, int level);

    void setNext(Logger next);

    void info(String message);
}