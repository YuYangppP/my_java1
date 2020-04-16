package zhuangshezhe;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Beverage.java
 * @Description 组件
 * @Date 2020/1/23 16:03
 */
public abstract class Beverage {
    String description = "Unkown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
