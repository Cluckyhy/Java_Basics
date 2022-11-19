package com.chy.exception_runtime.number_format;

public class NumberFormatException01 {
    public static void main(String[] args) {
        //当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换为适当格式时，抛出该异常 => 使用异常我们
        //可以确保输入是否满足条件数字
        //String name = "1234";
        String name = "chy";
        //将String 转成 int
        int num = 0;
        try {
            num = Integer.parseInt(name);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            num = -1;
            System.out.println(e.getMessage());
        }
        System.out.println(num);    //1234
    }
}
