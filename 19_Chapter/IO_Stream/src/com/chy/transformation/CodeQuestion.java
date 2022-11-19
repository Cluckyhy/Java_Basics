package com.chy.transformation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
看一个中文乱码问题
默认的ANSI编码是看不同地区，每个国家有每个国家的标准编码的，像我国一般使用的是GBK编码的
看自己电脑系统安装时设置的是哪种，也有可能是其他的，而不是GBK
 */
public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        //指定要读取的文件路径
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\test.txt";
        //1、创建一个输入流
        //2、默认情况下，不指定字符编码是以 UTF-8 编码格式进行读取数据的
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        //读取文本信息
        String s = br.readLine();
        System.out.println("读取信息为：" + s);
        //关闭流
        br.close();
    }
}
