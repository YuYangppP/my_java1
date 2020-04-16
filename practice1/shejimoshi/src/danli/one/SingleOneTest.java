package danli.one;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName SingleOneTest.java
 * @Description 饿汉式
 * @Date 2020/2/21 17:27
 */
public class SingleOneTest {
    public static void main(String[] args) {
/*
        编译错误
        SingleOne singleOne = new SingleOne();
*/
        SingleOne singleOne = SingleOne.getInstance();
        singleOne.showMessage();
    }
}
