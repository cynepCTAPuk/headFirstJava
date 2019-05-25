package chap12_1_compound.observer;

public interface QuackObservable {
    void registerObserver(Observer observer);
    void notifyObservers();
}