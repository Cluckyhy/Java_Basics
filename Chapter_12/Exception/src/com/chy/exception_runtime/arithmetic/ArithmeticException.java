package com.chy.exception_runtime.arithmetic;

public class ArithmeticException {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        int result;
        //运行时异常
        try {
            result = num1 / num2;
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("出现异常的原因是："+e.getMessage());//输出异常信息
            result = 10;
        }
        System.out.println(result);
        System.out.println("程序继续执行...");
    }
}
