package com.poly_.detail_;

public class PolyDetail {
    public static void main(String[] args) {
        //向上转型：父类的引用指向了子类对象
        //语法：父类类型的引用名 = new 子类类型();
        //
        Animal animal = new Cat();
        Object obj = new Cat();


        //向上转型调用方法的规则如下：
        //可以调用父类中的所有成员(需要遵守访问权限)
        //但是不能调用子类的特有成员
        //因为在编译阶段，能调用哪些成员，是由编译类型来决定的
        //最终的运行效果要看子类(运行类型)的具体实现，即调用方法时，按照从子类开始查找方法
        //然后调用，规则和前面介绍的jvm继承的内存布局一样
        animal.eat();
        animal.show();
        animal.run();
//        obj.eat();

        //此时要求调用Cat的 catchMouse方法
        //多态的向下转型
        //语法：
            //子类类型  引用名 = (子类类型) 父类引用
            //特别重要的要求：
            //要求父类的引用必须指向的是当前目标类型的对象
            //只能强转父类的引用，不能强转父类的对象
            //当向下转型后，可以调用子类类型中的所有成员

        //cat 的编译类型 Cat, 运行类型也是 Cat
        Cat cat = (Cat)animal;
        cat.catchMouse();

        animal = new Dog();
        Dog dog = (Dog) animal;
        dog.eat();
    }
}
