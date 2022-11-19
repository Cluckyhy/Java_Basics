package com.chy.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

//客户端
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        //创建一个Socket对象
        //1、连接服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回 = " + socket.getClass());
        //2、获取一个输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3、向服务端输出数据
        outputStream.write("hello,server".getBytes());
        socket.shutdownOutput();

        //4、接收服务端传来的消息
        //获取一个输入流
        InputStream inputStream = socket.getInputStream();
        //读取数据
        //创建一个缓冲
        byte[] buf = new byte[1024];
        int readLen = 0;
        //循环读取数据
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }

        //5、关闭流
        outputStream.close();
        inputStream.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}
