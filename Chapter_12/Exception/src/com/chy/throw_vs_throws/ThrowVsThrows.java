package com.chy.throw_vs_throws;

public class ThrowVsThrows {
    public static void main(String[] args) {
        /*
                    意义                     位置            后面跟的东西
        throws -->  异常处理的一种方式  -->  方法声明处  -->  异常类型
        throw  -->  手动生成异常对象的关键字 方法体中    -->   异常对象
         */
        try {
            ReturnExceptionDemo.methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            ReturnExceptionDemo.methodB();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class ReturnExceptionDemo{
    static void methodA(){
        try {
            System.out.println("进入方法A");
            throw new RuntimeException("我制造的异常A");
        } finally {
            System.out.println("用A方法的finally");
        }
    }
    static void methodB(){
        try {
            System.out.println("进入方法B");
            throw new RuntimeException("我制造了异常B");
        } finally {
            System.out.println("调用B方法的finally");
        }
    }
}
