package shipeiqi;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName TurkeyAdapter.java
 * @Description TODO
 * @Date 2020/2/25 17:31
 */
public class TurkeyAdapter implements Duck{
    Turkey turkey;
    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }

    public void quack(){
        turkey.gobble();
    }

    public void fly(){
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
