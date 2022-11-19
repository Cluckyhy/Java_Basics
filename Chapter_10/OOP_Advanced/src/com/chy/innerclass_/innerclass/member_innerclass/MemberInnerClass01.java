package com.chy.innerclass_.innerclass.member_innerclass;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        /*
        成员内部类的使用：
            说明：成员内部类是定义在外部类的成员位置，并且没有static修饰
            1、可以直接访问外部类的所有成员，包含私有
            2、可以添加任意访问修饰符(public protected 默认 private)，因为它的地位就是一个成员
            3、作用域和外部类的其他成员一样，为整个类体。比如前面案例，在外部类的成员方法中创建成员内部类对象，再调用方法
            4、成员内部类 --> 访问 -->  外部类(比如：属性)[访问方式：直接访问]
            5、外部类 --> 访问 -->  成员内部类[访问方式：创建对象，再访问]
            6、外部其他类 -->  访问 -->  成员内部类
            7、如果外部类和内部类的成员重名时，内部类访问的话，默认遵循就近原则，如果想访问外部类的成员，则可以使用(外部类名.this.成员)访问
         */
        Outer outer = new Outer();
        outer.f1();

        //外部其他类使用成员内部类的三种方式
        //第一种方式：
        //outer.new Inner(); 相当于把 new Inner()当做是outer的成员
        //这就是一个语法，不用特别纠结
        Outer.Inner inner = outer.new Inner();
        inner.say();

        //第二种方式：本质和第一种是一样的
        Outer.Inner inner2 = new Outer().new Inner();

        //第三种方式：
        //在外部类中，编写一个方法，可以返回 Inner对象
        Outer.Inner inner1 = outer.getInner();
        inner1.say();

    }
}

class Outer {    //外部类
    private int n1 = 10;
    public String name = "张三";

    private void hi() {
        System.out.println("hi");
    }

    //成员内部类，是定义在外部内的成员位置上
    class Inner {
        private double sal = 99.9;
        private int n1 = 66;

        public void say() {
            //可以直接访问外部类的所有成员，包含私有
            //如果成员内部类和外部类的成员重名，会遵循就近原则
            //可以通过  外部类名.this.属性 来访问外部类的成员
            System.out.println("Outer的n1= " + n1 + "\tOuter的name=" + name);
            System.out.println("外部类的n1 = " + Outer.this.n1);
            hi();
        }
    }

    //该方法，返回一个Inner实例
    public Inner getInner() {
        Inner inner = new Inner();
        return inner;
    }

    //成员方法
    public void f1() {
        //使用了成员内部类
        //创建成员内部类的对象，然后使用相关的方法/属性
        Inner inner = new Inner();
        inner.say();
        System.out.println(inner.sal);
    }
}
