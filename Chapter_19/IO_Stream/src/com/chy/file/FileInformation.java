package com.chy.file;

import org.junit.jupiter.api.Test;

import java.io.File;

public class FileInformation {
    public static void main(String[] args) {

    }

    @Test
    //获取文件信息
    public void info(){
        //先创建文件对象
        File file = new File("D:\\JUFE_Second\\Java_Study\\IOTest\\chy3.txt");

        //调用相应的方法，得到对应信息
        System.out.println("文件名："+file.getName());

        //文件的绝对路径
        System.out.println(file.getAbsoluteFile());

        //父级目录
        System.out.println("文件的父级目录："+file.getParent());

        //文件大小
        System.out.println("文件的大小(字节)："+file.length());

        //文件是否存在
        System.out.println("文件是否存在："+file.exists());

        //文件是否是一个文件
        System.out.println("是不是一个文件："+file.isFile());

        //是不是一个目录
        System.out.println("是不是一个目录："+file.isDirectory());
    }
}

