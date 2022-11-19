package com.chy.outputstream;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    @Test
    /*
    演示使用FileOutputStream 将数据写到文件中
    如果该文件不存在，则创建文件
     */
    public void writeFile() {
        //创建 FileOutputStream对象
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\a.txt";
        FileOutputStream fileOutputStream = null;

        try {
            //得到 FileOutputStream 对象
            //说明：
            //1、new FileOutputStream(filePath) 创建方法，当写入内容时，会覆盖原来的内容
            //2、new FileOutputStream(filePath,true) 创建方式，当写入内容时，是追加到文件后面
            fileOutputStream = new FileOutputStream(filePath, true);
            //写入一个字节
            //fileOutputStream.write('C');    //char -->  int

            //写入字符串
            //String str = "hello,World!";
            ////str.getBytes() 此方法可以把一个字符串转成一个字符数组
            //fileOutputStream.write(str.getBytes());

            //写入指定长度的字符
            String str = "hello,World!";
            //str.getBytes() 此方法可以把一个字符串转成一个字符数组
            fileOutputStream.write(str.getBytes(), 2, 5);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
