package com.chy.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//演示限定符的使用
public class RegExp_04 {
    public static void main(String[] args) {
        String content = "11111aaaaaaa111";

        //{一个数字}限定符
        //String regStr = "a{3}";     //表示匹配 aaa
        //String regStr = "1{4}";     //表示匹配 1111
        //String regStr = "\\d{2}";     //表示匹配 两位的任意数字字符


        //{3,}限定符
        //细节：java匹配默认是贪婪匹配，尽可能匹配多的
        //String regStr = "a{2,4}";     //表示匹配 aa 或则 aaa 或则 aaaa
        //String regStr = "1{4,5}";     //表示匹配 111 或则 1111
        //String regStr = "\\d{2,5}";     //表示匹配 2位/3位/4位/5位数字的组合

        //+号限定符
        //String regStr = "\\d+";     //表示匹配 一个数字或则多个数字   贪婪匹配
        //String regStr = "a+";       //表示匹配 一个数字或则多个数字   贪婪匹配


        //?限定符
        //String regStr = "a?";       //表示匹配 0个或一个a


        //*限定符
        String regStr = "1*";       //表示匹配 0个或多个1


        Pattern pattern = Pattern.compile(regStr/*,Pattern.CASE_INSENSITIVE*/);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println("找到："+matcher.group(0));
        }
    }
}
