package com.chy.custominterface_generic;

public class CustomInterfaceGeneric {
    public static void main(String[] args) {
        /*
        interface 接口名<T,R...>{
        }
        1、接口中，静态成员也不能使用泛型(这个和泛型类规定一样)
        2、泛型接口中的类型中，在继承接口或者实现接口时确定
        3、没有指定类型，默认是Object
         */
    }
}

interface IUsb<U, R> {
    int n = 10;
    //U name;       ERROR，因为在接口中的属性其实是 public static final，既然是静态的，所以不可以使用泛型

    //普通方法中，可以使用接口泛型
    R get(U u);

    void hi(R r);

    //在jdk8中，可以在接口中，使用默认方法，也是可以使用泛型
    default R method(U u) {
        return null;
    }
}

//在继承接口，指定泛型接口的类型
interface IA extends IUsb<String, Double> {

}

//当我们去实现IA接口时，因为IA在继承IUsb接口时，指定了 U-->String R--> Double
//因此在实现IUsb接口方法时，使用String 替换U，使用Double 替换R
class AA implements IA{

    @Override
    public Double get(String s) {
        return null;
    }

    @Override
    public void hi(Double aDouble) {

    }
}

//实现接口时，直接指定泛型接口的类型
//给U 指定了Integer  给R 指定了Float
//所以当我们去重写方法时，会使用Integer替换U，使用Float替换R
class BB implements IUsb<Integer,Float>{

    @Override
    public Float get(Integer integer) {
        return null;
    }

    @Override
    public void hi(Float aFloat) {

    }
}

//没有指定类型，默认是Object 等价于 class CC implements IUsb<Object,Object>
class CC implements IUsb{

    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public void hi(Object o) {

    }
}
