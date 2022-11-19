package com.chy.string;

public class StringExercise07 {
    public static void main(String[] args) {
        String str = new String("chy");
        char[] ch = {'a','b','c'};
        change(str,ch);
        System.out.println(str);
        System.out.println(ch);
    }
    public static void change(String str,char[] ch){
        str = "sss";
        System.out.println(str);
        char[] ch1 = {'d','s'};
        ch = ch1;
    }
}
