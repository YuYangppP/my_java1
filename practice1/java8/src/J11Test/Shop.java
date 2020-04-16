package J11Test;

import java.util.Random;

import static J11Test.Util.delay;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Shop.java
 * @Description TODO
 * @Date 2019/10/29 16:08
 */
public class Shop {
    private final String name;
    private final Random random;

    public Shop(String name) {
        this.name = name;
        random = new Random(name.charAt(0)+name.charAt(1));
    }
    
    public String getPrice(String product){
        double price = caculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return name+":"+price+":"+code;
    }

    private double caculatePrice(String product) {
        delay();
        return (random.nextDouble()*product.charAt(0)+product.charAt(1));
    }
}
