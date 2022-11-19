package com.chy.paint_;

import javax.swing.*;
import java.awt.*;

//1、先定义一个MyPanel类，继承JPanel类，画图形，就在面板上画
class MyPanel extends JPanel {

    /*
    说明：
    1、MyPanel 对象就是一个画板
    2、Graphics g 把 g 理解成一支画笔    Graphics 是一个抽象类，里面定义了和多关于画画的抽象方法
    3、Graphics 提供了很多绘图的方法
     */

    /*
    Component 类提供了两个和绘图相关的重要的方法：
    1、paint(Graphics g)绘制组件的外观
    2、repaint()刷新组件的外观

    当组件第一次在屏幕显示的时候，程序会自动的调用paint()方法来绘制组件
    在以下情况paint()将会被调用：
        1、窗口最小化，窗口再次显示的时候
        2、窗口的大小发生变化
        3、repaint()函数被调用
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g); //调用父类的有参方法完成初始化，要保留

        //画直线
        //g.drawLine(10,10,100,100);

        //画矩形边框
        //g.drawRect(10,10,100,100);

        //设置画笔颜色
        g.setColor(Color.RED);

        //填充矩形
        //g.fillRect(10,10,100,100);

        //填充椭圆
        //g.fillOval(10,10,100,100);

        //画图片
        Image image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("bj.jpg"));
        g.drawImage(image, 100, 50, 200, 200, this);


        //绘制一个椭圆，参数有：int x, int y, int width, int height
        //如果width 和 height 相等的话，就是一个圆
        //System.out.println("paint方法被调用！");
        //g.drawOval(100, 100, 100, 100);
    }
}
