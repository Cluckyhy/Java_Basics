package com.chy.homework;

public class Homework02 {
    public static void main(String[] args) {
        Extractor extractor = new Extractor();
        //创建两个线程
        Thread t1 = new Thread(extractor);
        Thread t2 = new Thread(extractor);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}

//创建一个线程类，利用实现Runnable接口创建
class Extractor implements Runnable {

    private int money = 10000;

    @Override
    public void run() {
        while (true) {
            //1、这里使用了 synchronized 实现了线程同步
            //2、当多个线程执行到这里时，就会去 争夺this这把锁
            //3、哪个线程争夺到(获取)this对象锁，就执行 synchronized 代码块，执行完后，会释放this对象锁
            //4、争夺不到this对象锁的，就blocked，准备继续争夺
            //5、this对象锁是非公平锁，有可能争夺到锁的是同一个线程
            synchronized (this) {
                //int num = (int) (Math.random() * 1000 + 1);
                //System.out.println(Thread.currentThread().getName()+"想取走"+num+"块钱");
                //if(money <= num ){
                //    System.out.println("你的存款不够，请重新选择取款金额...");
                //    break;
                //}
                //money -= num;
                //System.out.println(Thread.currentThread().getName() + "取出了" + num + "块钱，余额为：" + money);
                if(money <= 0 ){
                    System.out.println("你的存款不够，请重新选择取款金额...");
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + "取出了" + 1000 + "块钱，余额为：" + money);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
