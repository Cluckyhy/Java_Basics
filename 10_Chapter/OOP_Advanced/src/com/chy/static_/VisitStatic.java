package com.chy.static_;

public class VisitStatic {
    public static void main(String[] args) {
        //类名.类变量名
        //说明：类变量是随着类的加载而创建，所以即使没有创建对象实例也可以访问
        System.out.println(A.name);
        //System.out.println(A.age);    //报错
        //当然也可以通过一个对象实例来访问类变量
        A a = new A();
        //但是，不是很推荐
        System.out.println(a.name);
    }
}

class A{
    //定义一个类变量
    public static String name = "陈慧亿";

    //类变量的访问，必须要遵守相关的访问权限
    private static int age = 19;

    //普通属性/普通成员变量/非静态变量/非静态属性/实例变量
    private int num = 10;
}
