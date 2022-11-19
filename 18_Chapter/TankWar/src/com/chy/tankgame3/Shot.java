package com.chy.tankgame3;

/*
射击子弹
 */
public class Shot implements Runnable {
    int x;  //子弹的x坐标
    int y;  //子弹的y坐标
    int direct = 0; //子弹的方向
    int speed = 2;  //子弹的速度
    boolean isLive = true;  //子弹是否还存活

    //构造器
    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true) {

            //休眠 50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {

            }
            switch (direct) {
                case 0: //上
                    y -= speed;
                    break;
                case 1: //右
                    x += speed;
                    break;
                case 2: //下
                    y += speed;
                    break;
                case 3: //左
                    x -= speed;
                    break;
            }
            //这里我们输出一下(x,y)的坐标
            System.out.println("x = " + x + " y =" + y);
            //当子弹移动到面板的边界时，就应该销毁(把启动的子弹的线程销毁)
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <=750)){
                System.out.println("子弹线程退出");
                isLive = false;
                break;
            }
        }
    }
}
