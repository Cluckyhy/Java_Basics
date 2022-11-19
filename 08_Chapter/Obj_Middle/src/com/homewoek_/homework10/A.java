package com.homewoek_.homework10;

public class A {
    public A(){
        System.out.println("我是A类");
    }
    public A(int age){
        System.out.println("我是A类的有参构造");
    }
}

class B extends A{
    public B(){
        System.out.println("我是B类的无参构造");
    }
    public B(String name){
        System.out.println(name+"我是B类的有参构造");
    }
}

class C extends B{
    public C(){
        this("hello");  //注意这里调用了this()本类的构造函数，就不会出现super()，
                        // 因为this和super水火不容，不能同时出现在同一个构造方法中
        System.out.println("我是C类的无参构造");
    }
    public C(String name){
        super("hahaha");
        System.out.println("我是C类的有参构造");
    }
}
