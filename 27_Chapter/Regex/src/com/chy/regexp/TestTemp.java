package com.chy.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
注意：当限定符 ? + * 写在[]中的话
      就说明是匹配它们自己本身
 */
public class TestTemp {
    public static void main(String[] args) {
        String content = "he?llo a+b+c 1.1.1";
        //String regStr = ".";          //匹配 除了 \n 的所有字符
        //String regStr = "[.]";        //匹配 除了 . 本身
        String regStr = "[?]";        //匹配 除了 ? 本身
        //String regStr = "[+]";          //匹配 除了 + 本身

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println("找到："+matcher.group(0));
        }
    }
}
