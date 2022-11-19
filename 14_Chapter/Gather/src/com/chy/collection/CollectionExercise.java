package com.chy.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        arrayList.add(new Dog("小白",2));
        arrayList.add(new Dog("小花",4));
        arrayList.add(new Dog("啦啦",1));

        //增强for循环
        for (Object dog : arrayList) {
            System.out.println(dog);
        }

        //使用迭代器
        //首先获得一个迭代器
        System.out.println("-----------使用迭代器输出dog-------------");
        Iterator iterator = arrayList.iterator();
        while(iterator.hasNext()){
            Object dog = iterator.next();
            System.out.println(dog);
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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}