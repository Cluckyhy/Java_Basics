package com.chy;

public class Homework02 {
    public static void main(String[] args) {
        //定义一组字符串数组
        String carr[] = {"小明","侠岚","小红"};
        //实例化一个对象
        A02 a2 = new A02();
        int res = a2.find("小红",carr);
        System.out.println(res);
    }
}

class A02{
    public int find(String ch,String carr[]){
        for (int i = 0; i < carr.length; i++) {
            if(ch.equals(carr[i])){
                return i;
            }
        }
        return -1;
    }
}
