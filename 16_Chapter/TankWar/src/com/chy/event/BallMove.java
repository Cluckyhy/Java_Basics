package com.chy.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
演示小球通过键盘控制上下左右移动 --> java事件控制
 */
public class BallMove extends JFrame {
    //定义一个画板
    MyPanel mp = null;

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }

    //构造器
    public BallMove() {
        mp = new MyPanel();
        this.setSize(500, 300);
        this.add(mp);
        //窗口JFrame对象可以监听键盘事件，即可以监听到面板上发生的键盘事件
        this.addKeyListener(mp);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}

//KeyListener 是监听器，可以监听键盘事件
class MyPanel extends JPanel implements KeyListener {
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);//默认为黑色
    }

    //有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当某个键按下时，该方法就会触发
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println((char)e.getKeyCode()+"被按下...");

        //根据用户按下的不同键，来处理小球的移动(上下左右)
        //if(e.getKeyChar() == KeyEvent.VK_DOWN){     //KeyEvent.VK_DOWN就是向下的箭头对应的code
        //    y++;
        //}
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                y += 10;
                break;
            case KeyEvent.VK_UP:
                y -= 10;
                break;
            case KeyEvent.VK_LEFT:
                x -= 10;
                break;
            case KeyEvent.VK_RIGHT:
                x += 10;
                break;
        }

        //让面板重新绘画一次
        this.repaint();
    }

    //当某个键释放(松开)，该方法就会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
