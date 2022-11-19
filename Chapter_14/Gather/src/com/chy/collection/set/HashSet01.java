package com.chy.collection.set;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"all"})
public class HashSet01 {
    public static void main(String[] args) {
        /*
        HashSet 可以存放null，但是只能有一个为null，即元素不能重复
         */
        /*
        1、在执行add方法后，会返回一个boolean值
        2、如果添加成功，返回true，否则会返回false
        3、可以通过 remove 指定删除哪个对象
         */
        Set set = new HashSet();
        System.out.println(set.add("John"));    //T
        System.out.println(set.add("lucy"));    //T
        System.out.println(set.add("John"));    //F
        System.out.println(set.add("jack"));    //T
        System.out.println(set.add("Rose"));    //T
        set.remove("John");
        System.out.println("set = " + set);     //3个顺序不保证和存放的顺序一致


        //HashSet 不能添加相同的元素/数据？
        set = new HashSet();
        set.add("lucy");        //添加成功
        set.add("lucy");        //加入不了
        set.add(new Dog("tom"));    //Ok
        set.add(new Dog("tom"));    //Ok
        System.out.println("Set = " + set);

        //再加深一下，非常经典的面试题
        //看原码，做分析
        //去看他的源码，即 add 到底发生了什么？ ==> 底层机制
        set.add(new String("chy")); //Ok
        set.add(new String("chy")); //加入不了
        System.out.println(set);

    }
}

class Dog {     //定义一个Dog类
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
