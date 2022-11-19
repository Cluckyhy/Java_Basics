package com.chy.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Date01 {
    public static void main(String[] args) throws ParseException {
        /*
        1、获取当前系统的时间
        2、这里的Date 类是在 java.util包
        3、默认输出的日期格式是国外的方式，因此通常需要对格式进行转换

        */
        Date date = new Date();
        System.out.println("当前日期为：" + date);

        /*
        1、创建 SimpleDateFormat对象，可以指定相应的格式
        2、这里的格式使用的字母是规定好的，不能乱写
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        String format = simpleDateFormat.format(date);
        System.out.println("当前日期为：" + format);

        /*
        1、可以把一个格式化的String 转换成对应的Date
        2、得到Date 仍然在输出时，还是按照国外的形式，如果希望指定格式输出，需要转换
        3、在把String -> Date，使用simpleDateFormat 格式需要和你给的String的格式一样，否则会抛出转换异常
         */
        String s = "1998年05月19日 10:20:40 星期一";
        Date parse = simpleDateFormat.parse(s);
        System.out.println("parse = " + simpleDateFormat.format(parse));
    }
}
