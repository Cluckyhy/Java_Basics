package com.homewoek_;

public class Homework02 {
    public static void main(String[] args) {
        //写出四种访问修饰符和各自的访问权限
        //访问权限的访问排序
        //public > protected > 默认 > private

        //1、public：访问权限在本类、同包、同包的子类、不同包的子类、不同包 都可以进行访问

        //2、protected：访问权限在
        //              1、子类与基类在同一包中：被声明为 protected 的变量、方法和构造器能被同一个包中的任何其他类访问；
        //              2、子类与基类不在同一包中：
        //                  2.1、那么在子类中，子类实例可以访问其从基类继承而来的 protected 方法，
        //                  2.2、不能访问基类实例的protected方法。

        //3、默认：访问权限
        //只要是在同一个包内，任何类都可访问到默认修饰符修饰的成员，一旦出了包就访问不到了

        //4、private：访问权限
        //private是最严格的访问权限，只能在本类中才能进行访问，出了本类就无法访问了

        //总体而言，就是protected 和 默认比较特殊
        //而他们针对的对象不同。protected针对的是父子类中，默认针对的是包与包
    }
}
