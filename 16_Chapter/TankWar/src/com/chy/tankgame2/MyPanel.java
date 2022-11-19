package com.chy.tankgame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//坦克大战的绘图区域
//为了监听键盘事件，实现KeyListener
public class MyPanel extends JPanel implements KeyListener {
    //定义我的坦克
    Hero hero = null;
    //定义敌人坦克
    Vector<Enemy> enemyTank;
    int enemySize = 3;

    public MyPanel() {
        hero = new Hero(100, 100);   //初始化坦克
        hero.setSpeed(10);
        enemyTank = new Vector<>();
        for (int i = 0; i < enemySize; i++) {
            Enemy enemy = new Enemy(100 * (i + 1), 0);
            enemy.setDirect(2);
            enemyTank.add(enemy);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);   //默认是黑色

        //画坦克--封装到方法中
        //drawTank(hero.getX(), hero.getY(), g, 0, 0);
        //自己的坦克
        drawTank(hero.getX() + 60, hero.getY(), g, hero.getDirect(), 0);
        //画出敌人的坦克，遍历Vector
        for (int i = 0; i < enemyTank.size(); i++) {
            //取出坦克
            Enemy enemy = enemyTank.get(i);
            drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirect(), 1);
        }
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
        //direct 表示方向(0：向上, 1；向右, 2：向下, 3：向左
        switch (direct) {
            case 0: //向上
                g.fill3DRect(x, y, 10, 60, false);  //画出坦克的左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);  //画出坦克的右边边的轮子
                g.fill3DRect(x + 10, y + (60 - 40) / 2, 20, 40, false);  //画出坦克的盖子
                g.fillOval(x + 10, y + (60 - 20) / 2, 20, 20);  //画出坦克的圆形盖子
                g.drawLine(x + 20, y + 60 / 2, x + 20, y);  //画出炮筒
                break;
            case 1: //向右
                g.fill3DRect(x, y, 60, 10, false);  //画出坦克的左边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);  //画出坦克的右边边的轮子
                g.fill3DRect(x + 10, y + (60 - 40) / 2, 40, 20, false);  //画出坦克的盖子
                g.fillOval(x + (60 - 20) / 2, y + 10, 20, 20);  //画出坦克的圆形盖子
                g.drawLine(x + 60 / 2, y + 20, x + 60, y + 20);  //画出炮筒
                break;
            case 2: //向下
                g.fill3DRect(x, y, 10, 60, false);  //画出坦克的左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);  //画出坦克的右边边的轮子
                g.fill3DRect(x + 10, y + (60 - 40) / 2, 20, 40, false);  //画出坦克的盖子
                g.fillOval(x + 10, y + (60 - 20) / 2, 20, 20);  //画出坦克的圆形盖子
                g.drawLine(x + 20, y + 60 / 2, x + 20, y + 60);  //画出炮筒
                break;
            case 3: //向左
                g.fill3DRect(x, y, 60, 10, false);  //画出坦克的左边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);  //画出坦克的右边边的轮子
                g.fill3DRect(x + 10, y + (60 - 40) / 2, 40, 20, false);  //画出坦克的盖子
                g.fillOval(x + (60 - 20) / 2, y + 10, 20, 20);  //画出坦克的圆形盖子
                g.drawLine(x + 60 / 2, y + 20, x, y + 20);  //画出炮筒
                break;
            default:
                System.out.println("输入有误！");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理wasd键按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:     //按下W
                //改变坦克的方向
                hero.setDirect(0);
                //修改坦克的坐标 y-1
                hero.moveUp();
                break;
            case KeyEvent.VK_D:
                hero.setDirect(1);
                hero.moveRight();
                break;
            case KeyEvent.VK_S:
                hero.setDirect(2);
                hero.moveDown();
                break;
            case KeyEvent.VK_A:
                hero.setDirect(3);
                hero.moveLeft();
                break;
        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
