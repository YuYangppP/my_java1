package shipeiqi;

import java.util.Random;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName DuckAdapter.java
 * @Description TODO
 * @Date 2020/2/25 17:41
 */
public class DuckAdapter implements Turkey{
    Duck duck;
    Random rand;
    public DuckAdapter(Duck duck) {
        this.duck = duck;
        rand = new Random();

    }
    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        if (rand.nextInt(5)  == 0) {
            duck.fly();
        }
    }
}
