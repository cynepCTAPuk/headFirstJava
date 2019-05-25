package chap12_ducks.observer;

public interface QuackObservable {
    void registerObserver(Observer observer);
    void notifyObservers();
}