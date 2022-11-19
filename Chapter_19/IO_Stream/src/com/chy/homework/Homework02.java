package com.chy.homework;

import java.io.*;

public class Homework02 {
    public static void main(String[] args) throws IOException {
        //使用BufferedReader读取一个文本文件，为每行加上行号，
        //再连同内容一并输出到屏幕上

        //首先指定要读取的文件路径
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\story.txt";
        //创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "GBK"));

        //开始读取文件信息，循环读取文件
        String data = "";
        int count = 1;
        while ((data = br.readLine()) != null) {
            System.out.println(++count + data);
        }

        //关闭流
        br.close();
    }
}
