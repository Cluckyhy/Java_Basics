package com.chy.generic_extends;

import java.util.ArrayList;
import java.util.List;

public class GenericExtends {
    public static void main(String[] args) {
        /*
        泛型是不具备继承关系的
         */

        Object o =  new String("xx");

        //泛型没有继承性
        //List<Object> list = new ArrayList<String>();  //ERROR

        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<AA> list3 = new ArrayList<>();
        ArrayList<BB> list4 = new ArrayList<>();
        ArrayList<CC> list5 = new ArrayList<>();

        //如果是List<?> c，可以接收任意的泛型类型
        printCollection1(list1);        //OK
        printCollection1(list2);        //OK
        printCollection1(list3);        //OK
        printCollection1(list4);        //OK
        printCollection1(list5);        //OK

        //printCollection2(list1);        //ERROR
        //printCollection2(list2);        //ERROR
        printCollection2(list3);        //OK
        printCollection2(list4);        //OK
        printCollection2(list5);        //Ok

        printCollection3(list1);        //OK
        //printCollection3(list2);        //ERROR
        printCollection3(list3);        //OK
        //printCollection3(list4);        //ERROR
        //printCollection3(list5);        //ERROR

    }

    //编写几个方法
    //List<?> 表示 任意的泛型类型都可以接收
    public static void printCollection1(List<?> c){
        for (Object obj : c) {      //统配符，取出时，就是Object
            System.out.println(obj);
        }
    }

    // ? extends AA 表示 上限，可以接收  AA 或者 AA子类
    public static void printCollection2(List<? extends AA> c){
        for (Object obj : c) {
            System.out.println(obj);
        }
    }

    // ? super 子类类名AA:支持AA类以及AA类的父类，不限于直接父类
    // 规定了泛型的下限
    public static void printCollection3(List<? super AA> c){
        for (Object obj : c) {
            System.out.println(obj);
        }

    }
}

class AA{

}
class BB extends AA{

}
class CC extends BB{

}
