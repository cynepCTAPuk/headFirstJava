package chap02_observer.weather;

public interface Observer {
    public void update(float temperature, float humidity, float pressure);
}