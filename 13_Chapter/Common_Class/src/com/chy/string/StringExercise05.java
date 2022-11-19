package com.chy.string;

public class StringExercise05 {
    public static void main(String[] args) {
        String s1 = "chy";                  //s1指向池中的  "chy"
        String s2 = "java";                 //s2指向池中的  "java"
        String s3 = "chyjava";              //
        String s4 = (s1 + s2).intern();
        System.out.println(s3 == s4);       //true
        System.out.println(s3.equals(s4));  //true
    }
}
