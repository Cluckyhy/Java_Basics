package com.chy.reflection.class_;


import java.lang.reflect.Field;

/*
演示Class类的常用方法
 */
public class Class02 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String classAllPath = "com.chy.Car";
        //1、获取到Car对应的 Class 对象
        //<?> 表示不确定的Java类型
        Class cls = Class.forName(classAllPath);
        //2、输出cls
        System.out.println(cls);        //显示cls对象，是哪个类的Class对象 com.chy.Car
        System.out.println(cls.getClass());     //输出的是cls运行类型  java.lang.Class
        //3、得到包名
        System.out.println(cls.getPackage().getName()); //包名
        //4、得到全类名
        System.out.println(cls.getName());
        //5、通过cls创建对象实例
        Object car = cls.newInstance();
        System.out.println(car);
        //6、通过反射获取属性
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car)); //宝马，如果这里的brand是私有属性会报错
        //7、通过反射给属性赋值
        brand.set(car,"奔驰");
        System.out.println(brand.get(car));
        //8、希望可以得到所有的属性(字段)
        Field[] fields = cls.getFields();
        for (Field f: fields){

            System.out.println(f.getName()+f.get(car));
        }
    }
}
