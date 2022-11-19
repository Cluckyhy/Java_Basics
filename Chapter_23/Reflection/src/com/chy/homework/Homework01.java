package com.chy.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //首先得到PrivateTest的Class对象
        Class<?> cls = Class.forName("com.chy.homework.PrivateTest");
        //创建一个对象
        Object o = cls.newInstance();
        //得到私有name属性
        Field name = cls.getDeclaredField("name");  //name属性是私有的
        //暴破访问私有属性
        name.setAccessible(true);
        //修改私有属性
        name.set(o, "老韩");
        System.out.println("name 的值为：" + name.get(o));
        //得到getName()方法对象
        Method getName = cls.getMethod("getName");
        //因为getName是public 所以直接调用
        System.out.println("姓名为：" + getName.invoke(o));
    }
}

class PrivateTest {
    private String name = "hellokitty";

    public String getName() {
        return name;
    }

}
