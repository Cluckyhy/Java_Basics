package com.chy.standard;

import java.util.Scanner;

public class InputAndOutput {
    public static void main(String[] args) {
        /*
        标准输入输出流
        System.in 标准输入流   InputStream    键盘
        System.out 标准输出流  PrintStream    显示屏
         */

        /*
        System 类的 public final static InputStream in = null;
        System.in 的编译类型是 InputStream
        System.in 的运行类型是 BufferedInputStream
        标准输入    键盘
         */
        //class java.io.BufferedInputStream
        System.out.println(System.in.getClass());

        /*
        System.out 类的 public final static PrintStream out = null;
        System.out 的编译类型是 PrintStream
        System.out 的运行类型是 PrintStream
        表示标准输出  显示器
         */
        //class java.io.PrintStream
        System.out.println(System.out.getClass());

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容：");
        String next = scanner.next();
        System.out.println("next："+next);
    }
}
