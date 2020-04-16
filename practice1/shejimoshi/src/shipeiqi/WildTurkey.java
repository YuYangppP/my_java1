package shipeiqi;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName WildTurkey.java
 * @Description TODO
 * @Date 2020/2/25 17:28
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying short distance");
    }
}
