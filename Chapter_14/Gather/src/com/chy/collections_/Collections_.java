package com.chy.collections_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings({"all"})
public class Collections_ {
    public static void main(String[] args) {
        //创建ArrayList 集合，用于测试
        ArrayList list = new ArrayList();
        list.add("tom");
        list.add("smith");
        list.add("king");
        list.add("tom");
        list.add("milan");

        //reverse(List): 反转 List 中元素的顺序
        Collections.reverse(list);
        System.out.println(list);
        //shuffle(有重新洗牌的意思)：集合List元素进行随机排序
        for (int i = 0; i < 5; i++) {
            Collections.shuffle(list);
            System.out.println(list);
        }
        System.out.println("-------自然排序后-------");
        //sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
        Collections.sort(list);
        System.out.println(list);

        //希望按照字符串的长度大小排序
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println("字符串长度大小排序：" + list);

        //swap(List,int,int):将指定list集合中的i处元素和j处元素进行交换
        Collections.swap(list, 1, 2);
        System.out.println("交换后：");
        System.out.println(list);

        //Object max(Collection)：根据元素的自然排序，返回给定集合中最大元素
        System.out.println("自然排序最大元素：" + Collections.max(list));
        //Object max(Collection,Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
        //比如我们要返回长度最大的元素
        Object maxobj = Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println("长度最大的元素：" + maxobj);

        //Object min(Collection)
        //Object min(Collection,Comparator)

        //int frequency(Collection,Object)：返回指定集合中指定元素的出现次数
        System.out.println("tom出现的次数：" + Collections.frequency(list, "tom"));

        //void copy(List dest, List src)：将src中的内容复制到dest中
        //为了完成一个完整的拷贝，我们需要先给dest赋值，大小和list.size()一样
        ArrayList dest = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            dest.add("");
        }
        Collections.copy(dest,list);
        System.out.println(dest);

        //boolean replaceAll(List list, Object oldVal, Object newVal)：使用新值替换 List 对象的所有旧值
        //如果list中，有tom 就替换成为 汤姆
        Collections.replaceAll(list,"tom","汤姆");
        System.out.println(list);
    }
}
