package com.chy.abstract_;

public class Abstract01 {
    public static void main(String[] args) {
        //抽象类的引入
        //当父类的某些方法，需要声明，但是又不确定如何实现时，可以将其声明为抽象类方法，那么这个类就是抽象类
        //抽象类是没有方法体的
        //抽象类的价值更多作用是在设计，是设计者设计好后，让其子类继承并实现抽象类
    }
}

abstract class Animal{
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    //思考：这里的eat() 这里你实现了，其实并没有什么意义
    //即，父类方法不确定性的问题
    //===>> 考虑将该方法设计为抽象(abstract)方法
    //===>> 所谓抽象方法就是指没有实现的方法
    //===>> 所谓没有实现就是指，没有方法
    //===>> 当一个类中存在抽象方法时，需要将该类声明为abstract类
    //===>> 一般来说，抽象方法会被继承，由其子类通过重写该抽象方法来实现

    //public void eat(){
    //    System.out.println("这是一个动物，但是不知道吃什么...");
    //}
    public abstract void eat();
}
