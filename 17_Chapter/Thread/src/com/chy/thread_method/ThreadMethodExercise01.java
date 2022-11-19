package com.chy.thread_method;

public class ThreadMethodExercise01 {
    public static void main(String[] args) throws InterruptedException {
        T3 t3 = new T3();
        Thread thread = new Thread(t3);
        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            System.out.println("hi" + i);
            if (i == 5) {
                //启动子线程
                thread.start();
                //子线程先执行完毕后，再执行主线程
                thread.join();
            }
        }
        System.out.println("主线程结束...");
    }
}

//创建一个子线程，利用实现Runnable接口方法
class T3 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello" + i);
        }
        System.out.println("子线程结束...");
    }
}
