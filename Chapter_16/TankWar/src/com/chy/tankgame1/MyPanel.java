package com.chy.tankgame1;

import javax.swing.*;
import java.awt.*;

//坦克大战的绘图区域
public class MyPanel extends JPanel {
    //定义我的坦克
    Hero hero = null;

    public MyPanel() {
        hero = new Hero(100, 100);   //初始化坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);   //默认是黑色

        //画坦克--封装到方法中
        drawTank(hero.getX(), hero.getY(), g, 0, 0);
        //敌人的坦克
        drawTank(hero.getX() + 60, hero.getY(), g, 0, 1);
    }

    //编写方法，画出坦克

    /**
     * @param x      坦克的左上角x坐标
     * @param y      坦克的左上角y坐标
     * @param g      画笔
     * @param direct 坦克的方向(上下左右)
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        //根据不同坦克的类型，设置不同的颜色
        switch (type) {
            case 0: //我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //敌人的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克的方法，绘制不同的坦克
        switch (direct) {
            case 0: //向上
                g.fill3DRect(x, y, 10, 60, false);  //画出坦克的左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);  //画出坦克的右边边的轮子
                g.fill3DRect(x + 10, y + (60 - 40) / 2, 20, 40, false);  //画出坦克的盖子
                g.fillOval(x + 10, y + (60 - 20) / 2, 20, 20);  //画出坦克的圆形盖子
                g.drawLine(x + 20, y, x + 20, y + 60 / 2);  //画出炮筒
                break;
            default:
                System.out.println("暂时还未处理");
        }
    }
}
