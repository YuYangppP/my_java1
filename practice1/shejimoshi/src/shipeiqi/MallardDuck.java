package shipeiqi;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName MallardDuck.java
 * @Description TODO
 * @Date 2020/2/25 17:26
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
