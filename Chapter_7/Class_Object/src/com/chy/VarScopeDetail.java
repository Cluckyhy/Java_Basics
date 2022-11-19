package com.chy;

public class VarScopeDetail {
    public static void main(String[] args) {
        /*
        *属性生命周期较长，伴随着对象的创建而创建，伴随着对象的销毁而销毁
        * 局部变量，生命周期较短，伴随着它的代码块的执行而创建
        * 伴随着代码块的结束而销毁，即在一次方法调用过程中
        * */
        Person1 p1 = new Person1();
        p1.Say();//当执行Scy方法时，Say方法的局部变量比如name会创建，当Say执行完毕后
        //name局部变量就销毁，但是属性(全局变量)仍然可以使用
    }
}

class Person1{
    String name = "chy";
    public void Say(){
        //细节：属性和局部变量可以重名，访问时遵循就近原则
        //但是在同一个方法中，变量不能重名
        String name = "uu";
        System.out.println("say() name =" + name);
    }
}