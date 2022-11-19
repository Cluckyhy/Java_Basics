package com.chy.generic;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})
public class GenericDetail01 {
    public static void main(String[] args) {
        /*
        1、给泛型指向数据的类型是要求 是引用类型，不能是基本数据类型
        2、在给泛型指定具体类型后，可以传入该类型或者其子类类型
        3、当泛型指定的是一个接口类型时，也可以传入一个实现了接口类型的具体对象
        4、泛型的使用形式：
            List<Integer> list1 = new ArrayList<Integer>();
            List<Integer> list2 = new ArrayList<Integer>();
            //在实际开发中，我们往往简写
            //编译器会进行类型推断，推荐使用下面的写法
            ArrayList<Integer> list3 = new ArrayList<>();
            List<Integer> list4 = new ArrayList<>();
        5、如果是这样写，泛型的默认是 Object
            ArrayList arrayList = new ArrayList();  等价于-->  ArrayList<Object> arrayList = new ArrayList<>();
         */

        ArrayList<Integer> integers = new ArrayList<>();    //OK
        //ArrayList<int> ints = new ArrayList<int>();       //ERROR

        //说明：
        //因为 E 指定了 A类型，构造器传入了 new A()
        Pig<A> aPig = new Pig<A>(new A());
        aPig.f();
        Pig<A> aPig2 = new Pig<A>(new B());
        aPig2.f();

        //泛型的使用形式：
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        //在实际开发中，我们往往简写
        //编译器会进行类型推断，推荐使用下面的写法
        ArrayList<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();

        //如果是这样写，泛型的默认是 Object
        ArrayList arrayList = new ArrayList();  //等价于-->  ArrayList<Object> arrayList = new ArrayList<>();

        Tiger tiger = new Tiger();
        /*
        相当于
        class Tiger<E>{
            Object e;

            public Tiger(){}

            public Tiger(Object e) {
                this.e = e;
            }
        }
         */
    }
}

class Tiger<E>{
    E e;

    public Tiger(){}

    public Tiger(E e) {
        this.e = e;
    }
}

class A{

}

class B extends A{

}

class Pig<E>{
    E e;

    public Pig(E e) {
        this.e = e;
    }

    public void f(){
        System.out.println(e.getClass());
    }
}
