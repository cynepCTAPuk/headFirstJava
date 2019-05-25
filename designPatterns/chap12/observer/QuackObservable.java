package chap12.observer;

public interface QuackObservable {
    void registerObserver(Observer observer);
    void notifyObservers();
}