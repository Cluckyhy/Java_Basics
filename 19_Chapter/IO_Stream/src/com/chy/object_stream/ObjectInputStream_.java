package com.chy.object_stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //指定反序列化的文件
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\data.dat";

        //创建一个ObjectInputStream对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        //读取(反序列化)的顺序需要和你保存的数据(序列化)的顺序一致
        //否则会报异常

        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());

        /*
        这里特别要注意的细节：
            1、如果我们希望调用Dog的方法，需要向下转型，就需要引用Dog类
            2、需要我们将Dog类的定义，放到可以引用的位置，即如果本类找不到Dog类的话，就会报错
            3、如果Dog类不在同一个包下的话，一定要将Dog设置为 public 这样本类才可以引用到Dog类
         */
        Object dog = ois.readObject();
        System.out.println("运行类型：" + dog.getClass());
        System.out.println(dog);   //底层 Object -->  Dog
        System.out.println("Dog信息：" + dog);

        Dog dog1 = (Dog) dog;
        System.out.println(dog1.getName());

        //关闭流，关闭外层流即可，底层会关闭 FileInputStream 流
        ois.close();
    }
}
