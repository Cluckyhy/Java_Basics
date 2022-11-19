package com.chy.single_;

public class SingleTon01 {
    public static void main(String[] args) {

        //单例模式  --->  饿汉式
        //步骤 --->  [单例模式--饿汉式]     --->  存在资源浪费问题
        //1、将构造器私有化
        //2、在类的内部实现(该对象是static)
        //3、类内部提供一个公共的静态方法，返回gf对象
        //通常我们的对象都是重量级的，饿汉式可能会造成创建了对象，但是没有用，就会浪费

        //GirlFriend girlFriend = new GirlFriend("小红");

        //通过类名调用方法，直接获取一个实例对象
        //GirlFriend girlFriend = GirlFriend.getInstance();
        //System.out.println(girlFriend);
        //GirlFriend girlFriend1 = GirlFriend.getInstance();
        //System.out.println(girlFriend1);
        //
        //System.out.println(girlFriend.equals(girlFriend1));
        System.out.println(GirlFriend.n1);
    }
}

//有一个类，GirlFriend
//只能有一个女朋友
class GirlFriend{
    private String name;

    public static int n1 =100;

    //为了能够在静态方法中返回gf对象，需要将其修饰为static
    private static GirlFriend gf = new GirlFriend("小红红");

    //如何保障我们只能创建一个 GirlFriend 对象

    private GirlFriend(String name) {
        System.out.println("构造器被调用");
        this.name = name;
    }

    public static GirlFriend getInstance(){
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
