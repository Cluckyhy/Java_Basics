package com.chy.enum_;

public class EnumExercise01 {
    public static void main(String[] args) {
        Gender boy = Gender.BOY;
        Gender boy2 = Gender.BOY;
        System.out.println(boy);    //输出BOY，本质就是调用Gender的父类Enum的toString()方法，返回一个名字
        System.out.println(boy == boy2);    //true
    }
}

enum Gender{
    BOY,GIRL;
}
