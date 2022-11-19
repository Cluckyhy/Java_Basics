package com.chy.test;

public class Test {
    public static void main(String[] args) {
        Dog bai = new Dog("小白", 2);
        bai.say("拉拉");
    }
}

class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void say() {
        System.out.println("我是无参方法");
    }

    public void say(String str) {
        System.out.println("我是String有参方法，参数为：" + str);
    }

    public void say(int num) {
        System.out.println("我是Int有参方法，参数为：" + num);
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

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void say(int num) {

    }
}
