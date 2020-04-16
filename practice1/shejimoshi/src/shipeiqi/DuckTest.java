package shipeiqi;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName DuckTest.java
 * @Description TODO
 * @Date 2020/2/25 17:33
 */
public class DuckTest {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(turkey);
        System.out.println("Turkey-------------------------");

        turkey.gobble();
        turkey.fly();
        System.out.println("Duck--------------------------");
        testDuck(duck);

        System.out.println("TurkeyAdapter---------------");
        testDuck(turkeyAdapter);

    }

    static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }
}
