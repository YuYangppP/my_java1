package zuoye;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Example.java
 * @Description TODO
 * @Date 2019/10/11 20:11
 */
public class Example {
    public static void main(String[] args) {
        ActionEvent y = new ActionEvent();
        PoliceListen police = new PoliceListen();
        y.setMycommandListener(police);
        y.setBounds(100, 100, 460, 360);
        y.setTitle("计算平方的ActionEvent");
    }
}