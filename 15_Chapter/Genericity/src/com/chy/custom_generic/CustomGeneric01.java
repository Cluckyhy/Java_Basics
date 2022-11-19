package com.chy.custom_generic;

import java.util.Arrays;

public class CustomGeneric01 {
    public static void main(String[] args) {
        Tiger<Double, String, Integer> ti = new Tiger<>("John");
        ti.setT(10.3);  //OK
        //ti.setT("yy");//ERROR
        System.out.println(ti);
        Tiger rose = new Tiger("Rose");     //Ok T = Object  R = Object  M = Object;
        rose.setT("yy");                    //Ok 因为 T = Object "yy"是String 是 Object的子类
        System.out.println(rose);
    }
}

/*
1、Tiger 后面的泛型，所以我们把 Tiger 称为自定义泛型类
2、T R M 泛型的标识符，一般是单个大写字母
3、泛型的标识符可以有多个
4、普通成员可以使用泛型(属性、方法)
5、在使用泛型的数组中不能初始化
6、静态属性/方法中不能使用类的泛型，原因是，静态属性和静态方法是不依赖于对象的，而是在创建对象前，也就是加载类的时候，就需要确定好数据的类型
   如果是泛型，就无法确定数据的类型，而会报错
7、泛型类的类型，是在创建对象时确定的(因为创建对象时，需要指定确定类型)
8、如果创建对象时，没有指定类型，默认是Object
 */
class Tiger<T,R,M>{
    String name;
    R r;        //属性使用泛型
    M m;
    T t;

    //因为数组在new 的时候不能确定 T 的类型，就无法在内存开空间
    T[] ts;                     //OK
    //T[] ts = new T[8];        //ERROR

    //因为静态是和类相关的，在类的加载时，对象还没有创建
    //所以：如果静态方法和静态属性使用泛型，JVM就无法完成初始化
    //static R r2;
    //public static void m1(M m){       //ERROR
    //
    //}
    public Tiger(String name){}

    public Tiger(String name, R r, M m, T t) {
        this.name = name;
        this.r = r;
        this.m = m;
        this.t = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public R getR() {
        return r;               //返回类型可以是泛型
    }

    public void setR(R r) {     //方法使用泛型
        this.r = r;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", r=" + r +
                ", m=" + m +
                ", t=" + t +
                ", ts=" + Arrays.toString(ts) +
                '}';
    }
}
