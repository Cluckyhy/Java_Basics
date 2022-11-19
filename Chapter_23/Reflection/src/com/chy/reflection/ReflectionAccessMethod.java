package com.chy.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//演示通过反射调用方法
public class ReflectionAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //1、得到Boss类对应的Class对象
        Class<?> boosClass = Class.forName("com.chy.reflection.Boss");
        //2、创建一个对象
        Object o = boosClass.newInstance();
        //3、调用public的hi方法
        //3.1、得到hi方法对象
        Method hi = boosClass.getMethod("hi", String.class);
        //3.2、调用
        hi.invoke(o, "老韩");
        //4、调用private static 方法
        //4.1、得到say方法对象
        Method say = boosClass.getDeclaredMethod("say", int.class, String.class, char.class);
        //4.2、因为say方法是private 所以需要暴破
        say.setAccessible(true);
        System.out.println(say.invoke(o, 18, "老韩", '男'));
        //4.3、因为say方法是static的，所以还可以这样调用，可以传入null，如果不是静态的不可以
        System.out.println(say.invoke(null, 100, "王妞", '女'));

        //返回值，在反射中方法有返回值，统一返回Object，但是他的运行类型和方法定义的返回类型一致
        Object reVal = say.invoke(null, 300, "王五", '男');
        System.out.println(reVal.getClass());   //String
    }
}

class Boss {
    public int age;
    private static String name;

    public Boss() {

    }

    private static String say(int n, String s, char c) {    //静态方法，私有
        return n + " " + s + " " + c;
    }

    public void hi(String s) {
        System.out.println("hi" + s);
    }
}
