package com.chy.codeblock.codeblockexercise;

public class CodeBlockExercise01 {
    public static void main(String[] args) {
        System.out.println("total = " + Person.total);
        System.out.println("total = " + Person.total);
    }
}

class Person {
    //首先执行，默认值为0
    public static int total;

    //只执行一次
    static {
        total = 10;
        System.out.println("in static block!");
    }
}
