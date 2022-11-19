package com.chy.innerclass_.innerclass.local_innerclass;

/*
 * 演示局部内部类的使用
 *
 * 记住：
 *      (1)局部内部类必须定义在方法中或代码块中
 *      (2)局部内部类的作用域在方法中或代码块中
 *      (3)局部内部类的本质还是类
 * */

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        outer01.m1();
        System.out.println("Outer01的hashcode = "+outer01);
    }
}

class Outer01 {        //外部类
    private int n1 = 100;

    private void m2() {
        System.out.println("Outer01的m2()方法执行...");
    }   //私有方法

    //6、外部其他类或出了方法的其他位置，都无法访问局部内部类(因为 局部内部类地位是一个局部变量)
    //Inner01 n = new Inner01();

    public void m1() {   //方法
        //1、局部内部类是定义在外部类的局部位置上，通常是在方法中
        //3、不能添加访问修饰符，因为它的地位就是一个局部变量，局部变量是不能使用修饰符的，但是可以使用final修饰，因为局部变量也可以使用final
        //4、作用域：仅仅在定义它的方法或代码块中
        final class Inner01 {  //局部内部类
            //2、可以直接方法外部类的所有成员，包含私有的
            private int n1 = 800;

            public void f1() {
                //5、局部内部类可以直接访问外部类的成员，比如下面 外部类的n1 和 m2()
                //7、如果外部类的和局部内部类的成员重名时，默认遵循就近原则，
                //   如果想访问外部类的成员，使用(外部类名.this.成员)去访问
                //   这里的Outer01.this 本质就是外部类的对象，即哪个对象调用了m1()，Outer01.this就指向哪个对象
                System.out.println("n1 = " + n1);   //就近原则，输出800
                System.out.println("外部类中的n1 = " + Outer01.this.n1); //通过 外部类名.this.成员访问外部类重名属性
                System.out.println("Outer01.this hashcode = "+Outer01.this);

                m2();
            }
        }
        //6、外部类在方法中，可以创建Inner01对象，然后调用方法即可(注意：必须在作用域内！！！)
        Inner01 inner01 = new Inner01();
        inner01.f1();
        //class Inner02 extends Inner01{
        //
        //}
    }

    {
        //代码块
        class Inner01 {

        }
    }
}
