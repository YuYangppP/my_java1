package zuoye;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName PoliceListen.java
 * @Description TODO
 * @Date 2019/10/11 20:12
 */
public class PoliceListen implements MyCommandListener {
    JTextField textInput;
    JTextArea textShow;

    @Override
    public void setJTextField(JTextField text) {
        textInput = text;
    }

    @Override
    public void setJTextArea(JTextArea area) {
        textShow = area;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String x = textInput.getText();
        if (!(x == null || x.equals(""))) {
            try {
                int y = Integer.parseInt(x);
                long z = y * y;
                textShow.append(y + " 的平方是 " + z + "\n");
                System.out.println(z);
            } catch (NumberFormatException ex) {
                textShow.append("您输入有误，请重新输入!\n");
                textInput.setText("");
            }
        } else {
            textShow.append("请您输入一个数字\n");
            textInput.setText("");
        }
    }
}
