package com.chy.string;

public class StringMethod02 {
    public static void main(String[] args) {
        //1、toUpperCase()转换为大写
        String str1 = "heLLo";
        System.out.println(str1.toUpperCase());     //HELLO

        //2、toLowerCase
        System.out.println(str1.toLowerCase());     //hello

        //3、concat拼接字符串
        String s1 = "宝玉";
        s1 = s1.concat("林黛玉").concat("薛宝钗").concat("together");
        System.out.println(s1);

        //4、replace替换字符串中的字符
        s1 = "宝玉 and 林黛玉  林黛玉  林黛玉";
        //在s1中，将所有的林黛玉替换成薛宝钗
        //注意对s1没有任何影响
        String s2 = s1.replace("林黛玉", "薛宝钗");
        System.out.println(s2);
        System.out.println(s1);

        //5、split分割字符串，对于某些分割符，我们需要转义比如 |\\等
        String poem = "锄禾日当午，汗滴禾下土，谁知盘中餐，粒粒皆辛苦";
        String[] split = poem.split("，");
        System.out.println("====这首诗的内容是====");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
        //在字符串进行分割时，如果有特殊字符，需要加入转义字符  \
        String str2 = "E:\\aaa\\bbb";
        String[] split1 = str2.split("\\\\");
        for (int i = 0; i < split1.length; i++) {
            System.out.println(split1[i]);
        }

        //6、toCharArray 转换成字符数组
        String s = "happy";
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            System.out.println(chs[i]);
        }

        //7、compareTo 比较两个字符串的大小，如果前者大，则返回正数，后者大，则返回负数，如果相等，返回0
        String a = "jchn";
        String b = "jack";
        System.out.println(a.compareTo(b));     //返回值是：'c' - 'a'  = 2 的值

        //8、format格式字符串
        /*
        占位符有：
            %s -> 字符串  %c -> 字符   %d -> 整型  %2.f  浮点型
            这些占位符由后面的变量来替换

         */
        String name = "john";
        int age = 10;
        double score = 98.2 / 2;
        char gender = '男';
        //将所有信息都拼接在一个字符串
        String info = "我的姓名：" + name + "年龄是： " + age + ",成绩是：" + score + "，性别是：" + gender + "希望大家多多关照";
        System.out.println(info);

        String info2 = String.format("我的姓名是：%s  年龄是：%d  成绩为：%.2f   性别是：%c   希望大家多多关照", name, age, score, gender);

        System.out.println(info2);
    }
}
