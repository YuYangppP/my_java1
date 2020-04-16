package mingling;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Command.java
 * @Description TODO
 * @Date 2020/2/24 13:57
 */
public interface Command {
    public void execute();
    public void undo();
}
