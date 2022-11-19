package com.chy.codeblock;

public class CodeBlockDetail02 {
    public static void main(String[] args) {

        /*
        * 4、创建一个对象时，在一个类中，调用的顺序是：
        *   4.1、调用静态代码块和静态属性初始化(注意：静态代码块和静态属性初始化调用的优先级一样，如果
        *           有多个静态代码块和多个静态变量初始化，则按他们定义的顺序调用)
        *   4.2、调用普通代码块和普通属性的初始化(注意：普通代码块和普通属性初始化调用优先级一样，如果
        *           有多个普通代码块和普通属性初始化，则按定义顺序调用)
        *   4.3、最后调用构造函数
        * */

        A a = new A();  //先输出  (1)getN1被调用  (2)A 静态代码块01
                        //再输出  (1)getN2被调用  (2)A 普通代码块01
                        //最后输出  A() 无参构造器被调用

    }
}

class A{

    //普通属性初始化
    private int n2 = getN2();

    //静态属性初始化
    private static int n1 = getN1();

    //静态代码块
    static {
        System.out.println("A 静态代码块01");
    }

    public static int getN1(){  //静态方法
        System.out.println("getN1被调用");
        return 100;
    }

    //普通代码块
    {
        System.out.println("A 普通代码块01");
    }

    public int getN2(){ //普通方法
        System.out.println("getN2被调用");
        return 200;
    }

    //无参构造器
    public A(){
        System.out.println("A() 无参构造器被调用");
    }
}
