package zuoye2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Window.java
 * @Description TODO
 * @Date 2019/10/15 22:58
 */
public class Window extends JFrame implements ActionListener{
    Trapezoid trapezoid;
    private JTextField upperBottom;
    private JTextField lowerBottom;
    private JTextField height;
    private JTextArea showArea;
    private JButton button1;

    public Window() throws HeadlessException {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init(){
        trapezoid = new Trapezoid();
        upperBottom = new JTextField(5);
        lowerBottom = new JTextField(5);
        height = new JTextField(5);
        showArea = new JTextArea();
        button1 = new JButton("计算梯形面积");
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("上底:"));
        jPanel.add(upperBottom);
        jPanel.add(new JLabel("下底:"));
        jPanel.add(lowerBottom);
        jPanel.add(new JLabel("高:"));
        jPanel.add(height);
        jPanel.add(button1);
        button1.addActionListener(this);
        add(jPanel,BorderLayout.NORTH);
        add(new JScrollPane(showArea),BorderLayout.CENTER);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double u = Double.parseDouble(upperBottom.getText().trim());
            double l = Double.parseDouble(lowerBottom.getText().trim());
            double h = Double.parseDouble(height.getText().trim());
            trapezoid.setUpperBottom(u);
            trapezoid.setLowerBottom(l);
            trapezoid.setHeight(h);
            double area = trapezoid.getArea();
            showArea.append("面积是:" + area+"\n");
        } catch (Exception e1) {
            showArea.append("输入有误请重新输入\n");
        }
    }
}
