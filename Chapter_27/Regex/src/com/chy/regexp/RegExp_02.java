package com.chy.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//演示字符匹配符的 使用
public class RegExp_02 {
    public static void main(String[] args) {
        String content = "abc11 c8$b_bABC% uo";
        //String regStr = "[a-z]";      //匹配 a-z之间的任意一个字符
        //String regStr = "[A-Z]";      //匹配 a-z之间的任意一个字符
        //String regStr = "abc";        //匹配 abc 字符串[默认区分大小写]
        //String regStr = "(?i)abc";    //匹配 abc 字符串[不区分大小写]
        //String regStr = "[^a-z]";     //匹配 不在a-z之间的任意字符
        //String regStr = "[^0-9]";     //匹配 不在0-9之间的任意字符
        //String regStr = "[abcd]";     //匹配 abcd中任意字符
        //String regStr = "\\D";        //匹配 不在0-9中任意字符
        //String regStr = "\\w";        //匹配 字母，数字，下划线
        //String regStr = "\\W";        //匹配 取反-->字母，数字，下划线
        //String regStr = "\\s";        //匹配 任何空白字符(空格，制表符...)
        //String regStr = "\\S";        //匹配 取反-->任何空白字符(空格，制表符...)
        String regStr = ".";            //匹配 出 \n之外的所有字符，如果要匹配.本身，则需要使用\\



        //当创建Pattern对象时，Pattern.CASE_INSENSITIVE 参数，表示匹配不区分字母的大小写
        Pattern pattern = Pattern.compile(regStr/*,Pattern.CASE_INSENSITIVE*/);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println("找到："+matcher.group(0));
        }
    }
}
