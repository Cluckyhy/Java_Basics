package com.homewoek_.homework09;

public class Person {
    private String name;
    private char sex;
    private int age;
    private String hobby;

    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    //成员方法
    public String play(){
        return name+"爱玩";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void info(){
        System.out.println("姓名："+name);
        System.out.println("年龄："+age);
        System.out.println("性别："+sex);
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
