package com.chy.string;

public class StringMethod01 {
    public static void main(String[] args) {
        //1、equals  前面已经讲过了，比较内容是否相同，是区分大小写的
        String str1 = "hello";
        String str2 = "Hello";
        System.out.println(str1.equals(str2));      //false

        //2、equalsIgnoreCase  忽略大小写的判断内容是否相等
        String username = "JOHN";
        if("john".equalsIgnoreCase(username)){
            System.out.println("Success!");
        }else{
            System.out.println("Failure!");
        }

        //3、length 获取字符的个数，字符串的长度
        System.out.println("陈慧亿".length());     //3

        //4、indexOf 获取字符在字符串对象中第一次出现的索引，索引从0开始，如果找不到，返回-1
        String str3 = "chy@terwe@g";
        int index = str3.indexOf('@');

        System.out.println(index);      //3

        //5、lastIndexOf 获取字符串中最后一次出现的索引，索引从0开始，如果找不到返回-1
        String str4 = "chy@terwe@g";
        int index1 = str4.lastIndexOf('@');
        System.out.println(index1);      //9

        //6、substring  截取指定范围的子串
        String str5 = "hello,陈慧亿";
        System.out.println(str5.substring(6));
        //str5.substring(0,3)表示从索引0开始截取，截取到索引
        System.out.println(str5.substring(0,3));
    }
}
