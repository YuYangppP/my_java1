package java8.my_6;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;

/**
 * @author:yuyang
 * @data:2019-06-04 18:21
 **/
public class Util {

    private static final Random RANDOM = new Random(0);
    private static final DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));

    public static void delay() {
        int delay = 1000;
        //int delay = 500 + RANDOM.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static double format(double number) {
        synchronized (formatter) {
            return new Double(formatter.format(number));
        }
    }
}