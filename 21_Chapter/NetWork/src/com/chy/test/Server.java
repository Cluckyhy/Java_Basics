package com.chy.test;

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

        //向客户端回复 "收到图片"
        //得到一个输出流
        //BufferedWriter write = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //write.write("收到图片");
        //write.flush();//把内容刷新到数据通道
        //socket.shutdownOutput();    //设置结束标记

        //关闭其他流
        //write.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
