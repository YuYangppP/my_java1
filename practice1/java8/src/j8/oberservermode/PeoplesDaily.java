package j8.oberservermode;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName PeoplesDaily.java
 * @Description TODO
 * @Date 2019/10/21 20:17
 */
public class PeoplesDaily implements Observer {
    @Override
    public void notify(String message) {
        if (message != null && message.contains("money")) {
            System.out.println("Chinese PeopleSDaily" + message);
        }
    }
}

