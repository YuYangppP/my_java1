package GuanChaZhe;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName WeatherTest.java
 * @Description TODO
 * @Date 2020/1/23 23:46
 */
public class WeatherTest {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(80,69,30.4f);
        weatherData.setMeasurements(82,70,29.2f);
        weatherData.setMeasurements(82,70,29.2f);
    }
}
