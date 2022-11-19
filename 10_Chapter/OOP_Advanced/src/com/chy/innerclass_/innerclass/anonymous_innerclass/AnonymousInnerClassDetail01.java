package com.chy.innerclass_.innerclass.anonymous_innerclass;

public class AnonymousInnerClassDetail01 {
    public static void main(String[] args) {
        /*
            匿名内部类的语法比较特殊，请大家注意，因为匿名内部类既是一个类的定义，
            同时它本身也是一个对象，因此从语法上看，它既有定义类的特征，也有创建
            对象的特征，对前面的代码分析可以看出这个特点，因此可以调用匿名内部类方法

            1、可以直接访问外部类的所有成员，包括私有的
            2、不能添加访问修饰符，因为它的地位就是一个局部变量
            3、作用域：仅仅在定义它的方法或代码块中
            4、匿名内部类-->访问-->外部类成员[访问方式：直接访问]
            5、外部其他类-->不能访问-->匿名内部类(因为 匿名内部类地位是一个局部变量)
            6、如果外部类和匿名内部类的成员重名时，匿名内部类访问的话，默认遵循就近原则，
               如果想访问外部类的成员，则可以使用(外部类.this.成员)去访问
         */
        Outer01 outer01 = new Outer01();
        outer01.f1();
        System.out.println(outer01);

    }
}

class Outer01 {
    private int n1 = 99;

    public void f1() {
        //创建一个基于类的匿名内部类
        //不能添加访问修饰符，因为它的地位就是一个局部变量
        //作用域：仅仅在定义它的方法或代码块中
        Person p = new Person() {
            private int n1 = 88;

            @Override
            public void hi() {
                //可以直接访问外部类的所有成员，包括私有的
                System.out.println("匿名内部类重写了 hi 方法" + "n1 = " + n1);
                System.out.println("外部类中的n1 = " + Outer01.this.n1);
                //Outer01.this 就是调用 f1 的对象
                System.out.println("Outer01.this hashcode= " + Outer01.this);
            }
        };
        p.hi();//动态绑定，运行类型是 Outer01$1

        //也可以直接调用   //Outer01$2
        //new Person() {
        //    @Override
        //    public void hi() {
        //        System.out.println("匿名内部类重写了 hi 方法，哈哈哈哈");
        //    }
        //
        //    @Override
        //    public void ok(String name) {
        //        System.out.println("哈哈哈" + name);
        //    }
        //}.ok("Rose");

    }
}

class Person {
    public void hi() {
        System.out.println("Person里面的类方法...");
    }

    public void ok(String name) {
        System.out.println("Person ok()" + name);
    }
}

//抽象类/接口...


