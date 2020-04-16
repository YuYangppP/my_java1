package templatemethod.caffeine;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Caffeine.java
 * @Description 模板
 * @Date 2020/3/20 14:53
 */
public abstract class Caffeine {
    //准备食谱
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addIngredients();
    }
    abstract void brew();
    abstract void addIngredients();
    void boilWater(){
        System.out.println("把水煮沸");
    }

    void pourInCup(){
        System.out.println("把饮料倒进杯子");
    }
}
