package com.chy;

public class Homework05 {
    public static void main(String[] args) {
        //构造器的复用
    }
}

class Employee{
    String name;
    int age;
    char gender;
    String job;
    double sal;

    public Employee(String name,int age){
        this.name = name;
        this.age = age;
    }
    public Employee(char gender, String job, double sal){
        this.gender = gender;
        this.job = job;
        this.sal = sal;
    }
    public Employee(String name,int age,char gender,String job,double sal){
        this(gender,job,sal);//使用到前面的构造器
        this.name = name;
        this.age = age;
    }
}
