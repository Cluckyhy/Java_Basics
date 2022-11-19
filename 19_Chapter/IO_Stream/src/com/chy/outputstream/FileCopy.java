package com.chy.outputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        /*
        完成 文件的拷贝，将 D:\JUFE_Second\Java_Study\IOTest 拷贝到D:\JUFE_Second\Java_Study\IOTest\test文件下
        1、创建输入流对象，将文件读入到内存中
        2、创建输出流对象，将文件写入到指定文件中
         */

        //1、创建输入流对象
        //指定要读取数据的文件路劲
        String inputPath = "D:\\JUFE_Second\\Java_Study\\IOTest\\mao.png";
        String outputPath = "D:\\JUFE_Second\\Java_Study\\IOTest\\test\\copy.png";
        FileInputStream fileinputstream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileinputstream = new FileInputStream(inputPath);
            fileOutputStream = new FileOutputStream(outputPath);

            //定义一个字节数组，提高读取效率
            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = fileinputstream.read(buf)) != -1) {
                //读取到后，就写入到文件，通过 fileOutputStream
                //即，是一边读，一边写
                fileOutputStream.write(buf, 0, readLen);        //一定要使用这个方法
            }
            System.out.println("拷贝成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭输入流和输出流，释放资源
                if(fileinputstream != null){
                    fileinputstream.close();
                }
                if(fileOutputStream != null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
