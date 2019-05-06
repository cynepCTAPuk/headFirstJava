package chap02_observer.weather;

public interface Subj {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}