package com.chy.date;

import java.util.Calendar;

public class Calendar01 {
    public static void main(String[] args) {
        //1、Calendar是一个抽象类，并且构造器是私有的private
        //2、可以通过 getInstance() 来获取实例
        //3、提供大量的方法和字段提供给程序员
        //4、Calendar 没有提供对应的格式化类，因此需要程序员自己组合来输出(自己定义)
        //5、如果我们需要按照 24小时进制数来获取时间，Calendar.HOUR ==> 改成==> Calendar.HOUR_OF_DAY
        Calendar instance = Calendar.getInstance();
        System.out.println("instance  = " + instance);
        //4、获取日历对象的某个日历字段
        //System.out.println("年："+Calendar.YEAR);   //注意：如果没有和对象关联起来，输出的是开发者默认设置的值
        System.out.println("年："+instance.get(Calendar.YEAR));
        System.out.println("月："+(instance.get(Calendar.MONTH)+1));
        System.out.println("日："+instance.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时："+instance.get(Calendar.DAY_OF_MONTH));
        System.out.println("分钟："+instance.get(Calendar.MINUTE));
        System.out.println("秒："+instance.get(Calendar.SECOND));
    }
}
