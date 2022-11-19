package com.chy.interface_.introduce_interface;

//如果一个类 implements实现接口
//需要将该接口的所有抽象方法都实现
public class A implements Interface{
    @Override
    public void hi() {
        System.out.println("hi...");
    }
}
