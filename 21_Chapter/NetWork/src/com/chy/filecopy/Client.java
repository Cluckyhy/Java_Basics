package com.chy.filecopy;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//客户端
public class Client {
    public static void main(String[] args) throws IOException {
        //创建一个Socket对象，连接本地服务器8888端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        //指定输出的文件路径
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\mao.png";

        //创建读取磁盘文件的输入流
        //private static int DEFAULT_BUFFER_SIZE = 8192;
        //默认是8192个字节
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        //bytes 就是filePath 对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //获取一个输出流，将bytes数据发送到服务端
        OutputStream outputStream = socket.getOutputStream();

        //向服务器发送一张图片
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);

        //将文件对应的字节数组的内容，写入到数据通道
        bos.write(bytes);
        //有缓冲区就要在socket.shutdownOutput();之前flush,当然close()中有flush()
        bos.flush();
        //可以直接通过close()方法作为结束
        //bos.close();
        //设置写入数据的结束标志
        socket.shutdownOutput();

        //我终于懂了。为什么在socket.shutdownOutput();前用了flush后，再close()不会报错，而没写flush()
        //在socket.shutdownOutput();后面使用close()会报错，因为，close()里面有flush()方法，
        //flush()方法他会去把缓冲区剩下的部分继续发送，而在这之前，你已经socket.shutdownOutput()，关闭了socket通道
        //这时候，就会报错， Cannot send after socket shutdown: socket write error
        //而如果在socket.shutdownOutput()，方法前使用flush()后，就表明，你在关闭socket通道前就已经把缓冲区中的数据
        //全部发送过去了，然后在socket.shutdownOutput()后close()也不会报错，因为这时候调用flush()也不用再使用
        //socket通道，继续发送数据。所以不会报错


        //接收服务端传过来的"收到图片"就退出
        InputStream inputStream = socket.getInputStream();
        //使用 StreamUtils 的方法，直接将 inputStream 读取到的内容 转换为字符串
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        //关闭输入流
        bos.close();
        bis.close();
        inputStream.close();
        socket.close();

    }
}
