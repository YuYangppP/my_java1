package danli.two;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName SingleTwo.java
 * @Description 双检锁
 * @Date 2020/2/21 17:30
 */
public class SingleTwo {
    private volatile static SingleTwo uniqueInstance;
    private SingleTwo(){}

    public static SingleTwo getInstance(){
        if (uniqueInstance ==null){
            synchronized (SingleTwo.class){
                if (uniqueInstance == null){
                    uniqueInstance = new SingleTwo();
                }
            }
        }
        return uniqueInstance;
    }

    public void showMessage(){
        System.out.println("Hello World 2");
    }
}
