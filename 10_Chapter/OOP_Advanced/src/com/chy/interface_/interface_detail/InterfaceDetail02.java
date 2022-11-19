package com.chy.interface_.interface_detail;

public class InterfaceDetail02 {
    public static void main(String[] args) {
        /*
         *   5、一个类同时可以实现多个接口
         *   6、接口中的属性，只能是final的，而且是public static final 修饰，比如：
         *       int a = 1，实际上是public static final int a = 1;(必须初始化)
         *   7、接口中属性的访问形式：接口名.属性名
         *   8、接口不能继承其他的类，但是可以继承多个别的接口
         *   9、接口的修饰符，只能是public 和 默认，这点和类的修饰符是一样的
         * */

        //证明有static
        System.out.println(IB.n1);
        //证明有final
        //IB.n1 = 40; //ERROR;  //说明n1是final
    }
}

interface IB {
    //接口中的属性，只能是final的，而且是public static final 修饰，
    int n1 = 10;    //等价于 public static final int n1 = 10;

    void hi();
}

interface IC {
    void say();
}

//一个类可以同时实现多个接口
class Pig implements IB, IC {
    @Override
    public void hi() {

    }

    @Override
    public void say() {

    }
}

//接口不能继承其他的类，但是可以继承多个别的接口
interface ID extends IB, IC {

}

//接口的修饰符，只能是public 和 默认，这点和类的修饰符是一样的
interface IE{

}
