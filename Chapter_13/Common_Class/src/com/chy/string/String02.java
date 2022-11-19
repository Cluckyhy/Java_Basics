package com.chy.string;

public class String02 {
    public static void main(String[] args) {
        /*
        两种方式创建String对象的区别：
            方式一：
                直接赋值 String s = "chy";
            方式二：
                调用构造器 String s2 = new String("chy");

            方式一：先从常量池查看是否有"chy"数据空间，如果有，直接访问；如果没有则重新创建，然后指向。s最终指向的是常量池的空间地址
            方式二：先在堆中创建空间，里面维护了value属性，指向常量池的chy空间。如果常量池中没有"chy"，重新创建
                    如果有，直接通过value指向，最终指向的是堆中的空间地址
        注意：
            以前不懂的地方是：
                System.out.println("Chy");  就算是直接在输出语句中打印一个字符串，字符串也是返回一个地址回来的，不要单纯的就以为是一个字符串
                以为只要是一个字符串，JVM底层都是直接返回一个char类型的数组名(value)出来。我们知道，数组名就是数组首地址
                所以，以后看见字符串，就是看见一个地址暴露出来
         */
    }
}
