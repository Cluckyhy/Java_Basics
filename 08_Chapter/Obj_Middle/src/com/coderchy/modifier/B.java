package com.coderchy.modifier;

public class B {
    public void say() {
        A a = new A();
        //在同一个包下，可以访问 public  protected 默认  不能访问private属性
        System.out.println("n1 = " + a.n1 + " n2 = " + a.n2 + " n3 = " + a.n3);
    }
}
