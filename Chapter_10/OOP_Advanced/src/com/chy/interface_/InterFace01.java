package com.chy.interface_;

public class InterFace01 {
    public static void main(String[] args) {
        //创建手机对象
        Phone phone = new Phone();
        //创建相机对象
        Camera camera = new Camera();
        //创建电脑对象
        Computer computer = new Computer();
        computer.work(phone);
        System.out.println("--------------");
        computer.work(camera);
    }
}
