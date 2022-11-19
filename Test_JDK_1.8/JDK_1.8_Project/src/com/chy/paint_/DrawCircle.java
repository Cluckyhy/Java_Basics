package com.chy.paint_;


import javax.swing.*;
import java.awt.*;

/*
演示如何在面板上画出圆形
 */
public class DrawCircle extends JFrame {     //JFrame 对应一个窗口，可以理解成一个画框

    //定义一个面板
    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();
        System.out.println("程序退出");
    }


    public DrawCircle() {       // 构造器的初始化工作就完成了
        //初始化面板
        mp = new MyPanel();
        //把面板放入到窗口中(画框)
        //其实这里的add()方法是container类里面的，JFrame继承了Frame，Frame继承了Window，Window继承了Container。所以DrawCircle有add()这个方法
        this.add(mp);
        //设置窗口的大小，setSize()是 Window类里面的方法
        this.setSize(500, 600);
        //使窗口可以显示，setVisible() 也是 Window类里面的方法
        this.setVisible(true);
        //当点击窗口的小x，程序就完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

