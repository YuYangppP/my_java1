package J11Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Util.java
 * @Description TODO
 * @Date 2019/10/29 16:20
 */
public class Util {
    private static final DecimalFormat formatter = new DecimalFormat("#.##",new DecimalFormatSymbols(Locale.US));
    public static void delay(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static double format(double number){
        synchronized (formatter){
            return new Double(formatter.format(number));
        }

    }
}
