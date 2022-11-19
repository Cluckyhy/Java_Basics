package com.chy.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//接收端
public class Homework02ReceiverB {
    public static void main(String[] args) throws IOException {
        //创建一个DatagramSocket对象，等待接收数据
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        //指定一个字节数组
        byte[] buf = new byte[1024];
        //创建一个数据报，用于接收数据
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        System.out.println("等待接收数据...");
        datagramSocket.receive(datagramPacket);
        //拆报过程
        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        String s = new String(data, 0, length);

        byte[] bytes;
        if("四大名著有哪些？".equals(s)){
            //返回数据
            //指定要发送的数据
            bytes = "四大名著有《三国演义》《水浒传》《四游记》《红楼梦》".getBytes();
        }else{
            bytes = "what?".getBytes();
        }

        //创建一个数据报，用于发送数据
        DatagramPacket datagramPacket1 = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9999);
        //发送数据
        datagramSocket.send(datagramPacket1);

        //关闭
        datagramSocket.close();
        System.out.println("接收端退出...");
    }
}
