package com.chy.improve;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class Generic02 {
    public static void main(String[] args) {
        /*
        使用泛型：(好处)
        1、编译时，检查添加元素的类型，提高了安全性
        2、减少了类型转换的次数，提高效率

        不使用泛型：
        Dog --加入--> Object  --取出--> Dog //放入到ArrayList 会转换成Object，在取出时，还需要转换为Dog
        使用泛型：
        Dog --> Dog --> Dog 放入时和取出时，不需要类型转换，提高效率

        3、不在提示编译警告
         */
        //使用传统的方法来解决获取Dog的name属性
        //1、当我们 ArrayList<Dog> 表示存放到 ArrayList 集合中的元素是Dog类型
        //2、如果编译器发现添加的类型，不满足要求，就会报错，相当于添加了一个约束进去
        //3、在遍历的时候，可以直接取出 Dog 类型，而不是 Object
        //4、public class ArrayList<E> {} E称为泛型，那么 Dog -> E
        ArrayList<Dog> arrayList = new ArrayList<Dog>();
        arrayList.add(new Dog("旺财",2));
        arrayList.add(new Dog("小花",1));
        arrayList.add(new Dog("大黄",3));
        //假如程序员，不小心，添加了一直猫
        //arrayList.add(new Cat("招财猫",4));  //ERROR

        System.out.println("--------使用泛型---------");
        for (Dog dog : arrayList) {
            System.out.println(dog.getName() + " " + dog.getAge());
        }

    }
}

class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Cat{
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}