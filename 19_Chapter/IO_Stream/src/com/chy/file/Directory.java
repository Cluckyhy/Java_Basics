package com.chy.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;

public class Directory {
    public static void main(String[] args) {

        //
    }

    @Test
    //判断 "D:\\JUFE_Second\\Java_Study\\IOTest\\chy.txt" 是否存在，如果存在就删除
    public void m1() {
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\chy.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("删除成功！");
            } else {
                System.out.println("删除失败！");
            }
        } else {
            System.out.println("文件夹不存在...");
        }
    }

    @Test
    //判断 "D:\\JUFE_Second\\Java_Study\\IOTest\\chy.txt" 是否存在，存在就删除，否则提示不存在
    //这里我们需要体会到，在java编程中，目录也被当做文件，可以理解为文件夹
    public void m2() {
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\test";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("删除成功！");
            } else {
                System.out.println("删除失败！");
            }
        } else {
            System.out.println("该目录不存在...");
        }
    }

    @Test
    //判断 "D:\\JUFE_Second\\Java_Study\\IOTest\\test" 目录是否存在，如果存在就提示已经存在，否则就创建
    //创建一级目录使用 mkdir()
    //创建多级目录使用 mkdirs()
    public void m3() {
        String directoryPath = "D:\\JUFE_Second\\Java_Study\\IOTest\\test\\a\\b\\c";
        File file = new File(directoryPath);
        if (file.exists()) {
            System.out.println(directoryPath + "存在");
        } else {
            if(file.mkdirs()){
                System.out.println("该目录创建成功");
            }else{
                System.out.println("该目录创建失败");
            }
        }
    }
}
