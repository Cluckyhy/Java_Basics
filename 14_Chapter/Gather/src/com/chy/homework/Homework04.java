package com.chy.homework;

import java.util.Comparator;
import java.util.TreeSet;

@SuppressWarnings({"all"})
public class Homework04 {
    public static void main(String[] args) {
        //分析 HashSet 和 TreeSet 分别是如何实现去重的
        /*
        (1)HashSet的去重机制：hashCode + equals()，底层先通过存入的对象，进行运算得到一个hash值，通过hash值得到对应的索引，
        如果发现table索引所在的位置，没有数据，就直接存放，如果有数据，就进行equals比较[遍历比较]，如果比较后，不相同，就加入
        否则就不加入，这里提醒：传入一个对象，一般需要进行去重的化，需要对对象的类进行hashCode()和equals()方法进行重写，
        不然少一个都不会实现去重的效果，像平常传入的字符串，实际String类就是实现了hashCode()和equals()方法，才得以实现两个字符串
        相同的情况下，就不能加入到HashSet中

        (2)TreeSet的去重机制：如果你传入了一个Comparator匿名对象，就使用实现的compare()方法去重，如果方法返回0，就认为是相同的元素/数据
        就不添加，如果你没有传入一个Comparator匿名对象，底层就会判断你是否传入了一个实现Compartor接口的对象，如果没有，
        底层就会判断 Comparator<? super K> cpr = comparator(用户传入的一个匿名对象)
                    if(cpr != null)...  //有的话，就按照你传入的Comparator匿名内部类的排序规则排序compare()
                    没传的话
                    else{
                    ..
                        Comparable<? super K> k = (Comparble<? super K>) key;
                        //会把你传入的key，类型转换为Comparable类型，这就是问题所在，如果你传入的对象没有实现Comparable接口
                        //这里是类型转换不过去的，所以就会报类型转换异常
                        //调用Comparable接口里面有compareTo()方法
                    ..
                    }
         */

        /*
        Comparable是排序接口，若一个类实现了Comparable接口，就意味着“该类支持排序”。
        而Comparator是比较器，我们若需要控制某个类的次序，可以建立一个“该类的比较器”来进行排序。
        Comparable相当于“内部比较器”，而Comparator相当于“外部比较器”。
        两种方法各有优劣， 用Comparable 简单， 只要实现Comparable 接口的对象直接就成为一个可以比较的对象，
        但是需要修改实现了Comparable接口类的源代码，即在类内重写compareTo()方法
        用Comparator 的好处是不需要修改类内部的源代码， 而是另外实现一个比较器compare()， 当某个自定义的对象需要作比较的时候，
        把比较器和对象一起传递过去就可以比大小了，通常以匿名内部类的形式， 并且在Comparator 里面用户可以自己实现复杂的可以通用的逻辑，
        使其可以匹配一些比较简单的对象，那样就可以节省很多重复劳动了(匿名内部类的形式)。
         */

        TreeSet treeSet = new TreeSet();
        treeSet.add("chy");
        treeSet.add("Rose");
        treeSet.add("Milan");
        treeSet.add("chy");
        System.out.println(treeSet);

        treeSet.clear();

        //因为，TreeSet()，构造器没有传入Comparator接口的匿名内部类
        //所以底层 Comparable<? super K> k = (Comparable<? super K>) key;
        //即把 Person 转成Comparable类型
        //treeSet.add(new Person());  //抛出异常ClassCastException

        treeSet.add(new Person("小明"));
        treeSet.add(new Person("小白"));
        treeSet.add(new Person("小红"));

        System.out.println(treeSet);

    }
}

class Person implements Comparable {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        //可以根据需要自定义，这里是返回一个大于0，小于0，等于0的一个数
        //如果返回一个等于0的数，说明，不能添加进集合中
        return -2;
    }
}
