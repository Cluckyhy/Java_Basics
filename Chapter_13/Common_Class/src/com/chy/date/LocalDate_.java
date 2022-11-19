package com.chy.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDate_ {
    public static void main(String[] args) {
        /*
        第三代日期：
            1、使用now() 返回表示当前日期时间的对象
            2、使用DateTimeFormatter 对象进行格式化
                创建DateTimeFormatter对象
         */
        LocalDateTime ldt = LocalDateTime.now();    //LocalDate.now();  //LocalTime.now();
        System.out.println(ldt);
        System.out.println("年 = "+ldt.getYear());
        System.out.println("月 = "+ldt.getMonth());
        System.out.println("月 = "+ldt.getMonthValue());
        System.out.println("日 = "+ldt.getDayOfWeek());
        System.out.println("日 = "+ldt.getDayOfMonth());
        System.out.println("日 = "+ldt.getDayOfYear());
        System.out.println("时 = "+ldt.getHour());
        System.out.println("分 = "+ldt.getMinute());
        System.out.println("秒 = "+ldt.getSecond());

        LocalDate now = LocalDate.now();    //可以获取年月日
        LocalTime time = LocalTime.now();   //获取时分秒

        //创建DateTimeFormatter对象
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH小时mm分钟ss秒");
        String format = dtf1.format(ldt);
        System.out.println("格式化的日期："+ format);

        //提供了 plus 和 minus方法可以对当前时间进行加或者减
        //看看520天后，是什么时候 把 年月日-时分秒
        LocalDateTime localDateTime = ldt.plusDays(520);
        System.out.println("520天后："+dtf1.format(localDateTime));

        //看看在 54分钟前是什么时候，把 年月日-时分秒输出
        LocalDateTime localDateTime1 = ldt.minusMinutes(54);
        System.out.println("54分钟前为："+dtf1.format(localDateTime1));
    }
}
