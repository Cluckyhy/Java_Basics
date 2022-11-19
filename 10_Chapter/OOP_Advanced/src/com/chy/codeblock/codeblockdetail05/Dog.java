package com.chy.codeblock.codeblockdetail05;

public class Dog extends Animal{
    //静态属性
    private static int n3 = getVal03();

    //静态代码块
    static{
        System.out.println("Dog的静态代码块被执行...");            //(4)
    }

    //普通属性
    private int n4 = getVal04();

    //普通代码块
    {
        System.out.println("Dog的普通代码块被执行...");            //(11)
    }

    //Dog的构造方法

    public Dog() {
        //隐藏了
        //其实这之前，会伴随着类的加载，执行静态代码块和属性的有关操作
        //super();
        //普通代码块和属性
        System.out.println("Dog的构造方法被执行...");              //(12)
    }

    //getVal03()方法
    public static int getVal03(){
        System.out.println("getVal03()被执行...");                 //(3)
        return 300;
    }

    //getVal04()方法
    public int getVal04(){
        System.out.println("getVal04()被执行...");                 //(10)
        return 400;
    }
}
