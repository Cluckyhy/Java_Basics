package com.chy.writer;

import java.io.*;

public class BufferedCopy_ {
    public static void main(String[] args) throws IOException {

        /*
        1、BufferedReader 和 BufferedWriter 是按照字符操作
        2、不要去操作二进制文件[声音，视频，图片，doc，pdf，等等]，可能造成文件损坏
         */


        //指定要拷贝的文件路径
        String inputPath = "D:\\JUFE_Second\\Java_Study\\IOTest\\story.txt";
        //指定要拷贝到哪个文件路径
        String outputPath = "D:\\JUFE_Second\\Java_Study\\IOTest\\test\\storyCopy.txt";

        //创建处理流对象
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));

        //读取的行字符串
        String line;

        //循环读取数据
        //说明：readLine 读取一行内容，但是没有换行
        while((line = bufferedReader.readLine()) != null){
            //边读边写
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }

        //关闭流
        bufferedReader.close();
        bufferedWriter.close();

        System.out.println("操作成功！");
    }
}
