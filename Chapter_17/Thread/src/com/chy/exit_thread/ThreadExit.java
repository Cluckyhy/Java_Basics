package com.chy.exit_thread;

public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();

        //如果希望main线程去控制 t 线程的终止，必须可以修改loop
        //让t 退出run方法，从而终止 t线程 -> 通知方式

        //让主线程休眠5秒，再通知 t线程退出
        Thread.sleep(5 * 1000);
        t.setLoop(false);
    }
}

class T extends Thread {
    int count = 0;
    //设置一个控制变量
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程正在运行中..." + (++count));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
