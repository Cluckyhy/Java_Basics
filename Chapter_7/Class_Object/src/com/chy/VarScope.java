package com.chy;

public class VarScope {
    public static void main(String[] args) {
        Cat1 c1 = new Cat1();
        c1.hi();
    }
}


//全局变量(属性)可以不赋值，直接只用，因为有默认值，局部变量必须赋值后才能使用，因为没有默认值
//局部变量：也就是除了属性之外的其他变量，作用域为定义它的代码块中

class Cat1{
    //全局变量：也就是属性，作用域为整个类体，Cat1类：cry eat 等方法中都可以使用属性
    //成员属性，属性在定义时，可以直接赋值
    int age = 10;
    double weight;  //默认值是0.0
    public void hi(){
        //局部变量必须赋值后才能使用，因为没有默认值
        int num;
        //报错
//        System.out.println(num);
        System.out.println(weight);
    }
    public void cry(){
        //1、局部变量一般是指在成员方法中定义的变量
        //2、n 和 name 就是局部变量
        //3、n 和 name 的作用域在cry方法中，出了方法就用不了了
        int n = 10;
        String name;
        System.out.println(n);
    }
    public void eat(){
        System.out.println(age);
        //报错
//        System.out.println(n);
    }
}
