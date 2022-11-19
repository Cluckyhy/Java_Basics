package com.chy.codeblock;

public class CodeBlock01 {
    public static void main(String[] args) {
        new Movies("你好，李焕英");
        System.out.println("-----------------");
        new Movies("唐探3",100,"陈思成");

    }
}

class Movies{
    private String name;
    private double price;
    private String director;

    //代码块
    //把相同的语句，放入一个代码块中，即可
    //这样我们不管调用哪个构造器，创建对象，都会先执行代码块中的内容
    //代码块调用的顺序优先于构造器..
    {
        System.out.println("电影屏幕打开...");
        System.out.println("广告开始了...");
        System.out.println("电影正式开始...");
    };

    //构造器 --> 重载

    public Movies(String name) {
        System.out.println("Movies(String name) 被调用");
        this.name = name;
    }

    public Movies(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Movies(String name, double price, String director) {
        System.out.println("Movies(String name, double price, String director) 被调用");
        this.name = name;
        this.price = price;
        this.director = director;
    }
}
