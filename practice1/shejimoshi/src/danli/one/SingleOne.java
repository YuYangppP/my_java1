package danli.one;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName SingleOne.java
 * @Description TODO
 * @Date 2020/2/21 17:23
 */
public class SingleOne {
    //创建一个SingleOne对象
    private static SingleOne instance = new SingleOne();
    //创建私有构造器
    private SingleOne(){}

    //获取唯一可用的对象
    public static SingleOne getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}
