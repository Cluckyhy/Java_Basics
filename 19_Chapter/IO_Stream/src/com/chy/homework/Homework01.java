package com.chy.homework;

import java.io.*;

public class Homework01 {
    public static void main(String[] args) throws IOException {
        //在D:\JUFE_Second\Java_Study\IOTest文件下创建一个homework文件夹
        //在D:\JUFE_Second\Java_Study\IOTest\\homework文件下面创建文件hello.txt

        String directory = "D:\\JUFE_Second\\Java_Study\\IOTest\\homework";
        //首先创建一个文件对象
        File file = new File(directory);
        if(!file.exists()){
            //创建：
            if(file.mkdirs()){
                System.out.println("创建目录成功...");
            }else{
                System.out.println("创建失败...");
            }
        }else{
            System.out.println("文件已经存在...");
        }
        String filePath = directory+"\\hello.txt";
        file = new File(filePath);
        if(!file.exists()){
            //创建文件
            if(file.createNewFile()){
                System.out.println(filePath + "创建成功！");

                //如果文件存在，我们就使用BufferedWriter 字符输入流写入内容
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write("hello 陈慧亿..");
                bufferedWriter.close();
            }else{
                System.out.println("创建失败~");
            }
        }else{
            System.out.println(filePath + "文件已经存在..不需要重复创建");
        }


    }
}
