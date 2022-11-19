package com.chy.wrapper_exercise;

public class WrapperExercise02 {
    public static void main(String[] args) {

        //----------------------------------
        //两个引用型比较相等，比较的是两个对象是否相等/两个对象的地址是否相等

        //示例1
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2);       //false

        //示例2
        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        System.out.println(i3 == i4);       //false

        //示例3
        Integer i5 = 127;
        Integer i6 = 127;
        System.out.println(i5 == i6);       //true

        //示例4
        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i7 == i8);       //false

        //示例5
        Integer i9 = 127;
        Integer i10 = new Integer(127);
        System.out.println(i9 == i10);      //false


        //--------------------------------------
        //在比较相等时，只要比较对象中有基本数据类型，就是判断值是否相等

        //示例6
        Integer i11 = 127;
        int i12 = 127;
        System.out.println(i11 == i12);     //true

        //示例7
        Integer i13 = 128;
        int i14 = 128;
        System.out.println(i13 == i14);     //true
    }
}
