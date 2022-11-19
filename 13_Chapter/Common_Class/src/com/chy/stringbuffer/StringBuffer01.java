package com.chy.stringbuffer;

public class StringBuffer01 {
    public static void main(String[] args) {
        /*
        1、StringBuffer 的直接类是  AbstractStringBuilder
        2、StringBuffer 实现了  Serializable，即StringBuffer的对象可以串行化
        3、在父类中 AbstractStringBuilder 有属性char[] value，不是final
           该 value 数组存放 字符串内容，因此存放在堆中的
        4、StringBuffer是一个 final类，不能被继承
         */
        StringBuffer stringBuffer = new StringBuffer("hello");
    }
}
