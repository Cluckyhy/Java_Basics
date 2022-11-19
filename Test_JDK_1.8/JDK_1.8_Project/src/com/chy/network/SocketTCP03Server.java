package com.chy.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//服务端，使用字符流发送数据
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        //创建一个本地服务器，服务端口为9999
        ServerSocket serverSocket = new ServerSocket(9999);

        //接收到一个Socket对象
        System.out.println("服务器端口9999已开通，等待连接中");
        Socket socket = serverSocket.accept();


        //接收客户端发送过来的数据
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String data = null;
        while ((data = bufferedReader.readLine()) != null) {
            System.out.println(data);
        }
        System.out.println("服务器退出...");

        //获取一个输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //使用转换流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        //写入数据
        bufferedWriter.write("hello,client");
        //插入换行符，标志着结束
        bufferedWriter.newLine();   //可以使用插入一个换行符，表示写入的内容结束，注意：要求对方使用readLine()！！！
        //如果使用的字符流，需要手动刷新，否则数据不会写入数据通道
        bufferedWriter.flush();
        //结束标志
        //socket.shutdownOutput();

        //关闭流
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();
    }
}
