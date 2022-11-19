package com.chy.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp_10 {
    public static void main(String[] args) {
        String content = "我....我要....学学学学....编程java!";

        //1、去掉所有的 .
        Pattern pattern = Pattern.compile("\\.");
        Matcher matcher = pattern.matcher(content);

        content = matcher.replaceAll("");

        System.out.println("content = " + content);

        //我我要学学学学编程java!
        //2、去掉重复的字
        // 内部方向引用是 \\1
        //(1) 使用(.)\\1+
        //(2) 使用 反向引用$1 来替换匹配到的内容
        pattern = Pattern.compile("(.)\\1+");
        //因为正则表达式变化了，所有要重置了matcher
        matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }

        //使用 外部反向引用 $1 来替换匹配到的内容
        content = matcher.replaceAll("$1");
        System.out.println("content = " + content);

        //使用一条语句去掉重复的汉字，我我要学学学学编程java!
        content = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");
        System.out.println("一条语句搞定：" + content);
    }
}
