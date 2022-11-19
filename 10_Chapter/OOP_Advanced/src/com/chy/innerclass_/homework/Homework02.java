package com.chy.innerclass_.homework;

public class Homework02 {
    public static void main(String[] args) {
        A a = new A();
        a.f1();
    }
}

class A {
    private String NAME = "hello";

    public void f1() {
        class B {
            private final String NAME = "陈慧亿";

            public void show() {
                //如果内部类和外部类的属性重名。可以通过外部类名.this.成员
                System.out.println("姓名：" + NAME + A.this.NAME);
            }
        }
        B b = new B();
        b.show();
    }
}
