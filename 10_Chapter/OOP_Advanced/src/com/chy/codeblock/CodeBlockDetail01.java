package com.chy.codeblock;

public class CodeBlockDetail01 {
    public static void main(String[] args) {
        //static代码块也叫静态代码块，作用就是对类的初始化，而且它是随着类的加载而执行，并且
        //只会执行一次，因为类只会加载一次，如果是普通代码块，每创建一个对象，就会执行一次


        //类被加载的情况举例
        //1、创建对象实例的时候(new)
        //AA aa = new AA();

        //2、创建子类对象实例，父类也会被加载
        //而且，父类先被加载，子类后加载
        //BB bb = new BB();

        //3、使用类的静态成员时(静态属性，静态方法)
        //System.out.println(Cat.age);

        //类只加载一次，所以静态代码块也只执行一次，static代码块，是在类加载时，执行的，而且只会执行一次
        //DD dd = new DD();
        //DD dd1 = new DD();

        //普通代码块，在创建对象实例时，会被隐式的调用
        //被创建一次，就会调用一次
        //如果只是使用类的静态成员时，普通代码块不会被执行
        //System.out.println(DD.name);    //普通代码块没有执行
        DD dd = new DD();
        System.out.println(DD.name);
    }
}

class DD{

    public static String name = "慧亿";

    //静态代码块
    static {
        System.out.println("DD 静态代码块1被执行...");
    }

    //普通代码块，在new对象时，被调用，而且是每创建一个对象，就调用一次
    //和类是否被加载没有关系，可以简单理解为：普通代码块是构造器的补充，如果构造器被调用，那么普通代码块也随着调用
    {
        System.out.println("DD 的普通代码块...");
    }
}


class Animal{

    //静态代码块
    static{
        System.out.println("Animal 的静态代码块1被执行...");
    }
}

class Cat extends Animal{
    public static int age =19;  //静态属性

    //静态代码块
    static{
        System.out.println("Cat 的静态代码块1被执行...");
    }
}

class AA{

    //静态代码块
    static{
        System.out.println("AA 的静态代码块1被执行...");
    }
}

class BB extends AA{

    //静态代码块
    static{
        System.out.println("BB 的静态代码块1被执行...");
    }
}
