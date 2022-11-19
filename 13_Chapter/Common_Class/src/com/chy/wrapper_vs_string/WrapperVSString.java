package com.chy.wrapper_vs_string;

public class WrapperVSString {
    public static void main(String[] args) {
        /*
        包装类(Integer)  -->  String
         */
        Integer i = 100;    //自动装箱
        //方式1
        String str1 = i + "";
        //方式2
        String s = i.toString();
        //方式3
        String s1 = String.valueOf(i);

        /*
        String   -->   包装类(Integer)
         */
        //方式1
        String str2 = "123";
        int i1 = Integer.parseInt(str2);            //返回的是一个int类型
        //方式2
        Integer integer = Integer.valueOf(str2);    //返回的是一个Integer包装类型
        //方式2 (过时)
        Integer integer2 = new Integer(str2);


    }
}
