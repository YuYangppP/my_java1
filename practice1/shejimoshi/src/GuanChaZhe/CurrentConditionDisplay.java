package GuanChaZhe;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName CurrentConditionDisplay.java
 * @Description TODO
 * @Date 2020/1/23 23:12
 */
public class CurrentConditionDisplay implements Observer,DisplayElement {
    private float temp;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        System.out.println("Current conditions:"+temp+"°"+humidity+"湿度"+pressure+"气压");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
