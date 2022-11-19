package com.chy.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class Homework01Server {
    public static void main(String[] args) throws IOException {
        //在本机上创建一个服务器，在端口9999处进行服务
        ServerSocket serverSocket = new ServerSocket(9999);

        //等待客户端连接
        System.out.println("服务器已开启，在9999端口处等待连接...");
        Socket socket = serverSocket.accept();

        //获取一个字符输入流对象
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String s = br.readLine();
        String answer;
        if("name".equals(s)){
            answer = "我叫陈慧亿";
        }else if("hobby".equals(s)){
            answer = "编写java程序";
        }else{
            answer = "你说啥子？";
        }

        bw.write(answer);
        //手动刷新数据
        bw.flush();
        //结束标志
        socket.shutdownOutput();
        //读取数据
        //String s = br.readLine();
        //String s1 = br.readLine();
        //if (!"name".equals(s) || !"hobby".equals(s1)) {
        //    //回复你说啥？
        //    //获取一个输出流对象
        //    bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //    bw.write("你说啥？");
        //    bw.flush();
        //    socket.shutdownOutput();
        //} else {
        //    bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //    bw.write("我是chy");
        //    bw.newLine();
        //    bw.write("编写java程序");
        //    bw.flush();
        //    socket.shutdownOutput();
        //}

        //关闭流
        bw.close();
        br.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器退出...");

    }
}
