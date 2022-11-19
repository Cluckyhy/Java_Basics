package com.chy.map;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"all"})
public class MapMethod {
    public static void main(String[] args) {
        //演示map接口的常用方法
        Map map = new HashMap();
        map.put("邓超", new Book1("", 100));
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋洁", "马蓉");
        map.put("刘思思", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");

        System.out.println(map);
        //remove()
        map.remove(null);
        System.out.println(map);
        //get()
        Object val = map.get("鹿晗");
        System.out.println(val);
        //size()
        System.out.println("k - v = " + map.size());
        //isEmpty()
        System.out.println(map.isEmpty());  //false
        //clear()：清空
        map.clear();
        System.out.println(map);
        map.put("chy","陈慧亿");
        //containKey()
        System.out.println(map.containsKey("chy"));
        System.out.println(map.containsValue("陈慧亿"));
    }
}

class Book1 {
    private String name;
    private int num;

    public Book1(String name, int num) {
        this.name = name;
        this.num = num;
    }
}
