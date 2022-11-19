package com.chy.bignum;

import java.math.BigDecimal;

public class BigDecimal01 {
    public static void main(String[] args) {
        //当我们需要保存一个精度很高的数时，double 不够用
        //double d = 1.344332432432432432432432432;
        //System.out.println(d);

        BigDecimal bigDecimal = new BigDecimal("12.45461321231345341546545");
        BigDecimal bigDecimal1 = new BigDecimal("12.1");
        System.out.println(bigDecimal);

        //如果对BigDecimal进行运算，比如加减乘除，需要使用对应的方法
        //创建一个需要操作的 BigDecimal 然后调用相应的方法即可
        //System.out.println(bigDecimal+12.32);     //ERROR
        System.out.println(bigDecimal.add(bigDecimal1));
        System.out.println(bigDecimal.subtract(bigDecimal1));
        System.out.println(bigDecimal.multiply(bigDecimal1));
        //System.out.println(bigDecimal.divide(bigDecimal1));     //可能抛出异常Arithmetic
        //在调用divide 方法时，指定精度即可
        //如果有无限循环小数，就会保留 分子 的精度
        System.out.println(bigDecimal.divide(bigDecimal1,BigDecimal.ROUND_CEILING));
    }
}
