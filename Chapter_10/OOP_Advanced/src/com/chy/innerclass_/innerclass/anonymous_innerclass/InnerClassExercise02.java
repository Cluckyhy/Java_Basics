package com.chy.innerclass_.innerclass.anonymous_innerclass;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        //测试手机类的闹钟功能
        Cellphone cellphone = new Cellphone();
        //传递的是实现了 Bell接口的匿名内部类
        //重写了ring
        cellphone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了...");
            }
        });
        cellphone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴们开始上课了...");
            }
        });
    }
}

//铃声接口
interface Bell {
    void ring();
}

//手机类
class Cellphone {
    public void alarmclock(Bell bl) {
        System.out.println(bl.getClass());
        bl.ring();  //动态绑定
    }
}
