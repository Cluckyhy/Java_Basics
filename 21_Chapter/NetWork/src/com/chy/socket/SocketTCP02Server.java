package com.chy.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        //首先得到一个serverSocket对象
        //1、建立一个本地服务器，在9999端口处等待接收
        ServerSocket serverSocket = new ServerSocket(9999);

        //2、等待接收
        System.out.println("服务器，在9999端口监听，等待连接中...");
        Socket socket = serverSocket.accept();
        System.out.println("服务端，socket = " + socket.getClass());

        //3、从socket中得到一个输入流
        InputStream inputStream = socket.getInputStream();
        //4、读取从客户端发送过来的数据
        //先创建一个缓存
        byte[] buf = new byte[1024];
        //每次读取的长度
        int readLen = 0;
        //循环读取数据
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }

        //5、向客户端发送消息
        //获取一个输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes());
        //设置一个结束标记
        socket.shutdownOutput();


        //6、关闭流
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器退出...");
    }
}
