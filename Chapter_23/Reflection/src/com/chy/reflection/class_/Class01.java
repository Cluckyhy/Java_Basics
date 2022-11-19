package com.chy.reflection.class_;

//对Class类特点的梳理
/*
1、Class也是类，因此也继承Object类[类图]
2、Class类对象不是new出来的，而是系统创建的
3、对于某个类的Class类对象，在内存中只有一份，因为类的加载只有一次
4、每个类的实例都会记得自己是由哪个Class实例所生成
5、通过Class可以完整地得到一个类的完整结构，通过一系列的API
6、Class类对象是存放在堆中的
7、类的字节码二进制数据，是放在方法区的，有的地方称为类的元数据(包括 方法代码，变量名，方法名，访问权限等等)
 */


import com.chy.Cat;

public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //Cat cat = new Cat();

        /*
        反射的方式
        ClassLoader类，仍然是通过  ClassLoader 类加载Cat类 的Class类对象
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return loadClass(name, false);
        }
         */
        Class cls1 = Class.forName("com.chy.Cat");
        Class cls2 = Class.forName("com.chy.Cat");

        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());

        Class cls3 = Class.forName("com.chy.Dog");
        System.out.println(cls3.hashCode());

    }
}
