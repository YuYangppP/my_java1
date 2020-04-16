package j8.oberservermode;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName NYTimes.java
 * @Description TODO
 * @Date 2019/10/21 20:24
 */
public class NYTimes implements Observer {
    @Override
    public void notify(String message) {
        if (message != null && message.contains("book")) {
            System.out.println("You have new message in NY" + message);
        }
    }
}
