package com.chy.thread_method;

import java.awt.*;

/*
1、yield(让步)：线程的礼让，让出cpu，让其它线程执行，但礼让的时间不确定，所以不一定成功
   根据内核态的资源是否紧张决定的，如果资源非常丰富，就可能不需要礼让
2、join(插队)：线程的插队，插队的线程一旦成功，则肯定先执行完插入的线程所有的任务，再执行当前线程
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();
        for (int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程(小弟) 吃了" + i + "个包子");
            if (i == 5) {
                System.out.println("老大你先吃...");
                //join线程插队
                //t2.join();        //这里相当于让t2 线程先执行完毕
                Thread.yield();     //礼让，不一定成功...
            }
        }
    }
}

class T2 extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程(老大) 正在吃" + i + "个包子..");
        }
    }
}
