package com.chy.thread_method;

public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        /*
        1、用户线程：也叫工作线程，当线程的任务执行完毕或通知方式结束
        2、守护线程：一般为工作线程服务的，当所有的用户线程结束，守护线程也就自然结束
        3、常见的守护线程：垃圾回收机制
         */
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        T4 t4 = new T4();
        //如果我们希望当main线程结束后，子线程自动结束
        //只需要将子线程设置为守护线程即可
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();
        for (int i = 1; i <= 5; i++) {
            System.out.println("小松鼠辛苦的在工作...");
            Thread.sleep(1000);
        }
        System.out.println("小松鼠工作结束后...");
        t4.start();
    }
}

class MyDaemonThread extends Thread{
    @Override
    public void run() {
       while(true){     //无限循环
           try {
               Thread.sleep(500);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("我是一只快乐的小松鼠...");
       }
    }
}

class T4 extends Thread{
    @Override  
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("小老虎在辛苦的工作");
        }
        System.out.println("小老虎工作结束...");
    }
}
