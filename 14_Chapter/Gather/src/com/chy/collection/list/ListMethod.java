package com.chy.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("张三");
        list.add("李白");
        list.add("陈慧亿");

        //1、在index位置插入ele元素
        list.add(2, "何巧");
        System.out.println(list);

        //addAll：从index位置开始将eles中的所有元素添加进来
        List list2 = new ArrayList();
        list2.add("tom");
        list2.add("Rose");
        list.addAll(1,list2);
        System.out.println(list);

        //indexOf：返回obj在集合中首次出现的位置
        System.out.println(list.indexOf("tom"));

        //lastIndexOf：返回obj在当前集合中最后出现的位置
        list.add("tom");
        System.out.println(list.lastIndexOf("tom"));
        System.out.println(list);

        //remove：移除指定index位置的元素，并返回此元素
        list.remove(0);
        System.out.println(list);

        //set：设置指定index位置的元素为ele，相当于替换
        list.set(1,"marry");
        System.out.println(list);

        //subList：返回从fromIndex 到 toIndex 位置的子集合
        System.out.println(list.subList(2, 4));
    }
}
