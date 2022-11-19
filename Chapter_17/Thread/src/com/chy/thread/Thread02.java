package com.chy.thread;

public class Thread02 {
    public static void main(String[] args) {
        One one = new One();
        Thread thread = new Thread(one);
        thread.start();
        Two two = new Two();
        Thread thread1 = new Thread(two);
        //注意这里也可以传一个one进去，实现了两个线程共享一个资源，
        //意思就是one里面的run()任务，由两个人来干，效率会更高一点
        thread1.start();
    }
}

//创建第一个线程
class One implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hello world" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}

class Two implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hi" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}
