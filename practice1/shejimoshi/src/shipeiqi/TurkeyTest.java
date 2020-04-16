package shipeiqi;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName TurkeyTest.java
 * @Description TODO
 * @Date 2020/2/25 17:43
 */
public class TurkeyTest {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();
        Turkey duckAdapter = new DuckAdapter(duck);

        for(int i=0;i<10;i++) {
            System.out.println("The DuckAdapter says...");
            duckAdapter.gobble();
            duckAdapter.fly();
        }
    }

    /*static void testTurkey(Turkey turkey){
        turkey.gobble();
        turkey.fly();
    }*/
}
