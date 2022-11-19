package com.chy.udp;

import java.io.IOException;
import java.net.*;

//发送端
public class UDPSenderA {
    public static void main(String[] args) throws IOException {
        //创建一个DatagramSocket对象，在端口9999出等待接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9998);

        //指定要发送的信息
        byte[] bytes = "Hello,明天吃火锅".getBytes();
        //创建一个数据报，用于发送，装包
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9999);
        //开始发送数据
        datagramSocket.send(datagramPacket);

        //接收数据
        //声明一个字节数据
        byte[] buf = new byte[1024];
        //创建一个数据报，用于接收数据
        DatagramPacket datagramPacket1 = new DatagramPacket(buf, buf.length);
        datagramSocket.receive(datagramPacket1);
        int length = datagramPacket1.getLength();
        byte[] data = datagramPacket1.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        //关闭
        datagramSocket.close();
        System.out.println("发送端A，退出...");
    }
}
