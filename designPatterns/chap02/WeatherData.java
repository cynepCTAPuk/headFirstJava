package chap02;

public class WeatherData {
    // Объявления переменных экземпляров
    public void measurementsChanged() {
        float temp = getTemperature();
        float humidity = getHumidity();
        float pressure = getPressure();
//        currentConditionsDisplay.update(temp, humidity, pressure);
//        statisticsDisplay.update(temp, humidity, pressure);
//        forecastDisplay.update(temp, humidity, pressure);
    }

    private float getPressure() {
        return 0;
    }

    private float getHumidity() {
        return 0;
    }

    private float getTemperature() {
        return 0;
    }
// Другие методы WeatherData
}