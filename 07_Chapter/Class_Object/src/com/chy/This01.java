package com.chy;

public class This01 {
    public static void main(String[] args) {
        Dog d1 = new Dog("大狗", 2);
        d1.info();
    }
}

class Dog {
    String name;
    int age;

    //如果我们构造器的形参，能够直接写成属性名，就更好了
    //但是出现了一个问题，根据变量的作用域原则
    //构造器的name 就是局部变量，而不是属性，所以根本就没有把用户传过来的值赋值到属性中
    //构造器的age  就是局部变量，而不是属性
    //所以要用this关键字来解决问题
    public Dog(String name, int age) {
//        name = name;
//        age = age;
        //this.name 就是当前对象的属性name
        //this.age  就是当前对象的属性age
        this.name = name;
        this.age = age;
    }

    public void info() {
        //而这里我们使用的name和age又是调用的属性中的值
        System.out.println("name =" + name + "\tage =" + age);
    }
}
