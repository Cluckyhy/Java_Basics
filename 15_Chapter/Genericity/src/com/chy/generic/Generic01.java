package com.chy.generic;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class Generic01 {
    public static void main(String[] args) {

        /*
        使用传统的方法
        1、不能对加入到集合 ArrayList中的数据类型进行约束(不安全)
        2、遍历的时候，需要进行类型转换，如果集合中的数据量较大，对效率有影响

        泛型就开始出来了，用泛型可以很好的解决上面的问题
         */

        //使用传统的方法来解决获取Dog的name属性
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Dog("旺财",2));
        arrayList.add(new Dog("小花",1));
        arrayList.add(new Dog("大黄",3));

        //假如程序员，不小心，添加了一直猫
        arrayList.add(new Cat("招财猫",4));        //会抛出异常

        for (Object o : arrayList) {
            //向下转型  Object -->  Dog
            Dog dog = (Dog) o;
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
