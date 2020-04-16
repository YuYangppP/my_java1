package GuanChaZhe;

import java.util.ArrayList;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName WeatherData.java
 * @Description TODO
 * @Date 2020/1/23 22:54
 */
public class WeatherData implements Subject {
    private ArrayList observers;
    private float temp;
    private float humidity;
    private float pressure;
    public WeatherData(){
        observers = new ArrayList();
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temp,humidity,pressure);
        }
    }

    public void setMeasurements(float temp,float humidity,float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measureChanged();
    }

    private void measureChanged() {
        notifyObservers();
    }
}
