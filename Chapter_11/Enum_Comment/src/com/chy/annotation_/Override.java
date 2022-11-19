package com.chy.annotation_;

public class Override {
    public static void main(String[] args) {
        /*
        @Override 表示指定重写父类的方法，(从编译层面验证)，如果父类没有fly方法，则报错
        如果不写@Override注解，而父类仍有 public void fly(){}，仍然构成重写
        @Override只能修饰方法，不能修饰其他类，包，属性，等等
        查看@Override注解源码为@Target(ElementType.METHOD)，说明只能修饰方法
        @Target是修饰注解的注解，称为元注解
         */
    }
}

class Father{
    public void fly(){
        System.out.println("Father fly...");
    }
}

class Son extends Father{

    //1、@Override 注解放在fly方法上，表示类的fly方法时重写了父类的fly
    //2、这里没有写@Override 还是重写了父类的fly
    //3、如果你写了@Override 编译器就会去检查方法是否真的重写了父类的方法，
    //      如果的确重写了，则编译通过，如果没有构成重写，则编译错误
    @java.lang.Override
    public void fly() {
        super.fly();
    }
}