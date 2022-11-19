package com.chy.synchronized_;

public class SellTicket_Runnable implements Runnable {

    private int ticketNum = 100;
    private boolean loop = true;

    //1、public synchronized void sell() {} 就是一个同步方法
    //2、这时 锁在 this 对象
    //3、也可以在代码块上写 synchronized，同步代码块，互斥锁还是在this对象
    public /*synchronized*/ void sell() {
        synchronized (this) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("售票员" + Thread.currentThread().getName() + "已经售出一张票，还剩票数为：" + (--ticketNum));
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}
