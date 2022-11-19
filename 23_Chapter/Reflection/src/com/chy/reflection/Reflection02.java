package com.chy.reflection;

import com.chy.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
反射优点和缺点
1、优点：可以动态的创建和使用对象(也框架底层核心),使用灵活，没有反射机制，框架即使就失去了底层的支撑
2、缺点：使用反射基本是解释执行，对执行速度有影响。

反射调用的优化，关闭访问检查
1、Method和Field、Constructor对象都有setAccessible()方法
2、setAccessible作用是启动和禁用访问安全检查的方法
3、参数值为true表示反射的对象在使用时取消访问检查，提高反射的效率，参数值为false则表示反射的对象执行访问检查
 */

//测试反射调用的性能，和优化方案
public class Reflection02 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        m1();
        m2();
        m3();
    }

    //传统的方法来调用hi

    public static void m1(){
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("m1() 耗时："+(end - start));
    }

    //反射机制调用方法hi
    public static void m2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class cls = Class.forName("com.chy.Cat");
        //得到一个对象实例
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            hi.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("m2() 耗时："+(end - start));
    }

    //反射调用的优化， =  关闭访问检查
    public static void m3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class cls = Class.forName("com.chy.Cat");
        //得到一个对象实例
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");
        hi.setAccessible(true);             //在反射调用方法时，取消访问检查
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            hi.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("m2() 耗时："+(end - start));
    }
}
