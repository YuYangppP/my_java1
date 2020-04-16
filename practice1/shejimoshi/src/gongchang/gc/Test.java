package gongchang.gc;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @Date 2020/2/21 13:57
 */
public class Test {
    public static void main(String[] args) {
        Factory factory = new IDCartFactory();
        Product card1 = factory.create("小明");
        Product card2 = factory.create("小红");
        card1.use();
        card2.use();

    }
}
