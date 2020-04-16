package shiyan.one;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Check.java
 * @Description TODO
 * @Date 2019/10/28 12:37
 */
public class DangerException extends Exception {
    String message;

    public DangerException() {
        message = "危险品！";
    }

    public void toShow() {
        System.out.print(message + "");
    }
}



