package com.chy.synchronized_;

//创建一个线程
public class SellTicket_Thread extends Thread {
    private static int ticketNum = 100;
    private static boolean loop = true;    //控制run方法的变量

    //利用继承Thread方式创建的线程，使用同步方法的话，需要用static修饰，因为如果创建多个对象，这个方法也是不同的
    //synchronized修饰的方法，为的就是只创建一块内存，再让三个线程共同处理
    //如果使用继承Thread方式创建的线程这里的同步方法没有使用static，那么用这个类创建的三个线程都有属于自己的
    //sell()方法，这样也达不到同步效果，还是会出现超卖现象
    //一定要注意，同步方法一定是，多个线程共同处理一个共享的内存
    //如果sell()方法不是静态的，利用该类创建的三个对象，相当于有三把锁，所以还是可以各自进入自己的sell方法
    //这样就还是会导致超卖，没有达到同步

    //同步方法(静态的) 的锁为当前类本身
    //public synchronized static void sell() {} 锁是加在 SellTicket_Thread.class
    public synchronized static void sell() {
        if (ticketNum <= 0) {
            System.out.println("售票结束...");
            loop = false;
            return;
        }
        //休眠50毫秒
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("售票员" + Thread.currentThread().getName() + "已经售出一张票" + "剩余票数为：" + (--ticketNum));
    }

    public static void m2(){
        synchronized (/*this*/ SellTicket_Thread.class) {
            System.out.println("m2()");
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();     //同步方法，在同一时刻，只能有一个线程来执行run()方法
        }
    }
}
