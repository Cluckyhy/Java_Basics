package com.chy.homework;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

//发送端
public class Homework02SenderA {
    public static void main(String[] args) throws IOException {
        //创建一个DatagramSocket，等待接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入问题：");
        String question = scanner.next();
        //指定发送的数据信息
        byte[] bytes = question.getBytes();
        //创建一个数据报，用于发送数据
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8888);
        //发送数据
        datagramSocket.send(datagramPacket);

        //接收数据
        //声明一个字节数组
        byte[] buf = new byte[1024];
        //创建一个数据报，用于接收数据
        DatagramPacket datagramPacket1 = new DatagramPacket(buf, buf.length);
        datagramSocket.receive(datagramPacket1);
        //进行拆报
        int length = datagramPacket1.getLength();
        byte[] data = datagramPacket1.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        //关闭
        datagramSocket.close();
        System.out.println("发送端退出...");
    }
}
