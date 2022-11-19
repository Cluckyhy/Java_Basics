package com.chy.classload;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/*
反射机制是java实现动态语言的关键，也就是通过反射实现类的动态加载。
1、静态加载：编译时加载相关的类，如果没有则报错，依赖性太强
2、动态加载：运行时加载需要的类，如果运行时不用该类，即使不存在该类，则不报错，降低了依赖性

类加载的时机
1、当创建对象时(new)   (静态加载)
2、当子类被加载时，父类也加载     (静态加载)
3、调用类中的静态成员时(静态加载)
4、通过反射  (动态加载)
 */
public class ClassLoad01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入key");
        String key = scanner.next();

        /*
        因为new Tiger()是静态加载，因此必须编写Dog
        Person类是动态加载，所以，没有编写Person类也不会报错，只有当动态加载到该类时才会报错

         */

        switch(key){
            case "1":
                //没有Tiger类，会报错
                Tiger tiger = new Tiger();      //静态加载，依赖性很强
                tiger.cry();
                break;
            case "2":
                //反射--> 动态加载
                Class<?> cls = Class.forName("com.chy.Person");     //加载Person类[动态加载]
                Object o = cls.newInstance();
                Method m = cls.getMethod("hi");
                m.invoke(o);
                break;
            default:
                System.out.println("Do nothing");
                break;
        }
    }
}

class Tiger{
    public void cry(){
        System.out.println("老虎嗷嗷叫...");
    }
}
