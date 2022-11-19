package com.chy;

public class VarparameterDetail {
    public static void main(String[] args) {

        //可变参数的实参可以为0个或任意多个
        //可变参数的实参可以为数组
        //可变参数的本质就是数组
        Myclass mc = new Myclass();
        int arr[] = {1,2,3,4};
        mc.fun(arr);
        mc.fun2("lal",1,3);

    }
}

class Myclass{
    public void fun(int... nums){
        System.out.println("长度为："+nums.length);
    }
    //可变参数可以和普通类型的参数一起放在形参列表中，但是必须保证可变参数在最后
    public void fun2(String str,double... nums){
        System.out.println(str);
        System.out.println(nums[1]);

    }
    //一个形参列表中只能出现一个可变参数
//    public void fun3(int n ,String... str,double... nums){
//
//    }
}
