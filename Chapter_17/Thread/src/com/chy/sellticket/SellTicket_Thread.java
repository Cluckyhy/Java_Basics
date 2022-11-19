package com.chy.sellticket;

//创建一个线程
public class SellTicket_Thread extends Thread{
    private static int ticketNum = 100;

    @Override
    public void run() {
        while(true){
            if(ticketNum<=0){
                System.out.println("售票结束...");
                break;
            }
            //休眠50毫秒
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("售票员"+Thread.currentThread().getName()+"已经售出一张票"+"剩余票数为："+(--ticketNum));
        }
    }
}
