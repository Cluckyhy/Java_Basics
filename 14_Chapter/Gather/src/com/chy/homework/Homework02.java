package com.chy.homework;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings({"all"})
public class Homework02 {
    public static void main(String[] args) {
        //创建多个Car对象
        Car bwm = new Car("宝马", 4000000);
        Car bin = new Car("宾利", 500000);
        Car ao = new Car("奥迪", 390000);
        Car bao = new Car("保时捷", 7000000);
        //创建一个ArrayList对象
        ArrayList list = new ArrayList();
        list.add(bwm);
        list.add(bin);
        list.add(ao);
        list.add(bao);
        System.out.println(list);

        //删除奥迪
        list.remove(ao);
        System.out.println(list);

        //查找元素是否存在
        System.out.println(list.contains(ao));

        //获取元素个数
        System.out.println(list.size());

        //判断是否为空
        System.out.println(list.isEmpty());

        //清空
        list.clear();
        System.out.println(list);

        //添加多个元素
        ArrayList list1 = new ArrayList();
        list1.add(ao);
        list1.add(bao);
        list1.add(bwm);
        list.addAll(list1);
        System.out.println(list);

        //查找多个元素是否存在
        System.out.println(list.containsAll(list1));

        //使用增强for
        for (Object o : list) {
            System.out.println(o);
        }


        System.out.println("-----------使用迭代器-----------");
        //使用迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println(obj);
        }

    }
}

class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
