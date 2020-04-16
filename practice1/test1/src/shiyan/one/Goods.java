package shiyan.one;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Check.java
 * @Description TODO
 * @Date 2019/10/28 12:33
 */
public class Goods {
    boolean isDanger;
    String name;
    public boolean isDanger() {
        return isDanger;
    }

    public void setDanger(boolean boo) {
        isDanger = boo;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public void setIsDanger(boolean boo) {
        isDanger=boo;
    }
}

