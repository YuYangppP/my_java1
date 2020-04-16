package shiyan.four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.*;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName ClientImage.java
 * @Description TODO
 * @Date 2019/10/28 12:52
 */
class ImageCanvas extends Canvas {
    Image image = null;

    public ImageCanvas() {
        setSize(20, 200);
    }

    @Override
    public void paint(Graphics g) {
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }

    }

    public void setImage(Image image) {
        this.image = image;
    }

}

public class ClientImage extends JFrame implements Runnable, ActionListener {

    JButton b = new JButton("获取图像");
    ImageCanvas canvas;

    ClientImage() {
        super("I am a client");
        setSize(320, 200);
        setVisible(true);
        b.addActionListener(this);
        add(b, BorderLayout.NORTH);
        canvas = new ImageCanvas();
        add(canvas, BorderLayout.CENTER);
        Thread thread = new Thread(this);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thread.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        byte[] b = "请发图象".trim().getBytes();
        try {
            InetAddress address = InetAddress.getByName("192.168.148.1");
            DatagramPacket data = new DatagramPacket(b, b.length, address, 1234);
            DatagramSocket mailSend = new DatagramSocket();
            mailSend.send(data);

        } catch (Exception e1) {

        }
    }

    @Override
    public void run() {
        DatagramSocket mailReceive = null;
        DatagramPacket pack = null;
        byte[] b = new byte[8192];
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            pack = new DatagramPacket(b, b.length);
            mailReceive = new DatagramSocket(5678);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            while (true) {
                mailReceive.receive(pack);
                String message = new String(pack.getData(), 0, pack.getLength());
                if (message.startsWith("end")) {
                    break;
                }
                out.write(pack.getData(), 0, pack.getLength());
            }
            byte[] imagebyte = out.toByteArray();
            out.close();
            Toolkit tool = getToolkit();
            Image image = tool.createImage(imagebyte);
            canvas.setImage(image);
            canvas.repaint();
            validate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ClientImage();

    }
}
