package com.chy.printstream;

import java.io.IOException;
import java.io.PrintStream;

/*
演示PrintStream(字节打印流/输出流)

 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {

        PrintStream out = System.out;
        //在默认情况下，PrintStream 输出数据的位置是  标准输出，即显示器
        /*
            public void print(String s){
                if(s == null){
                    s == "null"
                }
                write(s);
            }
         */
        out.println("Hello World");
        //因为print底层使用的是 write()方法， 所以我们可以直接调用write进行打印/输出
        out.write("好好学习，chy".getBytes());
        out.close();

        //我们可以去修改打印流输出的位置/设备
        //1、输出修改成到 "D:\JUFE_Second\Java_Study\IOTest\note.txt"
        //Hello World 就会输出到 上面文件下
        System.setOut(new PrintStream("D:\\JUFE_Second\\Java_Study\\IOTest\\note.txt"));
        System.out.println("Hello World123");
    }
}
