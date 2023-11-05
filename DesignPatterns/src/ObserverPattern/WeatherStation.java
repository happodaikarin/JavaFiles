package ObserverPattern;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(30.4f,65,33);
        weatherData.setMeasurements(35.4f,45,32);
        weatherData.setMeasurements(38.4f,55,24);
        weatherData.setMeasurements(33.4f,75,27);

    }
}
