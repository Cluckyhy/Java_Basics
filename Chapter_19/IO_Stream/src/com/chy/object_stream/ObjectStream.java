package com.chy.object_stream;

public class ObjectStream {
    public static void main(String[] args) {
        /*
        对象流 -->  ObjectInputStream 和 ObjectOutputStream

        看一个需求：
        1、将 int num = 100 这个int 数据保存到文件中，注意不是100数字，而是 int 100，并且，能够从文件中直接恢复int 100
        2、将Dog dog = new Dog("小黄,3) 这个dog对象 保存到文件中，并且能够从文件恢复
        3、上面的要求，就是能够将 基本数据类型 或者 对象 进行序列化 和 反序列化操作
         */

        /*
        序列化和反序列化
        1、序列化就是在保存数据时，保存数据的值和数据类型
        2、反序列化就是恢复数据时，恢复数据的值和数据类型
        3、需要让某个对象支持序列化机制，则必须让其类是可序列化的，为了让某个类是可序列化的，该类必须实现如下两个接口之一：
            serializable    //这是一个标记接口，没有方法
            Externalizable  //该接口有方法需要实现，因此我们一般实现上面的 serializable 接口
         */

    }
}
