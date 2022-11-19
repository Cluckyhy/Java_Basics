package com.chy.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//演示通过反射机制创建实例
public class ReflectionCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //1、先获取到User类的Class对象
        Class<?> userCls = Class.forName("com.chy.reflection.User");
        //2、通过public的无参构造器创建实例
        Object o = userCls.newInstance();
        System.out.println(o);
        //3、通过public的有参构造器创建实例
        /*
        constructor 就是
        public User(String name){
            this.name = name;
        }
         */
        //先得到对应的构造器，在通过构造器创建实例
        Constructor<?> constructor = userCls.getConstructor(String.class);
        Object lala = constructor.newInstance("拉拉");
        System.out.println(lala);
        //4、通过非public的有参构造器创建实例
        //先得到private 的构造器对象
        Constructor<?> constructor1 = userCls.getDeclaredConstructor(int.class, String.class);
        //创建实例
        //暴破【暴力破解】  使用反射机制可以访问private构造器，反射面前，都是纸老虎
        constructor1.setAccessible(true);
        Object rose = constructor1.newInstance(19, "Rose");
        System.out.println(rose);
    }
}

class User{ //User类
    private int age = 10;
    private String name = "陈慧亿";

    public User(){

    }

    public User(String name){
        this.name = name;
    }

    private User(int age,String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
