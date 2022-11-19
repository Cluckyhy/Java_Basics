package com.chy.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings({"all"})
public class SetMethod01 {
    public static void main(String[] args) {

        /*
        1、以Set接口的实现类，HashSet来讲解Set接口的方法
        2、set接口的实现类的对象(Set接口对象)，不能存放重复的元素，可以添加null元素
        3、set 接口对象存放的数据是无序的(即添加的顺序和取出的数据不一致)
        4、注意：取出的顺序虽然不是添加的顺序，但是他是固定的
         */
        Set set = new HashSet();
        set.add("John");
        set.add("lucy");
        set.add("John");
        set.add("Marry");
        set.add("Rose");
        set.add(null);
        set.add(null);
        System.out.println(set);

        //遍历
        //1、使用迭代器
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }

        //删除null
        set.remove(null);
        System.out.println("----------------------");
        //2、使用增强for循环
        for (Object o : set) {
            System.out.println(o);
        }

        //set接口不能通过索引来获取元素

    }
}
