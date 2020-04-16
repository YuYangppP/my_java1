package zhuangshezhe;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Mocha.java
 * @Description TODO
 * @Date 2020/1/23 17:19
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage = beverage;

    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+" Mocha";
    }

    @Override
    public double cost() {
        return .20+beverage.cost();
    }
}
