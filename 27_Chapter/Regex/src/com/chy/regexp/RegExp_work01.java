package com.chy.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//正则表达式应用实例
public class RegExp_work01 {
    public static void main(String[] args) {
        //验证是否都是汉字
        //String content = "陈慧亿大帅哥";
        //String regStr = "^[\u0391-\uffe5]+$";

        //验证邮政编码
        //要求：是 1-9开头的六位数，比如：123890
        //String content = "123588";
        //String regStr = "^[1-9]{6}$";

        //验证qq号
        //要求：是 1-9开头的一个(5位数-10位数) 比如：123444，12355568
        //String content = "145465453";
        //String regStr = "^[1-9]\\d{4,9}$";

        //验证手机号
        //要求：必须以 13,14,15,18 开头的11位数，比如 13512345678
        //String content = "13512345678";
        //String regStr = "^1[3|4|5|8]\\d{9}$";

        //验证URL
        /*
        1、开始部分：https:// | http://
         */
        String content = "https://www.bilibili.com/video/BV1fh411y7R8?from=search&seid=1831060912083761326";
        //String content = "https://www.bilibili.com";
        //注意：限定符写在中括号中[.?*]表示匹配就是本身
        String regStr = "^((http|https)://)([\\w-]+\\.)+[\\w-]+(\\/[\\w-?=&/%.]*)?$";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println("满足格式");
            System.out.println(matcher.group(0));
        } else {
            System.out.println("不满足格式");
        }
    }
}
