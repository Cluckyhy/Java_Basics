package com.chy.thread;

/*
主线程退出，并不一定代表子线程也要退出，只有进程中的所有线程全部退出后，进程才会终止
 */

/*
创建线程有两种方法：
    1、继承Thread类
    2、自定义一个类实现Runnable接口的类，其实Thread也是继承Runnable接口的
    3、可以把这里的Thread01.java文件，当做是一个进程(应用程序)，main是进程中的主线程，在main线程中又启动了一个子线程，
       注意：并不是main线程死掉后，整个程序就退出，而是当进程中的所有线程，不管是哪里启动的线程，都要等所有的线程都结束后，程序才退出
演示通过继承Thread 类创建线程
 */

/*
假设sleep()方法不抛出中断异常，也就是线程没有中断响应能力，会怎么样？
考虑如下场景：

线程A：sleep中

线程B：A别睡了，要关机啦（向A发送中断信号）

线程A：sleep中

这样好吗？这不好。因为线程A对外界情况没有感知能力。

中断就起到了这样的作用：让线程具有感知的能力。sleep(),wait()等方法都需要你去处理中断异常，也就是需要你的代码能够响应中断。
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        //创建一个Cat对象，可以当做线程来使用
        Cat cat = new Cat();
        //启动线程  -->  最终会执行cat的run()方法
        cat.start();
        /*
        (1)
        public synchronized void start() {
            start0();
        }
        (2)
        //start0()是native本地方法，是由JVM调用，底层是c/c++实现
        private native void start0();
        (3)
        真正实现多线程的效果，是start0()，而不是run
         */

        //cat.run();
        //这样调用的话，就是把run()方法当做是main线程中的一个普通方法，并没有真正的启动一个线程，就会把run()方法执行完毕，才向下执行
        //这就变成了串行化
        //如果这里直接调用run()方法，其实并没有启动另外一个子线程，而是在main线程中执行，
        //而且也要等到run()方法执行完毕后，才会执行下面的代码

        //说明：当main线程启动一个子线程 Thread-0，主线程不会阻塞，会继续执行
        //这时，主线程和子线程是交替执行的...
        System.out.println("主线程继续执行："+ Thread.currentThread().getName());   //主线程的名称就叫main
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程 i = " + i);
            //让主线程休眠
            Thread.sleep(1000);
        }
    }
}

//1、当一个类继承了 Thread类，该类就可以当成线程使用
//2、重写run()方法，写上自己的业务代码
//3、run Thread 类，实现了 Runnable接口里面的run()方法
class Cat extends Thread {

    int times = 0;

    @Override
    public void run() {     //重写run方法，写上自己的业务逻辑
        while (true) {
            //该线程每隔1秒，在控制台输出 "喵喵,我是一只小猫咪"
            System.out.println("喵喵，我是一只小喵咪" + (++times) + Thread.currentThread().getName());
            //让线程休眠1秒
            //这里的try-catch是保证该线程在sleep时还是能感知响应，能够响应中断，不会睡死
            //try {
            //    Thread.sleep(2000);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
            if (times == 10) {
                break;      //当times到80后，退出while循环，这时线程也就退出了..
            }
        }
    }
}
