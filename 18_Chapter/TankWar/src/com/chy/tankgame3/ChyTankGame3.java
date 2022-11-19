package com.chy.tankgame3;

import javax.swing.*;

public class ChyTankGame3 extends JFrame {

    //定义一个绘图区
    MyPanel mp = null;

    public static void main(String[] args) {
        new ChyTankGame3();
    }

    //构造器中初始化
    public ChyTankGame3(){
        mp = new MyPanel();
        //将mp 放入到Thread，并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.setSize(1000,750);
        this.add(mp);
        this.addKeyListener(mp);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
