package com.chy.tankgame4;

import javax.swing.*;

public class ChyTankGame4 extends JFrame {

    //定义一个绘图区
    MyPanel mp = null;

    public static void main(String[] args) {
        new ChyTankGame4();
    }

    //构造器中初始化
    public ChyTankGame4(){
        mp = new MyPanel();
        //将mp 放入到Thread，并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.setSize(1015,788);
        this.add(mp);
        this.addKeyListener(mp);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
