package com.chy;

public class Varparameter {
    public static void main(String[] args) {
        Parameter p1 = new Parameter();
//        int result = p1.sumNum(1,2,3,4,111,22,2333);
        //参数可以为0
        int result = p1.sumNum();
        System.out.println(result);
    }
}

class Parameter {
    //int... 表示接收的是可变参数，类型是int，即可以接收多个int(0-多)
    //使用可变参数时，可以当做数组来使用，即nums可以视为数组
    //遍历nums求和即可
    public int sumNum(int... nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        System.out.println("接收的参数个数为：" + nums.length);
        return res;
    }
}
