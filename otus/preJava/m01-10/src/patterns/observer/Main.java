package patterns.observer;

public class Main {
    public static void main(String[] args) {
        ErrorReporter errorReporter = new ErrorReporter();

        Observer o1 = new OutObserver();

        errorReporter.register(o1);

        errorReporter.register(new OutObserver());
        errorReporter.register(new ErrObserver());

        errorReporter.unregister(o1);

        errorReporter.notify(new Event());
    }
}
