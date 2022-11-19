package com.chy.homework;

public class Homework03 {
    public static void main(String[] args) {
        //输入一个姓名：
        String name = "Chen hui Yi";
        //String name = "Chen hui";
        PrintName(name);
    }

    /*
    编写方法：完成输出格式要求的字符串
    编写java程序，输出形式为：Chen hui Yi的人名，以H.Yi @Cheng 的形式打印出来

    (1)对输入的字符串进行 分割split(" ");
    (2)对得到的String[] 进行格式化 String format()
    (3)对输入的字符串进行校验即可
     */

    //编写一个方法
    public static void PrintName(String name) {
        if (name == null) {
            System.out.println("name 不能为空");
            return;
        }
        String[] s = name.split(" ");
        if (s.length != 3) {
            System.out.println("输入的字符串格式不正确！");
            return;
        }
        String format = String.format("%c.%s @%s", s[1].toUpperCase().charAt(0), s[2], s[1]);
        System.out.println(format);
    }
}

