package com.chy.homework.homework03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


//客户端
public class Client {
    public static void main(String[] args) throws IOException {
        //创建一个Socket对象，连接本地服务器的9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);

        //指定要发送给服务器的信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你想听的歌名：");
        String music = scanner.next();

        //获取一个输出流对象
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(music);
        bw.flush();
        socket.shutdownOutput();

        //获取一个输入流对象
        InputStream inputStream = socket.getInputStream();
        //利用StreamUtil类，将要输出内容转换为字节数组
        byte[] bytes = StreamUtil.streamToByte(inputStream);

        //指定保存在哪个文件下
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\myMusic.mp3";
        //创建一个文件输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        fileOutputStream.write(bytes);

        //关闭流
        fileOutputStream.close();
        inputStream.close();
        bw.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}
