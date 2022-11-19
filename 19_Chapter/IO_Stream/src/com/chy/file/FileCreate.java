package com.chy.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/*
演示创建文件
 */
public class FileCreate {
    public static void main(String[] args) {

    }

    @Test
    public void create01(){
        //方式1 new File(String pathname)
        String path = "D:\\JUFE_Second\\Java_Study\\IOTest\\chy.txt";
        File file = new File(path);
        try {
            file.createNewFile();
            System.out.println("文件创建成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //方式2 new File(File parent, String child) 根据父目录文件+子路径创建
    public void create02(){
        File parentFile = new File("D:\\JUFE_Second\\Java_Study\\IOTest");
        String fileName = "chy2.txt";
        //这里的file对象，在java程序中，只是一个对象
        //只有执行了createFile()方法，才会真正的，在磁盘上创建该文件
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();
            System.out.println("文件创建成功！");
        } catch (IOException e) {

        }
    }

    @Test
    //方式3 new File(String parent,String child)  根据父目录+子路径构建
    public void create03(){
        String parent = "D:\\JUFE_Second\\Java_Study\\IOTest";
        String child = "chy3.txt";
        File file = new File(parent, child);
        try {
            file.createNewFile();
            System.out.println("创建文件成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
