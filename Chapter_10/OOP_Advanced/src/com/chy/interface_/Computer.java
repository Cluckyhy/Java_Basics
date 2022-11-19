package com.chy.interface_;

public class Computer {
    //编写一个方法
    //像一个装载设备 --->  像电脑装载了手机等等了设备
    //UsbInterface usbInterface 形参是接口类型 UsbInterface
    //看到 接收 实现了 UsbInterface 接口类的对象实例
    public void work(UsbInterface usbInterface){
        //通过接口，来调用方法
        usbInterface.start();
        usbInterface.stop();
    }
}
