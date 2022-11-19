package com.chy.thread_state;

/*
1、NEW  -->  在线程创建完后，调用start()方法之前
2、Runnable  -->  调用start()方法之后，进入可运行状态：(可分为两种)
    2.1、Ready -->  就绪状态
    2.2、Runnable  -->  运行状态
3、TIME_WAITING  -->  超时等待  -->调用Thread.sleep(mill)
4、WAITING  -->  等待状态  -->  调用join()方法
5、BLOCKED  -->  阻塞状态  -->  等待进入同步代码块的锁
6、TERMINATED  -->  终止状态
 */

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        System.out.println(t.getName() + "当前的状态为：" + t.getState());
        t.start();

        while (Thread.State.TERMINATED != t.getState()) {
            System.out.println(t.getName() + "状态：" + t.getState());
            Thread.sleep(1000);
        }

        System.out.println(t.getName() + "状态：" + t.getState());
    }
}

class T extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hi" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}
