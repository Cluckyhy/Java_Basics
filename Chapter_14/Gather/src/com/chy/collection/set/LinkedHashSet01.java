package com.chy.collection.set;

import java.util.LinkedHashSet;
import java.util.Set;

@SuppressWarnings({"all"})
public class LinkedHashSet01 {
    public static void main(String[] args) {
        /*
        1、LinkedHashSet 加入的顺序和取出元素的顺序一致
        2、LinkedHashSet 底层维护的是一个LinkedHashMap(是HashMap的子类)
        3、LinkedHashSet 底层结构 (数组table+双向链表)
        4、添加第一次时，直接将 数组table 扩容到 16，存放的结点类型是：LinkedHashMap$Entry
        5、数组是 HashMap$Node[] 存放的元素/数据是：LinkedHashMap$Entry类型
         */
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(456);
        set.add("Rose");
        set.add(123);
        set.add("Chy");
        for (Object o :set) {
            System.out.println(o);
        }

    }
}
