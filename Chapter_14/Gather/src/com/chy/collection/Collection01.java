package com.chy.collection;

import java.util.ArrayList;
import java.util.List;

public class Collection01 {
    /*
    public interface Collection<E> extends Iterable<E>

    1、collection实现子类可以存放多个元素，每个元素可以是Object/或Object的子类，如果添加的是基本数据类型，会自动装箱，变成一个对象
    2、有些Collection的实现类，可以存放重复的元素，有些不可以
    3、有些Collection的实现类，有些是有序的(List)，有些不是有序的(Set)
    4、Collection接口没有直接的实现子类，是通过它的子接口Set和List来实现的
     */

    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();

        //1、add：添加单个元素
        list.add("jack");
        list.add(10);   //list.add(new Integer(10))
        list.add(true);
        list.add("chy");
        System.out.println("list = " + list);

        //2、remove：删除指定元素
        list.remove(0);     //删除第一个元素
        System.out.println(list);
        //注意：如果要删除的是数字的话，需要在这里把数字10强转为Integer对象，不然会以为是下标为10，然后list内没有10个对象
        //而报错，下标越界
        //System.out.println(list.remove(10));  //ERROR
        System.out.println(list.remove((Integer)10));
        System.out.println(list);

        //3、contains：查找元素是否存在
        System.out.println(list.contains("jack"));

        //4、size：获取元素个数
        System.out.println(list.size());

        //5、isEmpty：判断是否为空
        System.out.println(list.isEmpty());

        //6、clear：清空
        list.clear();
        System.out.println(list);

        //7、addAll：添加多个元素
        List list2 = new ArrayList();
        list2.add("tom");
        list2.add("rose");
        list2.add(23);
        list.addAll(list2);
        System.out.println(list);

        //8、containsAll：查找多个元素是否存在
        System.out.println(list.containsAll(list2));

        //9、removeAll：删除多个元素
        list.removeAll(list2);
        System.out.println(list);
        list.add("三国");
        System.out.println(list);
    }
}
