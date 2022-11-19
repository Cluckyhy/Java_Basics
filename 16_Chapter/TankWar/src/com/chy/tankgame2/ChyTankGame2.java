package com.chy.tankgame2;

import javax.swing.*;

public class ChyTankGame2 extends JFrame {

    //定义一个绘图区
    MyPanel mp = null;

    public static void main(String[] args) {
        new ChyTankGame2();
    }

    //构造器中初始化
    public ChyTankGame2(){
        mp = new MyPanel();
        this.setSize(1000,750);
        this.add(mp);
        this.addKeyListener(mp);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
