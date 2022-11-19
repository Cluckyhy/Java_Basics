package com.chy.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        //指定要写入的文件路径
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\note.txt";
        //创建一个处理流对象 BufferedWriter
        //1、new BufferedWriter(new FileWriter(filePath, true)) 表示以追加的方式写入
        //1、new BufferedWriter(new FileWriter(filePath)) 表示以覆盖的方式写入
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));

        //开始写入
        for (int i = 0; i < 5; i++) {
            bufferedWriter.write("好好学习，天天向上");
            bufferedWriter.newLine();
        }

        //关闭流，只需要关闭外层流
        bufferedWriter.close();

        System.out.println("写入数据完成");
    }
}
