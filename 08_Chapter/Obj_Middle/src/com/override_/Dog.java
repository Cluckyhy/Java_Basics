package com.override_;

public class Dog extends Animal{
    @Override
    //因为Dog 是 Animal 的子类
    //Dog 的 cry方法和Animal的cry定义形式一样(名称，返回类型，参数)
    //这时我们就说 Dog的cry方法，重写了Animal的cry方法
    public void cry() {
        super.cry();
        System.out.println("小狗在汪汪叫...");
    }

    //子类的方法的形参列表，方法名称，要和父类方法的形参列表，方法名称完全一样
    //子类的返回类型和父类方法返回类型一样，或者是父类返回类型的子类
    //比如，父类返回类型是Object，子类方法返回类型是String，这样是允许的
    //public > protected > 默认 > private
//    public AAA f1(){
//        return null;
//    }
    public BBB f1(){
        return null;
    }

    //子类方法不能缩小父类方法的访问权限
    protected void eat(){

    }
}
