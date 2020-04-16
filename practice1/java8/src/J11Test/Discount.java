package J11Test;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Discount.java
 * @Description TODO
 * @Date 2019/10/29 16:13
 */
public class Discount {
    public enum Code{
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(){
        return "";
    }


}
