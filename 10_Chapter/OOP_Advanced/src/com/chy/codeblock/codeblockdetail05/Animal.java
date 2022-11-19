package com.chy.codeblock.codeblockdetail05;

public class Animal {
    //静态属性初始化
    private static int n1 = getVal01();

    //静态代码块
    static {
        System.out.println("Animal 的静态代码块被执行...");        //(2)
    }

    //普通属性初始化
    private int n2 = getVal02();

    //普通代码块
    {
        System.out.println("Animal 的普通代码块被执行...");         //(8)
    }

    public Animal() {
        //隐藏了
        //其实这之前，会伴随着类的加载，执行静态代码块和属性的有关操作
        //super();
        //普通代码块和属性
        System.out.println("Animal 的构造方法被执行...");          //(9)
    }

    //getVal01()方法
    public static int getVal01(){
        System.out.println("getVal01被执行...");                   //(1)
        return 100;
    }

    //getVal02()方法
    public int getVal02(){
        System.out.println("getVal02被执行...");                   //(7)
        return 200;
    }
}
