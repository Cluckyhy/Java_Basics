package com.chy.codeblock.codeblockdetail05;

public class Hasqi extends Dog {
    //静态属性
    private static int n5 = getVal05();

    //静态代码块
    static {
        System.out.println("Hasqi的静态代码块被执行...");           //(6)
    }

    //普通属性
    private int n6 = getVal06();

    //普通代码块
    {
        System.out.println("Hasqi的普通代码块被执行...");           //(14)
    }

    //Hasqi的构造方法
    public Hasqi() {
        //隐藏了
        //其实这之前，会伴随着类的加载，执行静态代码块和属性的有关操作
        //super();
        //普通代码块和属性
        System.out.println("Hasqi的构造方法被执行...");             //(15)
    }

    //getVal05()方法
    public static int getVal05(){
        System.out.println("getVal05()被执行...");                 //(5)
        return 500;
    }

    //getVal06()方法
    public int getVal06(){
        System.out.println("getVal06()被执行...");                 //(13)
        return 600;
    }

}
