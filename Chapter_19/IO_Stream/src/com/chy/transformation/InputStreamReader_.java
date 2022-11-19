package com.chy.transformation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/*
演示使用 InputStreamReader 转换流解决中文乱码问题
将字节流 FileInputStream 转换成字符流
把字符流包装到BufferedReader类中
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        //指定要读取的文件路径
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\test.txt";
        //创建一个文件输入流对象
        FileInputStream fileInputStream = new FileInputStream(filePath);
        //将字节流转换为字符流
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
        //把字符流包装到BufferedReader类中
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        //读取文件中的数据
        String s = bufferedReader.readLine();
        //输出数据
        System.out.println("数据为：" + s);
        //关闭外层流即可
        bufferedReader.close();
    }
}
