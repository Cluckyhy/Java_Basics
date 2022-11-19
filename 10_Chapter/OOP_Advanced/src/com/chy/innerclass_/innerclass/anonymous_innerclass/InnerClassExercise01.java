package com.chy.innerclass_.innerclass.anonymous_innerclass;

public class InnerClassExercise01 {
    public static void main(String[] args) {
        //匿名内部类可以直接当做实参来进行传递
        f1(new IL(){
            @Override
            public void show() {
                System.out.println("这是一副名画~~...");
            }
        });

        //传统的方法
        f1(new Picture());
    }

    //静态方法  形参是接口类型
    public static void f1(IL il){
        il.show();
    }
}

//接口
interface IL{
    void show();
}

//类--> 实现IL (硬编码)
class Picture implements IL{
    @Override
    public void show() {
        System.out.println("这是一副名画...");
    }
}
