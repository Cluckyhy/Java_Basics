package com.chy.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//演示转义字符的使用
public class RegExp_01 {
    public static void main(String[] args) {
        String content = "abc$(.abc.(123";
        //匹配小括号(
        //如果要匹配 . 需要转义\\.
        //String regStr = "\\.";
        //String regStr = "\\d\\d\\d";
        String regStr = "\\d{3}";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println("找到："+matcher.group(0));
        }
    }
}
