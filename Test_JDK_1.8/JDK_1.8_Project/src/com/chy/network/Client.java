package com.chy.network;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//客户端
public class Client {
    public static void main(String[] args) throws IOException {
        //创建一个Socket对象，连接本地服务器8888端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        //指定输出的文件路径
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\bj.jpg";

        //创建读取磁盘文件的输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        //bytes 就是filePath 对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //获取一个输出流，将bytes数据发送到服务端
        OutputStream outputStream = socket.getOutputStream();

        //向服务器发送一张图片
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);

        //将文件对应的字节数组的内容，写入到数据通道
        bos.write(bytes);
        bis.close();

        //有缓冲区就要在socket.shutdownOutput();之前flush,当然close()中有flush()
        bos.flush();
        socket.shutdownOutput();


        ////接收服务端传过来的"收到图片"就退出
        //InputStream inputStream = socket.getInputStream();
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //String s = bufferedReader.readLine();
        //System.out.println(s);

        //关闭输入流
        bos.close();
        socket.close();

    }
}
