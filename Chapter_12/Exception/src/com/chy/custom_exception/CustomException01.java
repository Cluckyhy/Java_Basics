package com.chy.custom_exception;

public class CustomException01 {
    public static void main(String[] args) {
        /*
        1、定义类：自定义异常类名(程序员自己写)继承Exception或RuntimeException
        2、如果继承Exception，属于编译异常
        3、如果继承RuntimeException，属于运行异常(一般来说，继承RuntimeException)
         */

        int age = 189;
        //要求范围在 18--120 之间，否则抛出一个自定义异常
        if (!(age >= 18 && age <= 120)) {
            //这里我们可以通过构造器，设置自定义信息
            throw new AgeException("年龄需要在 18~120之间");
        }
        System.out.println("你的年龄范围正常。");
    }
}

//自定义一个异常
//一般情况下，我们自定义异常继承 RuntimeException
//即把自定义异常做成 运行时异常，好处是，我们可以使用默认处理机制
//主要是比较方便
class AgeException extends RuntimeException {
    public AgeException(String message) {//构造器
        super(message);
    }
}
