package zuoye;

import javax.swing.*;
import java.awt.*;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName ActionEvent.java
 * @Description TODO
 * @Date 2019/10/11 19:54
 */

public class ActionEvent extends JFrame {
    JTextField inputText;
    JTextArea textShow;
    MyCommandListener listener;

    public ActionEvent() {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {
        setLayout(new FlowLayout());
        inputText = new JTextField(10);
        //button = new JButton("确定");
        textShow = new JTextArea(9, 30);
        add(inputText);
        add(new JScrollPane(textShow));
    }

    void setMycommandListener(MyCommandListener listener) {
        this.listener = listener;
        listener.setJTextField(inputText);
        listener.setJTextArea(textShow);
        inputText.addActionListener(listener);
    }
}
