package com.chy.thread;

/*
模拟静态代理模式，也可以说模拟Thread
 */
public class Proxy_Thread {
    public static void main(String[] args) {
        //通过静态代理模式创建一个线程
        Tiger tiger = new Tiger();
        //tiger.start();    //由于tiger里面没有start()方法，所以可以通过有start方法的类来代理启动一下start()方法
        ProxyThread proxyThread = new ProxyThread(tiger);
        proxyThread.start();
    }
}

class ProxyThread implements Runnable{

    private Runnable target = null;

    public ProxyThread(Runnable target) {
        this.target = target;
    }

    @Override
    public void run() {
        if(target != null){
            target.run();       //动态绑定(运行类型是 Tiger)
        }
    }

    public void start(){
        start0();
    }

    public void start0(){
        run();
    }
}

class Animal{}

class Tiger extends Animal implements Runnable{

    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫...");
    }
}
