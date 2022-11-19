package com.chy.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//客户端，使用字符流接收数据
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        //创建一个Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //获取一个输入流对象
        InputStream inputStream = socket.getInputStream();
        //通过转换流对象
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        //读取数据
        String data = null;
        //一定要注意，当下面使用的是，newLine作为结束标志的化，不能使用while循环来读取数据，
        //因为，newLine也会返回内容，导致读到的内容有null，而不能作为结束标志了
        //如果一定要用while循环的话，一定要在一端使用shutdownOutput()
        while ((data = bufferedReader.readLine()) != null) {
            System.out.println(data);
        }

        //向服务端发送数据
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,Server");
        ////插入换行符，标志着结束
        //bufferedWriter.newLine();   //可以使用插入一个换行符，表示写入的内容结束，注意：要求对方使用readLine()！！！
        //使用的缓冲字符流，需要手动刷新，否则数据不会写入数据通道
        bufferedWriter.flush();
        //结束标志
        socket.shutdownOutput();
        System.out.println("客户端退出...");

        //关闭流
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
