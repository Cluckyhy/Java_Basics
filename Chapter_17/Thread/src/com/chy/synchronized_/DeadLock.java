package com.chy.synchronized_;

import org.w3c.dom.ls.LSOutput;

public class DeadLock {
    public static void main(String[] args) {
        //模拟死锁现象
        DeadLockDemo A = new DeadLockDemo(true);
        A.setName("线程A");
        DeadLockDemo B = new DeadLockDemo(false);
        B.setName("线程B");
        A.start();
        B.start();
    }
}

class DeadLockDemo extends Thread{

    static Object o1 = new Object();
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        //1、如果flag 为 T，线程A 就会先得到/持有 o1对象锁，然后尝试去获取 o2 对象锁
        //2、如果线程A 得不到 o2对象锁，就会Blocked
        //1、如果flag 为 F，线程A 就会先得到/持有 o2对象锁，然后尝试去获取 o1 对象锁
        //2、如果线程A 得不到 o1对象锁，就会Blocked
        if(flag){
            synchronized (o1){
                System.out.println(Thread.currentThread().getName() + " 进入1");
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName()+ " 进入2");
                }
            }
        }else{
            synchronized (o2){
                System.out.println(Thread.currentThread().getName() + " 进入3");
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName()+ " 进入4");
                }
            }
        }
    }
}
