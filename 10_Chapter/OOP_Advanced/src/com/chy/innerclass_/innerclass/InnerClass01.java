package com.chy.innerclass_.innerclass;

public class InnerClass01 {     //外部其他类
    public static void main(String[] args) {
        Outer outer = new Outer(100);
    }
}

class Outer{        //外部类
    private int n1 = getVal01();//属性
    private void m1(){}//方法

    public Outer(int n1) {
        //隐藏了
        //这其实，会伴随着类的加载，执行静态代码块和属性的相关操作
        //super();
        //普通代码块和属性
        this("拉拉");
        System.out.println("有参构造方法执行...");
        this.n1 = n1;
    }
    public Outer(String name){
        System.out.println("String 参数的构造器执行...");
    }
    public int getVal01(){
        System.out.println("getVal01()执行...");
        return 100;
    }
    //代码块
    {
        System.out.println("代码块...");
    }
    //内部类，在Outer类的内部
    class Car{
        
    }

}
