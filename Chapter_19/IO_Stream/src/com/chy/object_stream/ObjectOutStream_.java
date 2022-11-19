package com.chy.object_stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
演示ObjectOutPutStream的使用，完成数据的序列化
 */
public class ObjectOutStream_ {
    public static void main(String[] args) throws IOException {
        //序列化后，保存的文件格式，不是纯文本，而是按照它的格式来保存
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\data.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        //序列化数据到 "D:\\JUFE_Second\\Java_Study\\IOTest\\data.dat"
        oos.writeInt(100); //int -->  Integer(实现了 Serializable)
        oos.writeBoolean(true); // boolean -> Boolean(实现了 Serializable)
        oos.writeChar('a'); // char -> Character (实现了 Serializable)
        oos.writeDouble(9.3);  //double -> Double (实现了 Serializable)
        oos.writeUTF("陈慧亿");  // String
        //保存一个dog 对象
        oos.writeObject(new Dog("旺财", 3, "日本", "白色"));   //

        oos.close();
        System.out.println("数据保存完毕(序列化形式)");
    }
}

//如果需要序列化某个类的对象，必须实现 Serializable
class Dog implements Serializable {
    private String name;
    private int age;
    //序列化对象时，默认将里面的所有属性都进行序列化，但除了 static 或 transient 修饰的成员
    private static String nation;
    private transient String color;
    //序列化对象时，要求里面属性的类型也需要实现序列化接口
    private Master master = new Master();
    //serialVersionUID 序列化的版本号，可以提高兼容性
    private static final long serialVersionUID = 1L;

    public Dog(String name, int age, String nation, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}' + nation + " "+ master;
    }
}

//因为Dog里面有Master类型的属性，所有要对Dog类进行序列化的话，也要将Master实现Serializable接口，才不会报错
class Master implements Serializable{

}
