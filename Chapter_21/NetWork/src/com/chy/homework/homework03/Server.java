package com.chy.homework.homework03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class Server {
    public static void main(String[] args) throws IOException {
        //在本机上创建一个服务器，并且在端口为9999处，等待数据客户端传入数据
        ServerSocket serverSocket = new ServerSocket(9999);

        //等待接收数据
        System.out.println("服务器已经开启，等待接收数据...");
        Socket socket = serverSocket.accept();

        //获取一个输入流对象
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();

        byte[] bytes;
        if ("高山流水".equals(s)) {
            //从指定文件夹中加载一个音乐
            //指定文件路径
            String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\music\\高山流水.mp3";
            File file = new File(filePath);
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(filePath);
                bytes = StreamUtil.streamToByte(fileInputStream);
            } else {
                //默认音乐
                filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\music\\送别.mp3";
                FileInputStream fileInputStream = new FileInputStream(filePath);
                bytes = StreamUtil.streamToByte(fileInputStream);
            }
        } else {
            String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\music\\" + s + ".mp3";
            FileInputStream fileInputStream = new FileInputStream(filePath);
            bytes = StreamUtil.streamToByte(fileInputStream);
        }


        //获取一个输出流对象
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        bos.write(bytes);
        bos.flush();
        socket.shutdownOutput();

        //关闭流
        bos.close();
        br.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器退出...");
    }
}
