package com.coderchy.pkg;

import com.coderchy.modifier.A;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        //在不同的包下，可以访问public 修饰的属性或方法
        //但是不能访问 protected , 默认 ， private
        System.out.println(a.n1);
    }
}
