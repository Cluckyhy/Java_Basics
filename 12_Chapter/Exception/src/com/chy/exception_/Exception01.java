package com.chy.exception_;

public class Exception01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        //num1 / num2 => 10 / 0
        //当执行到 num1 / num2 因为 num2 = 0，程序就会出现(抛出异常) ArithmeticException
        //当抛出异常后，程序就崩溃了，下面的代码就不会再执行了
        //大家想想，这样的程序好吗？不好，不应该出现一个不算致命的问题，就导致整个系统崩溃
        //java设计者，提供了一个叫，异常处理机制来解决问题
        //如果程序员，认为一段代码可能出现异常/问题，可以使用try-catch异常处理机制来解决
        //从而保证程序的健壮性
        //将该代码块 --> 选中 --> 快捷键 --> 选中 try-catch
        //如果进行了异常处理，那么即使出现了异常，程序可以继续执行，而不是使整个程序崩溃！！
        int result;
        //运行时异常
        try {
            result = num1 / num2;
        //} catch (Exception e) {
        //    //e.printStackTrace();
        //    System.out.println("出现异常的原因是："+e.getMessage());//输出异常信息
        //    result = 10;
        }finally {
            System.out.println("我最后还是出来了，嘻嘻");
        }
        System.out.println(result);
        System.out.println("程序继续执行...");
    }
}
