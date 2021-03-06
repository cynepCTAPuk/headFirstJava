package chap02_observer.weather;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subj weatherData;

    public CurrentConditionsDisplay(Subj weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("\nCurrent conditions: " +
                temperature + "F degrees and " + humidity + "% humidity");
    }
}