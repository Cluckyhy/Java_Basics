package com.homewoek_.homework11;

public class Homework11 {
    public static void main(String[] args) {
        /*
        *多态：方法或对象具有多种形态，是OOP的第三大特征，是建立在封装和继承基础之上
        * 多态的具体体现
        * 1、方法的多态
        *   1.1、重载体现的多态，1.2、重写体现的多态
        * 2、对象的多态
        *   2.1、对象的编译类型和运行类型可以不一致，编译类型在定义时，就确定不能改
        *   2.2、对象的运行类型是可以变化的，可以通过getClass()来查看运行类型
        *   2.3、编译类型看定义时 = 号的左边，运行类型看 = 号的右边
        * */
        AAA obj = new BBB();    //向上转型
        AAA obj2 = obj;
        System.out.println(obj.getClass());     //BBB
        obj = new CCC();        //向上转型
        System.out.println(obj.getClass());     //CCC
        obj = obj2;
        System.out.println(obj.getClass());     //BBB，切换回来了
    }
}

class AAA{
    //超类
}

class BBB extends AAA{
    //子类继承AAA
}

class CCC extends BBB{
    //孙类继承BBB
}
