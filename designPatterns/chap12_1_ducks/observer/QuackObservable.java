package chap12_1_ducks.observer;

public interface QuackObservable {
    void registerObserver(Observer observer);
    void notifyObservers();
}