package j8.oberservermode;

public interface Subject {
    void registerObserver(Observer oberserver);

    void notifyObserver(String message);
}
