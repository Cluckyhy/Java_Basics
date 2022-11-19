package com.chy.reflection.question;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
反射这样的需求在学习框架时特别多，即通过外部文件配置，在不修改源码的情况下，来控制程序
也符合设计模式的ocp原则(开闭原则：不修改源码，扩容功能)
 */

@SuppressWarnings({"all"})
//反射问题的引入
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //根据配置文件，re.properties 指定信息，创建Cat对象并调用方法hi
        //传统的方法    new 对象 -->  调用方法
        //Cat cat = new Cat();
        //cat.hi();     --->>   cat.cry() 修改源码

        //我们尝试做一做 -->  明白反射

        //1、使用Properties 类，可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\JUFE_Second\\Java_Study\\JavaCode\\JavaSE\\Chapter_23\\Reflection\\src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println("classfullpath = " + classfullpath);
        System.out.println("method = " + methodName);

        //2、创建对象    传统的方法解决不了，行不通  -->  反射机制可以
        //Cat cat = new com.chy.Cat();    //new classfullpath (X)
        //cat.hi();

        //3、使用反射机制解决
        //(1)加载类，返回Class类型的对象
        Class cls = Class.forName(classfullpath);
        //(2)通过 cls 对象得到你加载的类 com.chy.Cat 的对象实例
        Object o = cls.newInstance();
        System.out.println("o 的运行类型是：" + o.getClass()); //运行类型
        //(3)通过 cls 得到你加载的类 com.chy.Cat 的 methodName "hi" 的方法对象
        //   即：在反射机制中，可以把方法视为对象(万物皆对象)
        Method method1 = cls.getMethod(methodName);
        //(4)通过method1 调用方法：即通过方法对象来实现调用方法
        System.out.println("-----------------------------");
        method1.invoke(o);  //传统方法，对象.方法()，但是在反射机制中是  方法.invoke(对象)

    }
}
