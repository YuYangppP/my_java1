package zhuangshezhe;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Coffe.java
 * @Description TODO
 * @Date 2020/1/23 17:28
 */
public class Coffe {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()+"$"+beverage.cost());

        Beverage beverage1 = new HouseBlend();
        beverage1 = new Mocha(beverage1);
        System.out.println(beverage1.getDescription()+"$"+beverage1.cost());
    }
}
