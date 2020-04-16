package templatemethod.caffeine;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Test.java
 * @Description 模板方法测试类
 * @Date 2020/3/20 15:01
 */
public class Test {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        Tea tea = new Tea();
        System.out.println("\nMaking tea...");
        tea.prepareRecipe();

        System.out.println("\nMaking coffee...");
        coffee.prepareRecipe();
    }
}
