package com.chy.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//演示定位符的使用
public class RegExp_05 {
    public static void main(String[] args) {
        //String content = "123fd8cw";
        String content = "hanshunping saphan nnhan4";
        //以至少1个数字开头，后接任意小写字母的字符串
        //String regStr = "^[0-9]+[a-z]*";

        //以至少1个数字开头，必须至少一个小写字母结尾
        //String regStr = "^[0-9]+[a-z]+$";

        //边界【这里的边界是指：被匹配的字符串最后，也可以是空格的子字符串的后面】限定符 \\b
        //String regStr = "han\\b";       //表示要匹配边界的han

        //边界符取反，即不是边界的字符 \\B
        String regStr = "han\\B";       //表示要匹配不是边界的han

        Pattern pattern = Pattern.compile(regStr/*,Pattern.CASE_INSENSITIVE*/);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println("找到："+matcher.group(0));
        }
    }
}
