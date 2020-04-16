package j8.oberservermode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Feed.java
 * @Description TODO
 * @Date 2019/10/21 20:26
 */
public class Feed implements Subject{
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer oberserver) {
        this.observers.add(oberserver);
    }

    @Override
    public void notifyObserver(String message) {
        observers.forEach(o -> o.notify(message));
    }

    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new PeoplesDaily());
        f.notifyObserver(" The queen said her favourite book is Java 8 in Action money");
    }
}
