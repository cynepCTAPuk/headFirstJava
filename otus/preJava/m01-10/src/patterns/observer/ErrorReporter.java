package patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class ErrorReporter {
    private final List<Observer> observers = new ArrayList<>();

    void register(Observer observer) {
        observers.add(observer);
    }

    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    void notify(Event event) {
        observers.forEach(observer -> observer.notify(event));

    }
}
