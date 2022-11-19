package com.chy.outputstream;

/*
演示使用BufferedOutputStream 和 BufferedInputStream 使用
他们，可以完成二进制文件拷贝
 */


import java.io.*;

public class BufferedCopy {
    public static void main(String[] args) throws IOException {
        //源文件路径
        String srcFilePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\mao.png";
        //目标文件路径
        String desFilePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\test\\maoCopy.png";

        //创建BufferedOutputStream 和 BufferedInputStream 对象
        //因为 FileInputStream 是 InputStream 子类
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFilePath));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desFilePath));

        //循环的读取文件，并写入到 desFilePath中
        byte[] buff = new byte[1024];
        int readLen = 0;

        while ((readLen = bis.read(buff)) != -1) {
            bos.write(buff, 0, readLen);
        }

        //关闭流，关闭外层的处理流即可
        bis.close();
        bos.close();

        System.out.println("操作成功！");
    }
}
