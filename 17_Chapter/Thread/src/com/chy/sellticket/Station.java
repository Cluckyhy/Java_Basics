package com.chy.sellticket;

public class Station {
    //总票数
    static int ticketNum = 20;

    public static void main(String[] args) {

        //1、使用继承Thread方式，创建线程
        //SellTicket_Thread window1 = new SellTicket_Thread();
        //SellTicket_Thread window2 = new SellTicket_Thread();
        //SellTicket_Thread window3 = new SellTicket_Thread();
        //window1.start();
        //window2.start();
        //window3.start();

        //2、使用实现Runnable接口，创建线程
        SellTicket_Runnable sell = new SellTicket_Runnable();
        Thread thread1 = new Thread(sell);
        Thread thread2 = new Thread(sell);
        Thread thread3 = new Thread(sell);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
