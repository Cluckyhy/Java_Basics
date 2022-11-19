package com.chy.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//选择匹配符的使用
public class RegExp_03 {
    public static void main(String[] args) {
        String content = "chenhuiyi 陈 哈哈";
        String regStr = "hui|哈哈|陈";

        Pattern pattern = Pattern.compile(regStr/*,Pattern.CASE_INSENSITIVE*/);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println("找到："+matcher.group(0));
        }
    }
}
