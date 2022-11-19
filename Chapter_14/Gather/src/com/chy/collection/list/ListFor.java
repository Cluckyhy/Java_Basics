package com.chy.collection.list;

import java.util.*;

public class ListFor {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //List 接口的实现子类  ArrayList  LinkedList  Vector
        //List list = new ArrayList();
        //List list = new LinkedList();
        List list = new Vector();
        list.add("tom");
        list.add("Rose");
        list.add("鱼香肉丝");
        list.add("北京烤鸭");

        //1、迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println(obj);
        }

        //2、增强for
        System.out.println("------------------------");
        for (Object o :list) {
            System.out.println(o);
        }

        //3、使用普通for
        System.out.println("-------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("对象 = " + list.get(i));
        }

    }
}
