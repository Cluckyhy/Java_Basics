package com.chy.generic;

import java.util.List;

public class Generic03 {
    public static void main(String[] args) {
        /*
        泛型的作用是：可以在类声明时通过一个标识表示类中某个属性的类型
        或者是某个方法的返回值的类型，或者是参数类型
        注意：特别强调：E具体的数据类型在定义Person对象的时候指定，即在编译期间，即确定E是什么类型
         */
        //Person<int> chy = new Person<int>("chy");
        /*
           泛型不能是基本类型，必须是引用类型
         */
        Person<Integer> person1 = new Person<>(100);
        person1.Show();
        Person<String> ming = new Person<>("小明");
        ming.Show();
        System.out.println(person1.f1());
        System.out.println(ming.f1());
    }
}

class Person<E>{
    //E 表示 s的数据类型，该数据类型在定义Person对象时候指定，即在编译期间，即确定E是什么类型
    E s;

    public Person(E s) {    //E 也可以是参数类型
        this.s = s;
    }

    public E f1(){          //E 也可以是返回类型
        return s;
    }

    public void Show(){
        System.out.println(s.getClass());
    }
}
