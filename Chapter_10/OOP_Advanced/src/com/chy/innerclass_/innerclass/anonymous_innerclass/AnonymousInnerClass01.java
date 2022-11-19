package com.chy.innerclass_.innerclass.anonymous_innerclass;

/*
 * 演示匿名内部类的使用
 *  涉及(1)继承 (2)多态 (3)动态绑定 (4)内部类
 * */
public class AnonymousInnerClass01 {
    public static void main(String[] args) {
        /*
         * 匿名内部类的使用：
         *   (1)本质是类
         *   (2)内部类
         *   (3)该类没有名字(其实有名字，但是我们看不到，是系统分配的)
         *   (4)同时还是一个对象
         * 说明：匿名内部类是定义在外部类的局部位置，比如方法中，并且没有类名
         *   1、匿名内部类的基本语法：
         *   new 类(参数列表)或接口{
         *       类体
         *   }
         * */

        Outer outer = new Outer();
        outer.method();
    }
}

class Outer {        //外部类
    private int n1 = 10;    //属性

    public void method() {   //方法
        //1、基于接口的匿名内部类
        //  需求：想使用IA接口，并创建对象
        //  传统方法，是写一个类，实现接口，并创建对象
        //  需求是，Tiger/Dog 类只使用一次，后面就再不使用
        //  可以使用匿名内部类来简化开发
        //  tiger的编译类型  ?   IA
        //  tiger的运行类型  ?   就是匿名内部类 XXX ==> Outer$1

        /*
           我们看底层
           class XXX implements IA{
             @Override
             public void cry() {
             System.out.println("老虎叫唤...");
             }
          }

        */
        //  jdk底层在创建匿名内部类 Outer$1，立即马上就创建了一个 Outer$1 的实例，并且把地址返回给了tiger
        //  匿名内部类使用一次，就不能再使用了

        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("老虎叫唤...");
            }
        };
        tiger.cry();
        tiger.cry();
        tiger.cry();
        System.out.println("tiger的运行类型 = "+tiger.getClass());

        //IA tiger =  new Tiger();
        //tiger.cry();
        //IA dog = new Dog();
        //dog.cry();

        //2、基于类的匿名内部类
        //  father编译类型 Father
        //  father运行类型 Outer$2
        //  底层会创建匿名内部类
        /*
            class Outer$2 extends Father{
                @Override
                public void test() {
                    System.out.println("匿名内部类重写了test()方法");
                }
            }
         */
        //  同时也直接返回了 匿名内部类 Outer$2的对象
        //  注意('jack')  参数列表会传递给 构造器
        Father father = new Father("jack"){
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test()方法");
            }
        };
        System.out.println("father对象的运行类型 = "+father.getClass());
        father.test();

        //Father father1 = new Father("Rose");
        //System.out.println("father对象的运行类型 = "+father1.getClass());    //Father


        //基于抽象类的匿名内部类
        Animal animal = new Animal(){
            @Override
            void eat() {
                System.out.println("小狗吃骨头");
            }
        };
        System.out.println(animal.getClass());
        animal.eat();
    }
}

interface IA {
    public void cry();
}

//class Tiger implements IA{
//    @Override
//    public void cry() {
//        System.out.println("老虎叫唤...");
//    }
//}

//class Dog implements IA{
//    @Override
//    public void cry() {
//        System.out.println("小狗汪汪叫...");
//    }
//}

class Father {   //类
    public Father(String name) {     //构造器
        System.out.println("接收到了name = "+name);
    }

    public void test() {     //方法

    }
}

abstract class Animal{
    abstract void eat();
}

