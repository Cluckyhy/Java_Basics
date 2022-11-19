package com.chy.regexp.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork01 {
    public static void main(String[] args) {
        /*
        规定电子邮件：
            1、只能有一个@
            2、@前面是用户名，可以是a-z,A-Z,0-9,_-字符
            3、@后面是域名，并且域名只能是英文字母，比如 sohu.com 或者 tsinghua.org.cn
            4、写出对应的正则表达式，验证输入的字符串是否为满足规则
         */

        String content = "105086-4544@qq.com.cn";
        //String regStr = "[\\w-]+@([a-zA-z]*\\.[a-z]+)+";
        String regStr = "^[\\w-]+@([a-zA-z]*\\.[a-z]+)+$";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);


        // 1、String 的 matches() 方法是整体匹配
        //Attempts to match the entire region against the pattern.
        if(content.matches(regStr)){
            System.out.println("匹配成功..");
        }else{
            System.out.println("匹配失败");
        }


        if(matcher.find()){
            System.out.println("匹配成功..");
            System.out.println(matcher.group(0));
        }else{
            System.out.println("匹配失败");
        }
    }
}
