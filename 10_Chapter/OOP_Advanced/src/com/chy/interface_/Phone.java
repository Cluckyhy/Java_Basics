package com.chy.interface_;

//Phone 类实现 UsbInterface
//即，Phone类需要实现 UsbInterface接口 规定/声明的方法
//要使用此接口必须按规范来
public class Phone implements UsbInterface{
    @Override
    public void start() {
        System.out.println("手机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("手机停止工作");
    }
}
