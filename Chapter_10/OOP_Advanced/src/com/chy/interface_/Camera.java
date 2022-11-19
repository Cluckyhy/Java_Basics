package com.chy.interface_;


//实现接口里面的抽象方法
//要使用此接口必须按规范来
public class Camera implements UsbInterface{
    @Override
    public void start() {
        System.out.println("相机开始工作...");
    }

    @Override
    public void stop() {
        System.out.println("相机停止工作...");
    }
}
