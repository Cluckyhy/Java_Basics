package com.chy.codeblock;

public class CodeBlockDetail04 {
    /*
    * 我们看一下创建一个子类时(继承关系)，他们的静态代码块，静态属性初始化，普通代码块，普通属性初始化，构造方法的调用顺序如下：
    *   1、父类的静态代码块和静态属性(优先级一样，按定义顺序执行)
    *   2、子类的静态代码块和静态属性(优先级一样，按定义顺序执行)
    *   3、父类的普通代码块和普通属性(优先级一样，按定义顺序执行)
    *   4、父类的构造方法
    *   5、子类的普通代码块和普通属性(优先级一样，按定义顺序执行)
    *   6、子类的构造方法
    * */

    public static void main(String[] args) {
        B01 b01 = new B01();
    }
}

class A01{      //父类

    //静态属性初始化
    private static  int n1 = getVal01();

    //静态代码块
    static{
        System.out.println("A01的静态代码块被执行...");              //(2)
    }

    //普通属性初始化
    private int n2 = getVal02();

    //普通代码块
    {
        System.out.println("A01的普通代码块被执行...");              //(6)
    }

    //A01的构造方法
    public A01() {
        //隐藏了
        //super();
        //普通代码块和属性
        System.out.println("A01的构造方法被执行...");               //(7)
    }

    public static int getVal01(){
        System.out.println("getVal01被执行...");                   //(1)
        return 100;
    }

    public int getVal02(){
        System.out.println("getVal02被执行...");                   //(5)
        return 200;
    }
}

class B01 extends A01{
    //静态属性初始化
    private static int n3 = getVal03();

    //静态代码块
    static{
        System.out.println("B01的静态代码块被执行...");             //(4)
    }

    //普通属性初始化
    private int n4 = getVal04();

    //普通代码块
    {
        System.out.println("B02的普通代码块被执行...");             //(9)
    }

    //B02的构造方法

    public B01() {
        //隐藏了
        //super();
        //普通代码块和属性
        System.out.println("B02的构造方法被执行...");               //(10)
    }

    public static int getVal03(){
        System.out.println("getVal03被执行...");                   //(3)
        return 300;
    }

    public int getVal04(){
        System.out.println("getVal04被执行...");                   //(8)
        return 400;
    }
}


