package com.chy.codeblock;

public class CodeBlockDetail03 {
    public static void main(String[] args) {
        //构造器的最前面其实隐含了 super() 和 调用普通代码块，
        //静态相关的代码块，属性初始化，在类加载时，就执行完毕，因此优先于构造器和普通代码块执行的

        BBB bbb = new BBB(); //(1) AAA() 普通代码块被调用  (2) AAA() 构造器被调用  (3)BBB 的普通代码块..  (4)BBB() 构造器被调用
    }
}

class AAA{

    {
        System.out.println("AAA 的普通代码块");
    }

    public AAA() {
        //1、隐藏了一个super
        //super();
        //2、隐藏了本类的普通代码块
        System.out.println("AAA() 构造器被调用");
    }
}

class BBB extends AAA{

    {
        System.out.println("BBB 的普通代码块..");
    }

    public BBB() {
        //1、隐藏了一个super
        //super();
        //2、隐藏了本类的普通代码块
        System.out.println("BBB() 构造器被调用");
    }
}
