package com.chy;

public class Object01 {
    public static void main(String[] args) {
        //实例化一只猫对象
        Cat cat1 = new Cat();
        cat1.name = "小白";
        cat1.age = 2;
        cat1.color = "白色";
        System.out.println(cat1.name);
        System.out.println(cat1.age);
        System.out.println(cat1.color);
        //创建了第二只猫
        Cat cat2 = new Cat();
        cat2.name = "小花";
//        System.out.println(cat2.age);
        cat2.eat();
    }
}

class Cat {
    //成员属性
    String name;//名字
    int age;//年龄
    String color;//颜色

    //成员方法
    public void eat() {
        System.out.println("我叫：" + this.name + "。我喜欢吃鱼!");
    }
}