package com.chy.abstract_.abstractdetail;

public class AbstractDetail02 {
    public static void main(String[] args) {
        /*
        *   5、抽象类可以有任意成员，【抽象类本质还是类】，比如非抽象方法，构造器，静态属性等等
        *   6、抽象方法不能后主体
        *   7、如果一个类继承了抽象方法，则它必须实现抽象类中的所有抽象方法，除非它自己也声明为抽象类
        *   8、抽象方法不能使用private、final、static来修饰，因为这些关键字都是和重写相违背的
        * */

    }
}

//抽象类的本质还是类，所以可以有类的各种成员
abstract class D{
    public int n1 = 10;
    public static String name = "陈慧亿";
    public void hi(){
        System.out.println("hi");
    }
    public abstract void hello();
    public static void ok(){
        System.out.println("ok");
    }
}

//如果一个类继承了抽象方法，则它必须实现抽象类中的所有抽象方法，除非它自己也声明为抽象类
abstract class E{
    public abstract void hi();
    public abstract void speak();
    public void eat(){
        System.out.println("吃东西");
    }
}

abstract class F extends E{

}

class G extends E{
    //这里相当于G子类实现了父类的E的所有抽象方法，所谓实现方法，就是要有方法体

    @Override
    public void hi() {

    }

    @Override
    public void speak() {

    }
}

abstract class H{
    //private abstract void hi();           //ERROR
    //public final abstract void hi();      //ERROR
    //public static abstract void hi();     //ERRORS
}
