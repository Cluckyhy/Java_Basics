package com.poly_.detail_;

public class PolyDetail02 {
    public static void main(String[] args) {
        //属性没有重写之说！属性的值看编译类型
        Base base = new Sub();
        System.out.println(base.count);//返回
        //方法不一样
        base.eat();//返回Sub吃东西

        //instanceof比较操作符，用于判断对象的运行类型是否为XXX类型或XXX类型的子类型
        System.out.println(base instanceof Base);   //因为base的运行类型是Sub，Sub是Base的子类，所以返回true
        System.out.println(base instanceof Sub);    //因为base的运行类型是Sub，Sub是Sub类型，所以返回true
    }
}

class Base{
    int count = 10;
    public void eat(){
        System.out.println("Base吃东西");
    }
}
class Sub extends Base{
    int count = 20;
    public void eat(){
        System.out.println("Sub吃东西");
    }
}
