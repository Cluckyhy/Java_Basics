package com.chy.writer;

import java.io.*;

public class FileWriter_ {
    public static void main(String[] args) {
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\note.txt";
        //创建一个FileWriter 对象
        FileWriter fileWriter = null;
        char[] chars = {'a', 'b', 'c'};
        try {
            fileWriter = new FileWriter(filePath);      //默认是覆盖写入
            //5中方法写入字符

            //1、write(int c)写入单个字符
            //fileWriter.write('陈');

            //2、write(char[])：写入指定数组
            //fileWriter.write(chars);

            //3、write(char[],off,len)：写入指定数组指定的部分
            //fileWriter.write("陈慧亿".toCharArray(),1,2);  //慧亿

            //4、write(String)：写入整个字符串
            //fileWriter.write("好好学习");                  //好好学习

            //5、write(String,off,len)：写入整个字符的指定部分
            fileWriter.write("天天向上", 0, 2);              //天天

            //在数据量大的情况下，可以使用循环操作

            fileWriter.write("风雨之后，定见彩虹");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //对于 FileWriter，一定要记得关闭流，或者flush才能真正的把数据写入到文件
            try {
                //fileWriter.flush();
                //关闭文件流，等价于  flush()  +  关闭
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("程序结束！");
    }
}
