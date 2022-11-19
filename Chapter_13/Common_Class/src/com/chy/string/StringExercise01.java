package com.chy.string;

public class StringExercise01 {
    public static void main(String[] args) {
        /*
        知识点：
            当调用intern方法时，如果池中已经包含一个等于此String对象的字符串(用equals(Object)方法确定)
            则返回池中的字符串，否则，将此String对象添加到池中，并返回此String对象的引用
            其实就是b.intern()方法最终返回的是常量池的地址(对象)
         */
        String a = "hsp";   // a 指向常量池的 "hsp"
        String b = new String("hsp");   //b指向堆中的对象，value->常量池的"hsp"
        System.out.println(b.intern()); //hsp
        System.out.println(a.equals(b)); // T   //String类中重写了equals方法，比较但是两个字符串的内容
        System.out.println(a == b);     //F
        System.out.println(a == b.intern());    //T
        System.out.println(b == b.intern());    //F

        String s1 = "chy";          //指向常量池的"chy"
        String s2 = "java";         //指向常量池的"java"
        String s3 = new String("java"); //指向堆中对象
        String s4 = "java";         //指向常量池的"java"
        System.out.println(s2 == s3);       //F
        System.out.println(s2 == s4);       //T
        System.out.println(s2.equals(s3));  //T
        System.out.println(s1 == s2);       //F
    }
}
