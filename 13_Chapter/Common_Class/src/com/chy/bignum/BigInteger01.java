package com.chy.bignum;

import java.math.BigInteger;

public class BigInteger01 {
    public static void main(String[] args) {
        //当我们编程中，需要处理很大的整数，long不够用
        //long l = 32323242323233332;
        //System.out.println("l = " + l);

        BigInteger bigInteger = new BigInteger("23235656565656565566");
        BigInteger bigInteger1 = new BigInteger("100");
        System.out.println(bigInteger);
        //在对 BigInteger 进行加减乘除的时候，需要使用对应的方法，不能直接进行 + - * /
        //可以创建一个 要操作的 BigInteger 然后进行相应的操作
        BigInteger add = bigInteger.add(bigInteger1);
        System.out.println(add);
        BigInteger mul = bigInteger.multiply(bigInteger1);
        System.out.println(mul);
        BigInteger sub = bigInteger.subtract(bigInteger1);
        System.out.println(sub);
    }
}
