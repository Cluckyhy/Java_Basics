package com.chy.string;

public class StringExercise04 {
    public static void main(String[] args) {
        String a = "hello";     //创建a对象
        String b = "abc";       //创建b对象

        //问：下面创建了几个对象？
        //一共有三个对象
        String c = a + b;
        //关键就是要分析 String c = a + b;到底是如何执行的
        //1、先创建一个 StringBuilder sb = StringBuilder()
        //2、执行 sb.append("hello")
        //3、执行 sb.append("abc")
        //4、String s = sb.toString()
        //5、最后其实是 c 指向堆中的对象(String) value[] -> 池中的 "helloabc"
        //6、底层是 StringBuilder sb = new StringBuilder(); sb.append(a);
        //      sb.append(b); sb是在堆中，并且append是在原来字符串的基础上追加的
        //      重要规则：String c1 = "ab" + "cd";常量相加，看到是池，
        //      Strting c1 = a + b; 变量相加，是堆中
        String d = "helloabc";
        System.out.println(c == d);     //false

        String e = "hello" + "abc";
        System.out.println(d == e);     //true
        System.out.println(c == e);     //false
    }
}
