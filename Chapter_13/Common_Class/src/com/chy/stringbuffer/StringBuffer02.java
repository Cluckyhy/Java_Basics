package com.chy.stringbuffer;

public class StringBuffer02 {
    public static void main(String[] args) {
        //构造器的使用
        StringBuffer stringBuffer = new StringBuffer();

        //看 String -> StringBuffer
        String str = "hello tom";
        //方式1 使用构造器
        //注意：返回的才是StringBuffer对象，对str 本身没有影响
        StringBuffer stringbuffer = new StringBuffer(str);

        //方式2
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str);

        //看看 StringBuffer -> String
        StringBuffer stringBuffer2 = new StringBuffer("陈慧亿");
        //方式1，使用StringBuffer提供的 toString()方法
        String s = stringBuffer2.toString();

        //方式2，使用构造器来搞定
        String s1 = new String(stringBuffer2);
    }
}
