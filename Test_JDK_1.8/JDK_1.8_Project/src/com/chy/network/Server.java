package com.chy.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class Server {
    public static void main(String[] args) throws IOException {
        //创建一个本地服务器，在端口8888服务
        ServerSocket serverSocket = new ServerSocket(8888);

        //接收到一个客户端的连接
        System.out.println("服务器的8888端口服务已经打开，等待连接中...");
        Socket socket = serverSocket.accept();

        //获取一个字节输入流，用于接收客户端发送过来的图片
        InputStream inputStream = socket.getInputStream();
        //使用处理流
        BufferedInputStream bis = new BufferedInputStream(inputStream);

        //得到字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //将得到的bytes数组，写入到指定文件路径中，就得到一个文件了
        //指定输出到哪个文件的路径
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\test\\bjj.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        //写入数据到对应的文件
        bos.write(bytes);
        bos.close();

        //关闭其他流
        bis.close();
        socket.close();
        serverSocket.close();

        ////读取数据
        ////创建一个缓存
        //byte[] buf = new byte[1024];
        //int readLen = 0;
        ////指定输出的文件路径
        //String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\test\\mao.png";
        ////声明一个文件输出流对象
        //FileOutputStream fileOutputStream = null;
        ////循环读取字节
        ////while ((data = bufferedInputStream.read(buf, 0, readLen)) != -1) {
        ////    //创建一个文件输出流对象
        ////    fileOutputStream = new FileOutputStream(filePath);
        ////    //写入数据
        ////    fileOutputStream.write(buf, 0, data);
        ////}
        //while ((readLen = bufferedInputStream.read()) != -1) {
        //    //创建一个文件输出流对象
        //    fileOutputStream = new FileOutputStream(filePath);
        //    //写入数据
        //    fileOutputStream.write(buf, 0, readLen);
        //}

        ////发送收到图片到客户端
        //OutputStream outputStream = socket.getOutputStream();
        //outputStream.write("收到图片".getBytes());
        //socket.shutdownOutput();
        //
        ////关闭流
        //if (fileOutputStream != null) {
        //    fileOutputStream.close();
        //}
        //outputStream.close();
        //bufferedInputStream.close();
        //socket.close();
    }
}
