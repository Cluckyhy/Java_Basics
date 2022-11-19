package com.chy.homework;

import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        a.start();
        b.start();

    }
}

//创建一个线程，利用实现Runnable接口方式
class A extends Thread {

    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            int n = (int) (Math.random() * 100 + 1);
            System.out.println("随机数：" + n);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A线程退出");
    }
}

//创建一个线程
class B extends Thread {
    private A a;
    private Scanner scanner = new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("请输入一个字母Q(代表退出)");
            char c = scanner.next().toUpperCase().charAt(0);
            if(c == 'Q'){
                a.setLoop(false);
                System.out.println("B线程退出");
                break;
            }
        }
    }
}

