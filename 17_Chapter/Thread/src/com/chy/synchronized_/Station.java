package com.chy.synchronized_;

public class Station {
    //总票数
    static int ticketNum = 20;

    public static void main(String[] args) {

        //1、使用继承Thread方式，创建线程

        //利用继承Thread方式创建的线程，使用同步方法的话，需要用static修饰，因为如果创建多个对象，这个方法也是不同的
        //synchronized修饰的方法，为的就是只创建一块内存，再让三个线程共同处理
        //如果使用继承Thread方式创建的线程这里的同步方法没有使用static，那么用这个类创建的三个线程都有属于自己的
        //sell()方法，这样也达不到同步效果，还是会出现超卖现象
        //一定要注意，同步方法一定是，多个线程共同处理一个共享的内存
        //如果sell()方法不是静态的，利用该类创建的三个对象，相当于有三把锁，所以还是可以各自进入自己的sell方法
        //这样就还是会导致超卖，没有达到同步

        //SellTicket_Thread window1 = new SellTicket_Thread();
        //SellTicket_Thread window2 = new SellTicket_Thread();
        //SellTicket_Thread window3 = new SellTicket_Thread();
        //window1.start();
        //window2.start();
        //window3.start();

        //2、使用实现Runnable接口，创建线程

        //利用实现Runnable接口创建线程，就没有上面的问题，也不需要把sell()方法定义为static
        //因为本身就是对同一个对象进行操作，也就意味着三个线程在操作同一个内存

        SellTicket_Runnable sell = new SellTicket_Runnable();
        Thread thread1 = new Thread(sell);
        Thread thread2 = new Thread(sell);
        Thread thread3 = new Thread(sell);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
