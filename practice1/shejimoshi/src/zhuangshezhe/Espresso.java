package zhuangshezhe;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Espresso.java
 * @Description 浓缩咖啡
 * @Date 2020/1/23 17:14
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }
    @Override
    public double cost() {
        return 1.99;
    }
}
