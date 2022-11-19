package com.chy.printstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
演示 PrintWriter 使用方式
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {

        //PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(new FileWriter("D:\\JUFE_Second\\Java_Study\\IOTest\\note.txt"));
        printWriter.print("hi 北京你好！");
        printWriter.close();
    }
}
