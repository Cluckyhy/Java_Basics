package com.chy.homework;

public class Homework01 {
    public static void main(String[] args) {
        //定义一个字符串
        String str = "abcdefghijk";
        System.out.println("-----交换前的字符串------");
        System.out.println(str);
        try {
            str = reserve(str, 1, str.length() - 2);
            //str = reserve(str, 1, 45);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("-----交换后的字符串------");
        System.out.println(str);
    }

    //定义一个静态转换方法
    public static String reserve(String str, int start, int end) {
        //因为String类型的str，里面的值是final修饰的，不能改str里面的值
        //所以需要把String类型str里面的数据转换为char[] 类型

        //对输入的参数做一个验证
        //重要的编程技巧!!!
        //(1) 写出正确的情况
        //(2) 然后取反即可
        //(3) 这样写，你的思路就不乱
        if (!(str != null && start >= 0 && start < end && end < str.length())) {
            throw new RuntimeException("参数不正确！");
        }
        char[] chars = str.toCharArray();
        //拿到str里面的值后，进行交换
        //定义一个临时接收的变量
        char temp = ' ';
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        //交换完毕后，再把char[]类型的数据转换为String类型之后返回出去
        //String strRe = new String(chars);
        return new String(chars);
    }
}
