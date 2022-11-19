package com.poly_.dynamic_;

public class DynamicBinding {
    public static void main(String[] args) {

        /*
        * java的动态绑定机制
        *   1、当调用对象方法的时候，该方法会和该对象的内存地址/运行类型绑定
        *   2、当调用对象属性时，没有动态绑定机制，哪里声明哪里使用，当然也遵守继承机制
        * */

        //a的编译类型是 A，运行类型是 B
        A a = new B();//向上转型
//        System.out.println(a.sum());//40
//        System.out.println(a.sum1());//30

        //当注释了子类中的sum方法后
//        System.out.println(a.sum());//30
//        System.out.println(a.sum1());//30

        //当注释了子类中的sum1方法后
        System.out.println(a.sum());//30
        System.out.println(a.sum1());//20
    }
}

class A {
    public int i = 10;

    public int sum() {
        return getI() + 10;
    }

    public int sum1() {
        return i + 10;
    }

    public int getI() {
        return i;
    }
}

class B extends A {
    public int i = 20;

//    public int sum() {
//        return i + 20;
//    }

    public int getI() {
        return i;
    }

//    public int sum1() {
//        return i + 10;
//    }
}
