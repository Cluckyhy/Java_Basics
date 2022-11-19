package com.chy.single_;

import javax.xml.catalog.Catalog;

public class SingleTon02 {
    public static void main(String[] args) {

        // 单例模式  ---->  懒汉式     ---> 存在线程安全问题
        //步骤
        //1、仍然构造器私有化
        //2、定义一个static静态属性对象
        //3、提供一个public的static方法，可以返回一个Cat对象
        //4、懒汉式，只有当用户使用getInstance时，才返回cat对象，后面再次调用时，会返回上次创建的cat对象
        //   从而保证了单例

        //new Cat("大黄");

        //System.out.println(Cat.n1);

        Cat instance1 = Cat.getInstance();
        System.out.println(instance1);
        Cat instance2 = Cat.getInstance();
        System.out.println(instance2);

        System.out.println(instance1.equals(instance2));

    }
}

//希望在程序运行过程中，只能创建一个Cat对象
//使用单例模式
class Cat{

    private String name;
    public static int n1 = 999;

    private static Cat cat;

    private Cat(String name) {
        System.out.println("构造器被执行...");
        this.name = name;
    }

    public static Cat getInstance(){
        if(cat == null){
            cat = new Cat("小花");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
