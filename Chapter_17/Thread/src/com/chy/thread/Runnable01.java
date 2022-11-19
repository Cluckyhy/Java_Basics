package com.chy.thread;


/*
由于java是不支持多继承的，所以当一个类继承了某个父类后，就不能再去继承Thread类了，所以这时候要让此类作为线程
就可以通过实现Runnable接口类来创建一个线程

下面就是通过实现Runnable接口来创建线程
 */
public class Runnable01 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.start();      //这里dog里面没有start()方法

        //创建Thread对象，把dog对象(实现了Runnable)，放入Thread，这里就是通过Thread代理创建一个线程，但是功能还是Dog自己的逻辑
        Thread thread = new Thread(dog);
        thread.start();
    }
}

//Runnable接口中就只有一个run()抽象方法
class Dog implements Runnable{

    int count = 0;

    @Override
    public void run() {     //普通方法
        while(true){
            System.out.println("小狗汪汪叫 hi"+(++count)+ Thread.currentThread().getName());

            //需要休眠一下，否则由于执行速度太快，一下就结束了
            //休眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}
