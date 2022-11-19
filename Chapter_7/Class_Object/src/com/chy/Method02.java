package com.chy;

public class Method02 {
    public static void main(String[] args) {
        //编写一个方法为copyPerson，可以复制一个person对象，返回复制的对象，克隆对象,
        //注意要求得到的新对象和原来的对象是两个独立的对象，只是他们的属性相同
        //实例化一个人对象
        Person p = new Person();
        p.name = "小包";
        p.age = 10;
        Mytool mt = new Mytool();
        Person pp = mt.copyPerson(p);
        System.out.println(pp.name);
        System.out.println(pp.age);
        System.out.println(p == pp);
    }
}

class Person {
    //成员属性
    String name;
    int age;
    //成员方法
}

class Mytool {
    public Person copyPerson(Person p) {
        Person newp = new Person();
        newp.name = p.name;
        newp.age = p.age;
        return newp;
    }
}