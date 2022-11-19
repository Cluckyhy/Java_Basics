package com.chy.thread;

public class Thread_Vs_Runnable {
    public static void main(String[] args) {
        /*
        1、从java的设计看，通过继承Thread或者实现Runnable接口创建线程本质上没有区别，从jdk帮助文档我们
           可以看到Thread类本身就实现了Runnable接口
        2、实现Runnable接口的方式更加适合多个线程共享一个资源的情况，并且避免了单继承的限制
        3、建议使用Runnable接口来创建一个线程
         */
    }
}
