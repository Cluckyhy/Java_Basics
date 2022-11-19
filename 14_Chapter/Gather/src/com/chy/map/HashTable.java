package com.chy.map;

import java.util.Hashtable;

@SuppressWarnings({"all"})
public class HashTable {
    public static void main(String[] args) {
        /*
        HashTable的基本介绍：
        1、存放的元素是键值对：即 K-V
        2、HashTable的键和值都不能为null，否则会抛出异常NullPointerException
        3、HashTable使用方法基本和HashMap一样
        4、HashTable是线程安全的(synchronized)，HashMap是线程不安全的
         */

        Hashtable table = new Hashtable();
        table.put("john", 100);
        //table.put(null,100);    //异常
        //table.put("chy",null);  //异常
        table.put("Rose", 200);
        table.put("Rose", 300);    //替换
        System.out.println(table);

        //简单说明一下，Hashtable的底层
        //1、底层有数组，Hashtable$Entry[] 初始化大小为 11
        //2、临界值  threshold 8 = 11*0.75
        //3、扩容：按照自己的扩容机制来进行即可
        //4、执行方法 addEntry(hash，key，value，index);添加K-V，封装到Entry
        //5、当 if (count >= threshold)满足时，就进行扩容
        //6、按照 int newCapacity = (oldCapacity << 1)+1;  的大小扩容
    }
}
