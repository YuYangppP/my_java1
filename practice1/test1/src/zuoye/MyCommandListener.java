package zuoye;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName MyCommandListener.java
 * @Description TODO
 * @Date 2019/10/11 19:59
 */
public interface MyCommandListener extends ActionListener {
    void setJTextField(JTextField text);

    void setJTextArea(JTextArea area);
}
