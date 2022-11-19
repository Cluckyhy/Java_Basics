package com.chy.reflection;

import java.lang.reflect.Field;

public class ReflectionAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //1、得到Student类对应的 Class对象
        Class<?> stuClass = Class.forName("com.chy.reflection.Student");
        //2、创建一个对象
        Object o = stuClass.newInstance();  //o 的运行类型就是Student
        System.out.println(o.getClass());   //Student
        //3、使用反射得到age，属性对象
        Field age = stuClass.getField("age");
        age.set(o, 99);  //通过反射来操作属性
        System.out.println(o);
        System.out.println(age.get(o));
        //4、使用反射操作name 属性
        //4.1、方法一
        Field name = stuClass.getDeclaredField("name");
        //对name 进行暴破，可以操作private 属性
        name.setAccessible(true);
        name.set(o,"老韩");
        System.out.println(o);
        //4.2、方法二
        name.set(null,"小成"); //因为name是static 属性，因此 o 也可以写成null
        System.out.println(o);
        System.out.println(name.get(o));    //获取属性值
        System.out.println(name.get(null)); //获取属性值，要求name是static
    }
}

class Student {  //类
    public int age;
    private static String name;

    public Student() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age + "  name=" + name +
                '}';
    }
}
