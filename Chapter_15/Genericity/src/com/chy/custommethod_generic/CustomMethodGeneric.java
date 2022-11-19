package com.chy.custommethod_generic;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class CustomMethodGeneric {
    public static void main(String[] args) {
        /*
        修饰符 <T,R...>返回类型 方法名(参数列表){
        }
        1、泛型方法，可以定义在普通类中，也可以定义在泛型类中
        2、当泛型方法被调用时，类型会确定
        3、public void eat(E e){}，修饰符后没有<T,R..> eat方法不是泛型方法，而是使用了泛型
        4、泛型方法，可以使用类声明的泛型，也可以使用自己的声明的泛型
         */

        Car car = new Car();
        car.fly("宝马", 100);  //当调用方法时，传入的参数，编译器，就会确定类型
        System.out.println("---------------");
        car.fly(200, 100.22);

        Fish<String, ArrayList> fish = new Fish<>();
        fish.hello(new ArrayList(), 11.3f);
    }
}

class Car {
    public void run() {

    }

    //1、<T,R> 就是泛型
    //2、是提供给 fly使用
    public <T, R> void fly(T t, R r) {      //泛型方法
        System.out.println(t.getClass());   //Sting
        System.out.println(r.getClass());   //Integer
    }
}

class Fish<T, R> {        //泛型类
    public void swimming() {

    }

    public <U, M> void eat(U u, M m) {         //泛型方法

    }

    //说明：下面不是泛型方法
    //因为在修饰符后面没有使用泛型，下面的代码只是使用了类声明的 泛型
    public void hi(T t) {

    }

    public <K> void hello(R r, K k) {
        System.out.println(r.getClass().getSimpleName());       //ArrayList
        System.out.println(k.getClass().getSimpleName());       //Float
    }
}
