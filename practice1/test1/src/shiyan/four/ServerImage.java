package shiyan.four;

import java.io.*;
import java.net.*;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName ServerImage.java
 * @Description TODO
 * @Date 2019/10/28 12:52
 */

public class ServerImage {
    public static void main(String[] args) {
        DatagramPacket pack=null;
        DatagramSocket mailReceive=null;
        ServerThread thread;
        byte b[]= new byte[8192];
        InetAddress address=null;
        pack=new DatagramPacket(b,b.length);
        while (true) {
            try {
                mailReceive = new DatagramSocket(1234);
            } catch (IOException e1) {
                System.out.println("正在等待");
            }
            try {
                mailReceive.receive(pack);
                address = pack.getAddress();
                System.out.println("客户的地址：" + address);
            } catch (IOException e) {
            }
            if (address != null) {
                new ServerThread(address).start();
            }
        }
    }
}
class ServerThread extends Thread {
    InetAddress address;
    DataOutputStream out = null;
    DataInputStream in = null;
    String s = null;

    ServerThread(InetAddress address) {
        this.address = address;
    }

    @Override
    public void run() {
        FileInputStream in;
        byte b[] = new byte[8192];
        try {
            in = new FileInputStream("D:\\my_java\\practice1\\test1\\src\\shiyan\\four\\1.jpg");
            int n = -1;
            while ((n = in.read(b)) != -1) {
                DatagramPacket data = new DatagramPacket(b, n, address, 5678);
                DatagramSocket mailSend = new DatagramSocket();
                mailSend.send(data);
            }
            in.close();
            byte[] end = "end".getBytes();
            DatagramPacket data = new DatagramPacket(end, end.length, address, 5678);
            DatagramSocket mailSend = new DatagramSocket();
            mailSend.send(data);
        }
        catch (Exception e) { }
    }
}

