package com.chy.homework;

import java.io.*;
import java.util.Properties;

public class Homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //先读取到dog.properties中的各属性内容
        //先创建一个Properties类对象
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(filePath));
        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        String color = properties.getProperty("color");
        //创建一个Dog类对象，用上面从dog.properties中读取到的值进行初始化
        Dog dog = new Dog(name, Integer.parseInt(age), color);
        System.out.println(dog);

        //使用ObjectOutputStream对象将dog对象序列化到dog.data文件中
        String dogPath = "D:\\JUFE_Second\\Java_Study\\IOTest\\dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dogPath));
        oos.writeObject(dog);
        //关闭流
        oos.close();

        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dogPath));
        Object o = ois.readObject();
        Dog dog1 = (Dog) o;
        System.out.println("----反序列化----");
        System.out.println(dog1);

    }
}
