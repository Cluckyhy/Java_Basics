package com.chy.codeblock.codeblockdetail06;

public class CodeBlockDetail01 {
    public static void main(String[] args) {

        /*
        * 静态代码块只能直接调用静态成员(静态属性和静态方法)，普通代码块可以调用任意成员
        * */
        Test test = new Test();
    }
}

class Test{
    private int n1 = 100;

    private static int n2 = 200;

    private void m1(){

    }

    private static void m2(){

    }

    static{
        //静态代码块，只能调用静态成员
        //System.out.println(n1);       //ERROR
        //System.out.println(n2);       //OK
        //m1();                         //ERROR
        //m2();                         //OK
    }

    {
        //普通代码块
        System.out.println(n1);         //OK
        System.out.println(n2);         //OK
        m1();                           //OK
        m2();                           //OK
    }
}
