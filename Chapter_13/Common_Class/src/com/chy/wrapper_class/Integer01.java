package com.chy.wrapper_class;

public class Integer01 {
    public static void main(String[] args) {
        /*
        演示int  <-->  Integer 的装箱和拆箱
        jdk5以前是手动装箱和拆箱
        手动装箱：
        基本类型——————————————>包装类型
        int n1 = 10;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1)
        手动拆箱：
        包装类型——————————————>基本类型
        int i = integer.intValue();

        jdk5以后，就可以自动装箱和自动拆箱
        自动装箱：
        int n2 = 20;
        Integer integer2 = n2;      //底层使用的是  Integer.valueOf(n2)
        自动拆箱：
        int n3 = integer2;          //底层使用的是  intValue()方法

        其他包装类的用法类型，不一一举例
         */
    }
}
