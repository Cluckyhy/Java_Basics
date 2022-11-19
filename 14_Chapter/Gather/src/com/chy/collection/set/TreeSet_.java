package com.chy.collection.set;

import java.util.Comparator;
import java.util.TreeSet;

@SuppressWarnings({"all"})
public class TreeSet_ {
    public static void main(String[] args) {
        /*
        TreeSet 和 TreeMap 如果创建的时候没有传入比较器，则只能存放实现了 Comparable 接口的类对象，否则会抛出类型转换异常
        传入字符串没有出现类转换异常是因为String类实现了Comparable接口，而如果自定义一个类但没有实现Comparable接口，就会抛出异常
         */
        //TreeSet treeSet = new TreeSet();
        //Comparator返回0就加不添加元素
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //下面 调用String的 comparaTo 方法进行字符串大小比较
                //如果String在比较时，比较的两个值相同，就会返回0，而Comparator返回值为0就不会添加元素
                //return ((String) o2).compareTo((String) o1);
                return ((String) o1).length() - ((String) o2).length();
                //如果按长度比较的话，lucy和tom都加不进去，因为lucy的长度和jack长度一样，Comparator返回0就加不添加元素
                //相同的 chy和tom的长度，相减后就等于0，Comparator返回的值为0，底层就不会添加元素进入
            }
        });
        //添加数据
        //1、当我们使用无参构造器，创建TreeSet时，仍然是无序的
        //2、当希望添加的元素，按照字符串大小来排序
        //3、使用TreeSet 提供的一个构造器，可以传入一个比较器(匿名内部类)
        //4、构造器把传入的比较器对象，赋给了 TreeSet的底层的 TreeMap的属性this.comparator
        //   并指定排序规则
        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("chy");
        treeSet.add("lucyee");
        //treeSet.add("chy");

        System.out.println(treeSet);

    }
}
