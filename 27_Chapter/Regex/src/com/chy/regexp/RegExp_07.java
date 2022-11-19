package com.chy.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//演示非捕获分组，语法比较奇怪
/*
    1、(?:pattern)
    2、(?=pattern)
    3、(?!pattern)
 */
public class RegExp_07 {
    public static void main(String[] args) {
        String content = "hello韩顺平教育 jack韩顺平老师 韩顺平同学hello 韩顺平拉拉";
        //1、找到 韩顺平教育、韩顺平老师、韩顺平同学 子字符串

        //String regStr = "韩顺平教育|韩顺平老师|韩顺平同学";
        //上面的写法可以改写，等价于 非捕获分组
        //String regStr = "韩顺平(?:教育|老师|同学)";

        //2、找到 韩顺平这个关键字，但是要求只是查找韩顺平教育和韩顺平老师中包含有韩顺平
        //String regStr = "韩顺平(?=教育|老师)";

        //3、找到 韩顺平 这个关键字，但是要求只是查找 不是 (韩顺平教育 和 韩顺平老师) 中包含有的韩顺平
        String regStr = "韩顺平(?!教育|老师)";

        Pattern pattern = Pattern.compile(regStr/*,Pattern.CASE_INSENSITIVE*/);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println("找到："+matcher.group(0));
            //注意上面的形式是非捕获的，不能通过group(1)获取
            //System.out.println("找到："+matcher.group(1));
        }
    }
}
