package templatemethod.caffeine;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Coffee.java
 * @Description Coffee
 * @Date 2020/3/20 14:59
 */
public class Coffee extends Caffeine {
    @Override
    void brew() {
        System.out.println("泡咖啡");
    }

    @Override
    void addIngredients() {
        System.out.println("加牛奶和糖");
    }
}
