package com.chy;

public class Fibonacci {
    public static void main(String[] args) {
        //实例化一个对象
        FiboNa fi = new FiboNa();
        int res = fi.fibo(-1);
        System.out.println(res);
    }
}

class FiboNa {
    //定义一个方法
    public int fibo(int n) {
        if (n >= 1) {
            if (n == 1 || n == 2) {
                return 1;
            } else {
                return fibo(n - 1) + fibo(n - 2);
            }
        } else {
            System.out.println("输入的数有误！");
        }
        return -1;
    }
}
