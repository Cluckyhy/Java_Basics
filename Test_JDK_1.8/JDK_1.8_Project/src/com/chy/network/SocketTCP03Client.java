package com.chy.network;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//客户端，使用字符流接收数据
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        //创建一个Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //向服务端发送数据
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,Server");
        //好像jdk8才有用
        //插入换行符，标志着结束
        //bufferedWriter.newLine();   //可以使用插入一个换行符，表示写入的内容结束，注意：要求对方使用readLine()！！！
        //如果使用的字符流，需要手动刷新，否则数据不会写入数据通道
        //如果非要使用while循环，有一端必须使用shutdownOutput()
        bufferedWriter.flush();
        //结束标志
        socket.shutdownOutput();
        System.out.println("客户端退出...");

        //获取一个输入流对象
        InputStream inputStream = socket.getInputStream();
        //通过转换流对象
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        //读取数据
        String data = null;
        //如果下面用了newLine来标志结束的话，这里不可以使用while循环来进行读取数据，因为newLine也会返回内容，
        //导致读到的数据不为空，所以，就没有标志结束的语句了，所以会卡住
        while ((data = bufferedReader.readLine()) != null) {
            System.out.println(data);
        }


        //关闭流
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
