package com.homewoek_;

public class Homework05 {
    public static void main(String[] args) {
        System.out.println("我是Homework05");
    }
}

class Test {
    String name = "Rose";   //Chy

    public Test() {
        System.out.println("Test");
    }

    public Test(String name) {
        this.name = name;
    }
}

class Demo extends Test {
    String name = "Jack";

    public Demo() {
        super();
        System.out.println("Demo");
    }

    public Demo(String name) {
        super(name);
    }

    public void test() {
        System.out.println(super.name);
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        new Demo().test();//匿名对象
        new Demo("Chy").test();//匿名对象
        /*
            Test
            Demo
            Rose
            Jack
          --------
            Chy
            Jack
        */
    }
}
