package com.poly_.objectpoly;

public class ObjectPoly {
    public static void main(String[] args) {
        //体验多态的特点
        //1、一个对象的编译类型和运行类型可以不一致
        //2、编译类型在定义对象时，就确定了，不能改变
        //3、运行类型是可以变化的
        //4、编译类型看定义时 = 号的左边，运行类型看 = 号的右边

        //animal 编译类型就是Animal ,运行类型 Dog
        Animal animal = new Dog();
        //因为运行时，执行到该行时，animal运行类型就是Dog，所以cry()就是Dog的cry
        animal.cry();   //小狗汪汪叫

        //animal 编译类型 Animal ，运行类型就是Cat
        animal = new Cat();
        animal.cry();   //小猫喵喵叫
    }
}
