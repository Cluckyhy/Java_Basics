package com.chy.innerclass_.innerclass.static_innerclass;

public class StaticInnerClass01 {
    public static void main(String[] args) {
        /*
        静态内部类的使用：
            说明：静态内部类是定义在外部类的成员位置上，并且有static修饰
            1、可以直接访问外部类的所有静态成员，包含私有的，但不能直接访问非静态成员
            2、可以添加任意访问修饰符(public protected 默认 private)因为它的地位就是一个成员
            3、作用域：同其他的成员，为整个类体
            4、静态内部类 -->  访问 -->  外部类(比如：静态属性)[访问方式：直接访问所有静态成员]
            5、外部类 -->  访问  -->  静态内部类  [访问访问：创建对象，再访问]
            6、外部其他类 --> 访问 -->  静态内部类
            7、如果外部类和静态内部类的成员重名时，静态内部类访问时，默认遵循就近原则，如果想访问外部类的成员，则可以使用(外部类名.成员)访问
         */
        Outer outer = new Outer();
        outer.show();

        //外部其他类，访问静态内部类
        //方式1
        //因为静态内部类，是可以通过类名直接访问(前提是满足访问权限)
        Outer.Inner inner = new Outer.Inner();
        inner.say();
        //方式2
        //编写一个方法，可以返回静态内部类的对象实例
        Outer.Inner inner1 = outer.getInner();
        System.out.println("-----------------");
        inner1.say();
        //方式3
        Outer.Inner inner_ = Outer.getInner_();
        System.out.println("****************");
        inner_.say();
    }
}

class Outer{    //外部类
    private int n1 = 10;
    private static String name = "张三";
    private static void cry(){
        System.out.println("外部类的cry()方法");
    }
    //Inner是一个静态内部类
    //1、放在外部类的成员位置
    //2、使用static修饰
    static class Inner{
        private static String name = "陈慧亿";
        public void say(){
            System.out.println(name);
            System.out.println("外部类的静态成员\t"+Outer.name);
            //不能直接访问外部类的非静态成员
            //System.out.println(n1);
            Outer.cry();
            cry();
        }
        public void cry(){
            System.out.println("静态内部类的cry()方法");
        }
    }
    public void show(){
        Inner inner = new Inner();
        inner.say();
    }
    public Inner getInner(){
        Inner inner = new Inner();
        return inner;
    }

    public static Inner getInner_(){
        return new Inner();
    }
}


