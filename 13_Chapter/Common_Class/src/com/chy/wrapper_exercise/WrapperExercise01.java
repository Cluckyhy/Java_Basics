package com.chy.wrapper_exercise;

public class WrapperExercise01 {
    public static void main(String[] args) {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);     //false

        //这里要看范围：如果值在 -128~127，就是直接返回值，所以两个相等
        Integer m = 1;  //底层 Integer.valueOf(1);    -->     阅读源码
        Integer n = 1;  //底层 Integer.valueOf(1);
        System.out.println(m == n);     //true

        /*
        如果i在 IntegerCache.low ~ IntegerCache.high，就直接从缓冲数组返回
        如果不在 -128~127，就直接new Integer(i)
         @HotSpotIntrinsicCandidate
        public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }
         */

        //这里要看范围：如果值在 -128~127，就是直接返回值，超出范围就是创建对象
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);     //false
    }
}
