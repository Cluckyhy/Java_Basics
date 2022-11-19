package com.chy;

public class Homework01 {
    public static void main(String[] args) {
        //编写类A01,定义方法max,实现求某个double数组的最大值，并返回
        //实例化一个对象
        A01 a1 = new A01();
        //定义一组double数组
        double darr[] = {1.2,2.3,0.3,9.4,29.3};
        //调用成员方法
        double res = a1.max(darr);
        System.out.println("两个数的较大值为："+res);

    }
}

class A01 {
    public double max(double arr[]) {
        double max = arr[0];
        for (int i = 1; i <arr.length; i++) {
            if(max<arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
}
