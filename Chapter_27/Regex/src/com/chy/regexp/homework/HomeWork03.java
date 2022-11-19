package com.chy.regexp.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork03 {
    public static void main(String[] args) {
        //对一个URL进行解析
        //https://www.sohu.com:8080/abc/index.html
        /*
        1、要求得到协议是什么？    http
        2、域名是什么？           www.sohu.com
        3、端口号是什么？         8080
        4、文件名是什么？         index.html
         */

        String content = "https://www.sohu.com:8080/abc/test1/demo2/index.html";
        String regStr = "^(http|https):\\/{2}(www\\.([a-zA-Z]+(\\.[a-z]+)+)+):(\\d+)(\\/[\\w+\\/]+\\/)*(\\w+\\.[a-z]+)$";

        if (content.matches(regStr)) {
            System.out.println("匹配成功...");
        } else {
            System.out.println("匹配失败...");
        }

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("协议为：" + matcher.group(1));
            System.out.println("域名为：" + matcher.group(2));
            System.out.println("端口为：" + matcher.group(5));
            System.out.println("文件名为：" + matcher.group(7));

            System.out.println("----------------------------------");

            System.out.println("第3组为" + matcher.group(3));
            System.out.println("第4组为" + matcher.group(4));
            System.out.println("第6组为" + matcher.group(6));
        }
    }
}
