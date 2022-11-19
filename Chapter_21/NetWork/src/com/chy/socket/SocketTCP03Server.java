package com.chy.socket;

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

        //获取一个输出流对象
        OutputStream outputStream = socket.getOutputStream();

        //使用转换流
        //针对于所有具有缓冲功能的处理流
        //我们都需要手动刷新数据，不然会造成数据没发送出去，或则数据有损失的情况
        //flush()很重要！！
        //private static int defaultCharBufferSize = 8192;
        //所以，一般情况下都是需要手动刷新缓冲区里面的数据，不然，数据会留在缓冲区中，不会发送出去
        //这个flush就好比我们哪一个棍子从没满的管子中桶出里面的数据，
        //但是如果你的数据满了8192，系统会自动发送出8192个字符，但是我们要养成flush的习惯
        //因为谁也保证不了你的数据字符数就刚好会使8192个，无论是少于8192还是多于8192个字符
        //缓冲区中的数据都会有剩余的数据，需要我们手动的刷新


        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        //写入数据
        bufferedWriter.write("hello,client");
        //使用缓冲字符流，需要手动刷新，否则数据不会写入数据通道
        bufferedWriter.flush();
        //结束标志
        socket.shutdownOutput();

        //接收客户端发送过来的数据
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String data = null;
        while ((data = bufferedReader.readLine()) != null) {
            System.out.println(data);
        }
        System.out.println("服务器退出...");

        //关闭流
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();
    }
}
