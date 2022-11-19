package com.chy.abstract_.abstractdetail;

public class AbstractDetail01 {
    public static void main(String[] args) {
        /*
        * 抽象类的细节：
        *   1、抽象类不能被实例化
        *   2、抽象类不一定要包含abstract方法，也就是说，抽象方法可以没有抽象方法
        *   3、一旦类包含了abstract方法，则这个类必须声明为abstract
        *   4、abstract 只能修饰类和方法，不能修饰属性和其他
        * */
        //A a = new A();        //不能实例化
    }
}

abstract class A{
    //抽象类不一定要包含abstract方法，也就是说，抽象方法可以没有抽象方法
    //而且还可以有实现的方法
    public void hi(){
        System.out.println("hello");
    }
}

//一旦类包含了abstract方法，则这个类必须声明为abstract
//class B{
//    public abstract void hi();
//}

//abstract 只能修饰类和方法，不能修饰属性和其他
class C{
    //public abstract int n1 = 1;
}


