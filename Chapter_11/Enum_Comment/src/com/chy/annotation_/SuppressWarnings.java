package com.chy.annotation_;

import java.util.ArrayList;
import java.util.List;

public class SuppressWarnings {
    @java.lang.SuppressWarnings("all")
    public static void main(String[] args) {
        //1、当我们不希望看到这些警告的时候，可以使用 SuppressWarnings注解来抑制警告信息
        //2、在{""}中，可以写入你希望抑制(不显示)警告信息
        //3、可以指定的警告类型有：
        //all，抑制所有警告
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("");
        int i;
        System.out.println(list.get(1));
    }
}
