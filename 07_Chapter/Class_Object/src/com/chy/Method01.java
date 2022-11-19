package com.chy;

public class Method01 {
    public static void main(String[] args) {
        //实例化一个对象
        People p1 = new People();
        //当程序执行到方法时，就会开辟一个独立的空间（栈空间）
        //当方法执行完毕，或者执行到return语句时，就会返回
        //返回到调用方法的地方
        //返回后，继续执行方法后面的代码
        p1.speak();
        p1.cal01();
        p1.cal02(10);
        p1.cal02(100);
        int res = p1.getSum(28, 48);
        System.out.println("两个数的和为：" + res);
    }
}

class People {
    //成员属性
    String name;
    int age;

    //成员方法
    //public 表示该方法是公开的
    //void 表示方法没有返回值
    //speak 方法名
    //()    形参列表
    public void speak() {
        System.out.println("我是一个好人");
    }

    public void cal01() {
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sum += i;
        }
        System.out.println("计算结果是：" + sum);
    }

    public void cal02(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("1+2+..." + n + "的计算结果为：" + sum);
    }

    public int getSum(int num1, int num2) {
        int res = num1 + num2;
        return res;
    }


}
