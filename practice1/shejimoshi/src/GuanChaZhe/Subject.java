package GuanChaZhe;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Subject.java
 * @Description TODO
 * @Date 2020/1/23 22:45
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
