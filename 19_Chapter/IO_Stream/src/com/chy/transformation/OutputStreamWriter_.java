package com.chy.transformation;

import java.io.*;

/*
演示 OutputStreamWriter 使用
把 FileOutputStream 字节流 转换为字符流  OutputStreamWriter
指定处理的编码 gbk/utf8
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        //指定要写入的文件路径
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\chy.txt";
        //创建一个BufferedWriter对象
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "utf8"));
        //开始写入数据
        bw.write("好好学习，天天向上");
        //关闭外层流
        bw.close();
        System.out.println("操作完成！");
    }
}
