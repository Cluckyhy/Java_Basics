package com.chy.interface_.extends_vs_interface;

public class ExtendsVsInterface {
    public static void main(String[] args) {

        /*
        * 实现接口 vs 继承类
        * 接口和继承解决的问题不同
        *
        * 继承的价值主要在于：解决代码的复用性和可维护性
        * 接口的价值主要在于：设计，设计好各种规范(方法)，让其他类去实现这些方法，即更加的灵活。
        *
        * 接口比继承更加灵活
        *
        * 接口比继承更加灵活，继承是满足 is a 的关系，而接口只需要满足 like a 的关系
        *
        * 接口在一定程度上实现代码解耦
        * */
        LitterMonkey wukon = new LitterMonkey("Wukon");
        wukon.climbing();
        wukon.swimming();
        wukon.flying();
    }
}
