package com.chy.map;

import java.util.*;

@SuppressWarnings({"all"})
public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋洁", "马蓉");
        map.put("刘思思", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");

        //第一组：先取出 所有的 key，通过key，取出对应的value

        Set keyset = map.keySet();
        System.out.println("---------增强for循环----------");
        //(1)增强for循环
        for (Object key : keyset) {
            System.out.println(key + "-" + map.get(key));
        }

        System.out.println("---------迭代器----------");
        //(2)迭代器
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key + "-" + map.get(key));
        }

        //第二组：把所有的value值取出

        Collection values = map.values();
        //这里可以使用所有Collection可以使用的遍历方法
        System.out.println("-----------取出值  增强for------------");
        //(1)增强for
        for (Object value : values) {
            System.out.println("value = " + value);
        }

        System.out.println("-----------取出值  迭代器------------");
        //(2)迭代器
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object value = iterator1.next();
            System.out.println("value = " + value);
        }

        //第三组：通过EntrySet 来获取 k-v
        Set entrySet = map.entrySet();  //entrySet集合里面放的类型是：EntrySet<Map.Entry<K,V>>
        System.out.println("-----------取出值  使用EntrySet 的增强for------------");
        //(1)增强for循环
        for (Object entry : entrySet) {
            //将entry 转成 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + " " + m.getValue());
        }

        System.out.println("-----------取出值  使用迭代器------------");
        //(2)迭代器
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Object obj = iterator2.next();
            //System.out.println(obj.getClass());     //HashMap$Node -->  实现  -->  Map.Entry (getKey,getValue)
            //向下转型 Map.Entry
            Map.Entry m = (Map.Entry) obj;
            System.out.println(m.getKey() + " " + m.getValue());
        }

    }
}
