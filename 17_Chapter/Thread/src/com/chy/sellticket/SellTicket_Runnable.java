package com.chy.sellticket;

public class SellTicket_Runnable implements Runnable{

    private int ticketNum = 100;

    @Override
    public void run() {
        while(true){
            if(ticketNum<0){
                System.out.println("售票结束...");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("售票员"+Thread.currentThread().getName()+"已经售出一张票，还剩票数为："+(--ticketNum));
        }
    }
}
