package com.chy.innerclass_.homework;

public class Homework01 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new ICalculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        }, 12, 3);
        cellphone.testWork(new ICalculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 * n2;
            }
        }, 3, 4);
    }
}

//定义一个接口
interface ICalculate {
    double work(double n1, double n2);
}

class Cellphone {
    public void testWork(ICalculate iCalculate, double n1, double n2) {
        double result = iCalculate.work(n1, n2);
        System.out.println("计算结果为：" + result);
    }
}
