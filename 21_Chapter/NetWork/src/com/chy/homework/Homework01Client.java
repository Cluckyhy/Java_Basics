package com.chy.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Homework01Client {
    public static void main(String[] args) throws IOException {
        //创建一个Socket对象，连接服务器的9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //获取一个输出字符流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入问题：");
        String data = scanner.next();
        //发送数据
        //bw.write("name");
        //bw.newLine();
        //bw.write("hobby");
        bw.write(data);
        bw.flush();
        //结束标志
        socket.shutdownOutput();

        //接收服务端的回复
        //获取一个字符输入流对象
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println(s);

        ////接收服务端的回复
        //String s1 = br.readLine();
        //System.out.println(s1);

        //关闭流
        br.close();
        bw.close();
        socket.close();
        System.out.println("客户端退出...");

    }
}
