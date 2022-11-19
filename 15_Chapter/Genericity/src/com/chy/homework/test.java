package com.chy.homework;

public class test {
    public static void main(String[] args) {
        Usb a = new AA();
        LL l = (LL) a;
        l.ll();

    }
}

interface Usb {
    void run();
}

interface LL {
    void ll();
}

class AA implements Usb, LL {
    public void say() {
        System.out.println("我是自己的方法");
    }

    @Override
    public void run() {
        System.out.println("我是实现了Usb接口的类！");
    }

    @Override
    public void ll() {
        System.out.println("这是ll");
    }
}

class BB extends AA {
    public void f() {
        System.out.println("我是BB类");
    }
}