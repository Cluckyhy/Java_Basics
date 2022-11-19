package com.chy.string;

public class StringExercise03 {
    public static void main(String[] args) {
        /*
        String 是一个 final类，代表不可变的字符序列
        字符串是不可变的，一个字符串对象一旦被分配，其内容是不可变的
         */
        //创建了两个对象
        String s1 = "hello";
        s1 = "Rose";
        //这里你改变了s1的值，其实是新创建了个对象，新的value值指向新的常量池
        System.out.println(s1);

        //创建了一个对象
        String a = "hello" + "abc";
        //注意：这里不是先创建"hello"然后创建"abc",最后创建"helloabc"，其实编译器会做优化：
        //优化等价于：String a = "helloabc"，直接创建一个对象
        //编译器不傻，做一个优化，判断创建的常量池对象，是否有引用指向
        //String a = "hello" + "abc";  ===>   String a = "helloacb";
    }
}
