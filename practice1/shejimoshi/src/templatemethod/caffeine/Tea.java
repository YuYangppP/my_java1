package templatemethod.caffeine;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Tea.java
 * @Description Tea
 * @Date 2020/3/20 15:00
 */
public class Tea extends Caffeine {
    @Override
    void brew() {
        System.out.println("泡茶");
    }

    @Override
    void addIngredients() {
        System.out.println("加柠檬");
    }
}
