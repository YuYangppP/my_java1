package j8.strategyMode;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Testj8.java
 * @Description TODO
 * @Date 2019/10/21 19:53
 */
public class Testj8 {
    public static void main(String[] args) {
        Validator validator1 = new Validator((String s) -> s.matches("[a-z]+"));
        boolean b1 = validator1.validate("aaaaa");
        Validator validator2 = new Validator((String s) -> s.matches("\\d+"));
        boolean b2 = validator2.validate("bbbbbbbbb");
        System.out.println(b1);
        System.out.println(b2);
    }
}
