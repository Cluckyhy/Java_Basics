package com.chy.string_stringbuffer_stringbuilder;

public class StringVsStringBufferVsStringBuilder {
    public static void main(String[] args) {
        /*
        1、StringBuilder 和 StringBuffer 非常类似，均代表可变的字符序列，而且方法也一样
        2、String：不可变字符序列，效率低，但是复用率高
        3、StringBuffer：可变字符序列、效率较高(增删)、线程安全，看源码，一帮的方法中都会有synchronized关键字
        4、StringBuilder：可变字符序列、效率最高、线程不安全
        5、String使用注意说明：
            String s = "a"创建了一个字符串
            s+="b";实际上原来的"a"字符串对象已经被丢弃了，现在又产生了一个字符串 s+"b"(也就是"ab")。如果多次执行这些
            改变串内容的操作，会导致大量副本字符串对象存留在内存中，降低效率。如果这样的操作放到循环中，会极大的影响程序的性能
            结论就是：如果我们对String做大量的修改，不要使用String
        6、效率：
            StringBuilder > StringBuffer > String
         */


        /*
        使用原则，结论：
            1、如果字符串存在大量的修改操作，一般使用StringBuffer或StringBuilder
            2、如果字符串存在大量的修改操作，并在单线程的情况下，使用 StringBuilder
            3、如果字符串存在大量的修改操作，并在多线程的情况下，使用StringBuffer
            4、如果我们字符串很少修改，被多个对象引用，使用String，比如配置信息等

            StringBuilder 的方法使用和 StringBuffer一样，不再说
         */
    }
}
