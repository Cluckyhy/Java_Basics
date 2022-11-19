package com.chy.map;

import java.util.Comparator;
import java.util.TreeMap;

@SuppressWarnings({"all"})
public class TreeMap_ {
    public static void main(String[] args) {
        //使用默认的构造器，创建TreeMap
        /*
        要求：按照传入的字符串的大小进行排序
         */
        //TreeMap treeMap = new TreeMap();
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //return ((String)o2).compareTo((String)o1);
                return ((String)o1).length() - ((String)o2).length();
            }
        });

        treeMap.put("jack","杰克");
        treeMap.put("tom","汤姆");
        treeMap.put("kristina","克日斯提娜");
        treeMap.put("smith","史密斯");

        System.out.println(treeMap);
    }
}
