package com.chy.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionFor {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection col = new ArrayList();

        col.add(new Book("三国演义", "罗贯中", 230.3));
        col.add(new Book("小李飞刀", "古龙", 221.3));
        col.add(new Book("红楼梦", "曹雪芹", 140.3));

        //1、使用增强for循环，在Collection集合
        //2、增强for，底层仍然是迭代器
        //3、增强for可以理解成就是简化版本的  迭代器遍历
        //4、快捷键方式：I
        for (Object book : col) {
            System.out.println("book =" + book);
        }

        ////增强for循环，也可以直接使用在数组中
        //int[] nums = {1, 43, 5, 9, 11};
        //for(int i : nums){
        //    System.out.println("i =" + i);
        //}
    }
}
