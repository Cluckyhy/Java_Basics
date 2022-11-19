package com.chy.tankgame4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//坦克大战的绘图区域
//为了监听键盘事件，实现KeyListener
//为了让Panel 不停的绘制子弹，需要将MyPanel实现Runnable接口，当做一个线程来使用
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我的坦克
    Hero hero = null;
    //定义敌人坦克
    Vector<Enemy> enemyTanks;
    int enemyTankSize = 3;
    //定义一个Vector，用于存放炸弹
    //说明：当子弹击中坦克时，加入一个Bomb对象到bombs
    Vector<Bomb> bombs = new Vector<>();

    //定义三张炸弹图片，用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {
        hero = new Hero(500, 100);   //初始化坦克
        hero.setSpeed(10);
        enemyTanks = new Vector<>();
        for (int i = 0; i < enemyTankSize; i++) {
            //创建敌人坦克
            Enemy enemyTank = new Enemy(100 * (i + 1), 0);
            //设置方向
            enemyTank.setDirect(2);
            //启动敌人坦克线程
            new Thread(enemyTank).start();
            //给该enemyTank 加入一颗子弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            //把子弹加入到enemyTank的Vector 成员
            enemyTank.shots.add(shot);
            //启动 shot 对象
            new Thread(shot).start();
            //加入
            enemyTanks.add(enemyTank);
        }
        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("bomb_3.gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);   //默认是黑色

        //画坦克--封装到方法中
        //drawTank(hero.getX(), hero.getY(), g, 0, 0);

        //画出hero射击子弹
        //if (hero.shot != null && hero.shot.isLive) {
        //    //System.out.println("子弹被绘制..");
        //    //g.fill3DRect(hero.shot.x, hero.shot.y, 10, 10, false);
        //    g.setColor(Color.RED);
        //    //g.draw3DRect(hero.shot.x, hero.shot.y, 5, 5, false);
        //    //g.drawOval(hero.shot.x, hero.shot.y, 5, 5);
        //    g.fillOval(hero.shot.x, hero.shot.y, 7, 7);
        //}

        //将hero的子弹集合 shots，遍历取出绘制
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive) {
                g.setColor(Color.RED);
                g.fillOval(shot.x, shot.y, 7, 7);
            } else {  //如果该shot对象已经无效了，就从shots集合中拿掉
                hero.shots.remove(shot);
            }
        }

        //画自己的坦克
        if(hero != null && hero.isLive){
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        }

        //如果bombs 集合中有对象，就画出
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前这个bomb对象的life值去画出对应的图片
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            //让炸弹的生命值减少
            bomb.lifeDown();
            //如果bomb life 为0，就从bombs 的集合中删除
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }

        //画出敌人的坦克，遍历Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //从Vector 取出坦克
            Enemy enemyTank = enemyTanks.get(i);
            //判断当前坦克是否还存活
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
                //画出 enemyTank 所有子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    //绘制
                    if (shot.isLive) {    //isLive == true
                        g.fillOval(shot.x, shot.y, 7, 7);
                    } else {
                        //从Vector 移除
                        enemyTank.shots.remove(shot);
                    }
                }
            }
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
                g.drawLine(x + 20, y, x + 20, y + 60 / 2);  //画出炮筒
                break;
            case 1: //向右
                g.fill3DRect(x, y, 60, 10, false);  //画出坦克的左边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);  //画出坦克的右边边的轮子
                g.fill3DRect(x + 10, y + (60 - 40) / 2, 40, 20, false);  //画出坦克的盖子
                g.fillOval(x + (60 - 20) / 2, y + 10, 20, 20);  //画出坦克的圆形盖子
                g.drawLine(x + 60, y + 20, x + 60 / 2, y + 20);  //画出炮筒
                break;
            case 2: //向下
                g.fill3DRect(x, y, 10, 60, false);  //画出坦克的左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);  //画出坦克的右边边的轮子
                g.fill3DRect(x + 10, y + (60 - 40) / 2, 20, 40, false);  //画出坦克的盖子
                g.fillOval(x + 10, y + (60 - 20) / 2, 20, 20);  //画出坦克的圆形盖子
                g.drawLine(x + 20, y + 60, x + 20, y + 60 / 2);  //画出炮筒
                break;
            case 3: //向左
                g.fill3DRect(x, y, 60, 10, false);  //画出坦克的左边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);  //画出坦克的右边边的轮子
                g.fill3DRect(x + 10, y + (60 - 40) / 2, 40, 20, false);  //画出坦克的盖子
                g.fillOval(x + (60 - 20) / 2, y + 10, 20, 20);  //画出坦克的圆形盖子
                g.drawLine(x, y + 20, x + 60 / 2, y + 20);  //画出炮筒
                break;
            default:
                System.out.println("输入有误！");
        }
    }

    //编写方法，如果我们的坦克可以发射多颗子弹
    //再判断我方子弹是否击中敌人坦克时，就需要把我们的子弹集合中所有的子弹都取出来和敌人的所有坦克，进行判断
    public void hitEnemyTank() {
        //遍历我们的子弹
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            //判断是否击中了敌人的坦克
            if (shot != null && shot.isLive) {   //当我的子弹还存活
                //遍历敌人所有的坦克
                for (int j = 0; j < enemyTanks.size(); j++) {
                    Enemy enemyTank = enemyTanks.get(j);
                    hitTank(shot, enemyTank);
                }
            }
        }
    }

    //编写方法，判断敌人的坦克是否击中我的坦克
    public void hitHero(){
        //遍历所有的敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出敌人的坦克
            Enemy enemyTank = enemyTanks.get(i);
            //遍历enemyTank对象的所有子弹
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                //取出子弹
                Shot shot = enemyTank.shots.get(j);
                //判断shot 是否击中我的坦克
                if(hero.isLive && shot.isLive){
                    hitTank(shot,hero);
                }
            }
        }
    }

    //编写方法，判断我方的子弹是否击中敌人的坦克
    //后面我们将 enemyTank 改成 tank名称
    public void hitTank(Shot s, Tank enemyTank) {
        //判断 s 击中坦克
        switch (enemyTank.getDirect()) {
            case 0: //坦克向上
            case 2: //坦克向下
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40 &&
                        s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //如果子弹击中坦克，把坦克从enemyTanks集合中去除
                    enemyTanks.remove(enemyTank);
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1: //坦克向右
            case 3: //坦克向左
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60 &&
                        s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //如果子弹击中坦克，把坦克从enemyTanks集合中去除
                    enemyTanks.remove(enemyTank);
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
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
                if (hero.getY() > 0) {
                    hero.moveUp();
                }
                break;
            case KeyEvent.VK_D:
                hero.setDirect(1);
                if (hero.getX() + 60 < 1000) {
                    hero.moveRight();
                }
                break;
            case KeyEvent.VK_S:
                hero.setDirect(2);
                if (hero.getY() + 60 < 750) {
                    hero.moveDown();
                }
                break;
            case KeyEvent.VK_A:
                hero.setDirect(3);
                if (hero.getX() > 0) {
                    hero.moveLeft();
                }
                break;
        }
        //如果用户按下的是空格(Space)
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            //判断hero的子弹是否销毁
            //if (hero.shot == null || !hero.shot.isLive) {
            //    hero.shotEnemyTank();
            //}
            //发射多颗子弹
            hero.shotEnemyTank();
        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {     //每隔100毫秒重绘画板，刷新绘图区域，子弹就移动
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //判断是否击中了敌人的坦克
            hitEnemyTank();
            //判断敌人的坦克是否击中我的坦克
            hitHero();
            this.repaint();
        }
    }
}
