package com.test.pkg1;

public class Person{
    //成员属性
    public String name;
    protected int age;
    double score;
    private double salary;
    //成员方法

    public Person(){
        System.out.println("我是Person的无参构造函数");
    }
    public Person(String name){
        System.out.println("我是有参构造器！"+name);
    }
    public Person(String name,int age){
        System.out.println("我是有参构造器！"+name);
    }
    public void showinfo(){
        System.out.println("我是public方法");
    }
}
