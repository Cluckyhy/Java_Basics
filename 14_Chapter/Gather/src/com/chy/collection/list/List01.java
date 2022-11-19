package com.chy.collection.list;

import java.util.ArrayList;
import java.util.List;

/*
List接口是Collection 接口的子接口
1、List集合类中元素有序(即添加顺序和取出顺序一致)、且可以重复
2、List集合中的每个元素都有其对应的顺序索引，即支持索引
3、List容器中的元素都对应一个整数型的序号记载其在容器中的位置，可以根据序号存取容器中的元素
4、JDK API中List接口实现类有：
    常用的有：ArrayList LinkedList Vector
 */

public class List01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        /*
        List集合类型中元素有序(即添加顺序和取出顺序一致)、且可以重复
         */
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("rose");
        list.add("chy");
        list.add("tom");
        System.out.println("list = " + list);

        //List集合中的每个元素都有其对应的顺序索引，即支持索引
        //索引从0开始的
        System.out.println(list.get(3));

        //
    }
}
