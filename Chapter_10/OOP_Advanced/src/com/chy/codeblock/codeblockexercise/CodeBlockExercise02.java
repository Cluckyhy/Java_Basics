package com.chy.codeblock.codeblockexercise;

public class CodeBlockExercise02 {
    public static void main(String[] args) {
        Test test = new Test();//无参构造函数
    }
}

class Sample {

    //普通代码块
    {
        System.out.println("我是Sample的普通代码块...");            //(3)       //(7)       //(10)
    }

    //普通属性
    private int n1 = getVal01();

    //静态代码块
    static{
        System.out.println("我是Sample的静态代码块");               //(1)
    }

    //静态属性
    private static int n2 = getVal02();

    public Sample() {
        //隐藏了
        //其实这之前，是伴随着类的加载，先执行静态代码块和属性的有关操作
        //super();
        //普通代码块和属性
        System.out.println("Sample的默认构造方法被调用");                                     //(12)
    }

    Sample(String s) {
        //隐藏了
        //其实这之前，是伴随着类的加载，先执行静态代码块和属性的有关操作
        //super();
        //普通代码块和属性
        System.out.println(s);
    }

    public int getVal01(){
        System.out.println("getVal01()方法被执行...");               //(4)       //(8)       //(11)
        return 100;
    }

    public static int getVal02(){
        System.out.println("getVal02()方法被执行...");               //(2)
        return 200;
    }
}

class Test{
    Sample sam1 = new Sample("sam1成员初始化");                                  //(9)
    static Sample sam2 = new Sample("静态成员sam2初始化");           //(5)
    Sample sam3 = new Sample();
    //静态代码块
    static{
        System.out.println("static块执行...");                      //(6)
        if(sam2 == null){
            System.out.println("sam2 is null");
        }
    }
    //构造方法
    public Test() {
        //隐藏了
        //其实这之前，是伴随着类的加载，先执行静态代码块和属性的有关操作
        //super();
        //普通代码块和属性
        System.out.println("Test默认构造函数被调用");                                        //(13)
    }
}
