package zhuangshezhe;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName NaTie.java
 * @Description TODO
 * @Date 2020/1/23 17:16
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return .89;
    }
}
