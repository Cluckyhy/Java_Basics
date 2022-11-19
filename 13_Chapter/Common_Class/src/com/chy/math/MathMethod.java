package com.chy.math;

public class MathMethod {
    public static void main(String[] args) {
        //向上取整
        double ceil = Math.ceil(3.9);
        System.out.println(ceil);
        //向下取整
        double floor = Math.floor(4.2);
        System.out.println(floor);
        //四舍五入
        long round = Math.round(-3.6);
        System.out.println(round);
        //求开方
        double sqrt = Math.sqrt(9);
        System.out.println(sqrt);
        //random 求随机数
        //random 返回的是 [0,1) 之间的一个随机数
        //求一个随机数在 [a,b]
        //公式是：(int)(a+Math.random()*(b-a+1))
        for (int i = 0; i < 20; i++) {
            System.out.print((int)(2+Math.random()*6)+"  ");
        }
    }
}
