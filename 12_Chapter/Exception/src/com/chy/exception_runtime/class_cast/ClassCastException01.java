package com.chy.exception_runtime.class_cast;

public class ClassCastException01 {
    public static void main(String[] args) {
        //当试图将对象强制转换为不是实例的子类时，抛出异常
        A a = new B();  //向上转型
        B b = (B)a;//向下转型，这里是ok
        //C c = (C)b; //Error，这里抛出ClassCastException

    }
}

class A{}
class B extends A{}
class C extends A{}
