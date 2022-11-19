package com.chy.homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //1、利用Class类的forName方法得到File类的class对象
        Class<?> fileCLs = Class.forName("java.io.File");
        //2、得到所有的构造器
        Constructor<?>[] declaredConstructors = fileCLs.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("File构造器：" + declaredConstructor);
        }
        //3、指定得到 public java.io.File(java.lang.String)
        Constructor<?> declaredConstructor = fileCLs.getDeclaredConstructor(String.class);
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\mynew.txt";
        Object file = declaredConstructor.newInstance(filePath);   //创建了File对象了
        //4、得到createNewFile 的方法
        Method createNewFile = fileCLs.getMethod("createNewFile");
        //file的运行类型就是File
        System.out.println(file.getClass());
        //创建文件，调用的是createNewFile
        createNewFile.invoke(file);
        System.out.println("创建文件成功" + filePath);

    }
}
