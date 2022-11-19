package com.chy.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//演示非贪婪匹配
public class RegExp_08 {
    public static void main(String[] args) {
        String content = "hello111111 ok";
        //String regStr = "\\d+";     //默认是贪婪匹配
        String regStr = "\\d+?";     //非贪婪匹配(懒惰匹配)

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println("找到："+matcher.group(0));
        }
    }
}
