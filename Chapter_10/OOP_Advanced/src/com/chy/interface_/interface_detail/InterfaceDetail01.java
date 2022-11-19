package com.chy.interface_.interface_detail;

public class InterfaceDetail01 {
    public static void main(String[] args) {
        /*
        *   1、接口不能被实例化
        *   2、接口中所有的方法是：public 方法，接口中抽象方法，可以不用abstract 修饰
        *   3、一个普通类实现接口，就必须将该接口的所有方法实现
        *   4、抽象类实现接口，可以不用实现接口的方法
        * */
        //new IA();
    }
}

interface IA{
    //其实这里不写public ，默认就是public
    void say();
    void hi();
}

class Cat implements IA{
    @Override
    public void say() {

    }

    @Override
    public void hi() {

    }
}

//允许
abstract class Tiger implements IA{

}
