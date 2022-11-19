package com.chy.stringbuilder;

public class StringBuilder01 {
    public static void main(String[] args) {
        /*
        StringBuilder介绍：
            1、一个可变的字符串序列，此类提供一个与StringBuffer兼容的 API，但不保证同步(StringBuilder，不是线程安全的)
            该类被设计用作StringBuffer的一个简易替换，用在字符串缓冲区被单个线程使用的时候，如果可能，建议优先采用该类
            因为在大多数实现中，它比StringBuffer要快
            2、在StringBuilder上的主要操作是append和insert方法，可重载这些方法，以接受任意类型的数据
            3、StringBuilder 继承了 AbstractStringBuilder类
            4、实现了 Serializable，说明StringBuilder对象可以串行化(对象可以网络传输)
            5、StringBuilder 是 final类，不能被继承
            6、StringBuilder 对象字符序列仍然是存放在其父类 AbstractStringBuilder的，char[] value;
                因此，字符序列是在堆中的
            7、StringBuilder 的方法，没有做互斥的处理，即没有synchronized 关键字，因此在单线程的情况下使用StringBuilder
         */
        StringBuilder stringBuilder = new StringBuilder();
    }
}
