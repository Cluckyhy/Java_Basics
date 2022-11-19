package com.extend_test;

public class ExtendsTheory {
    public static void main(String[] args) {
        Son son = new Son();
        //这时，请大家注意，要按照查找关系来返回信息
        //1、首先要看子类是否有该属性
        //2、如果子类中有这个属性，并且可以访问，则返回信息
        //3、如果子类没有这个属性，就看父类有没有这个属性(如果父类有该属性，并且可以访问，则返回信息)
        //4、如果父类没有就按照(3)的规则，继续找上一级父类，直到Object...
        System.out.println(son.name);//返回大头儿子
//        System.out.println(son.age);//返回40
        System.out.println(son.getAge());
        System.out.println(son.hobby);//篮球
    }
}

class GrandPa{
    String name = "大头爷爷";
    String hobby = "篮球";
    int age = 100;
}
class Father extends GrandPa{
    String name = "大头爸爸";
    private int age = 40;

    public int getAge() {
        return age;
    }
}
class Son extends Father{
    String name = "小头儿子";
}
