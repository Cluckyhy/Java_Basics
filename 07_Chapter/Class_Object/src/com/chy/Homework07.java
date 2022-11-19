package com.chy;

import java.util.Scanner;

public class Homework07 {

    public static void main(String[] args) {
        //有个Tom设计他的成员变量，成员方法，可以和电脑猜拳
        //电脑每次都会随机生成0,1,2
        //0表示石头，1表示剪刀，2表示布
        //实例化一个Person对象
        Person2 p1 = new Person2("tom");
        p1.pk(5);
        System.out.println("tom一共赢了" + p1.count + "次");
    }
}

class Person2 {
    int count = 0;
    String name;

    //构造方法
    public Person2(String name) {
        this.name = name;
    }

    //成员方法
    public void pk(int num) {
        int tomnum = 0;
        for (int i = 0; i < num; i++) {
            //定义一个Scanner对象
            Scanner mysc = new Scanner(System.in);
            System.out.println("请tom出拳：");
            tomnum = mysc.nextInt();
            //电脑随机生成0-2的整数
            int computernum = (int) (Math.random() * 2 + 1);
            System.out.println("电脑出的是"+computernum);
            //判断输赢
            if ((tomnum == 0 && computernum == 1) || (tomnum == 1 && computernum == 2) || (tomnum == 2 && computernum == 0)) {
                System.out.println("tom赢了");
                count++;
            } else {
                System.out.println("你输了或为平局");
            }
        }
    }
}
