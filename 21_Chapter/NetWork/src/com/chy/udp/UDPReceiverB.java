package com.chy.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//接收端
public class UDPReceiverB {
    public static void main(String[] args) throws IOException {
        //创建一个DatagramSocket，等待接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        //创建一个字节数组
        byte[] buf = new byte[1024];
        //创建一个数据报用于接收
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);

        //等待接收数据
        System.out.println("等待接收数据中...");
        datagramSocket.receive(datagramPacket);

        //接收报，拆报过程
        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        //指定发送的数据
        byte[] bytes = "好的，明天见".getBytes();
        //创建一个数据报，用户发送
        DatagramPacket datagramPacket1 = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9998);
        datagramSocket.send(datagramPacket1);

        //关闭
        datagramSocket.close();
        System.out.println("接收端B，退出...");
    }
}
