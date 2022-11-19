package com.chy.final_;

public class FinalDetail01 {
    public static void main(String[] args) {
        /*
        *  1、final修饰的属性又叫常量，一般都用大写字母命名 XXX_XXX_XXX
        *  2、final修饰的属性在定义时，必须赋初值，并且以后不能修改
        *  3、如果final修饰的是普通属性，赋值可以如下：
        *       3.1、定义时直接赋值
        *       3.2、在构造器中
        *       3.3、在普通代码块中
        *  4、如果final修饰的是静态属性，则初始化的位置只能是：
        *       4.1、定义时直接赋值
        *       4.2、在静态代码块中，不能在构造器中赋值了
        *  5、final类不能继承，但是可以实例化对象
        *  6、如果类不是final类，但是含有final方法，则该方法虽然不能重写，但是可以被继承
        * */

        CC cc = new CC();
        EE ee = new EE();
        ee.cal();
    }
}

class AA{
    /*
    * final必须要付初值：
    *   1、可以在定义时：public final double TAX_RATE = 0.08;
    *   2、在构造器中
    *   3、在代码块中
    *
    * */
    //直接定义时赋值
    public final double TAX_RATE = 0.08;
    public final double TAX_RATE2;
    public final double TAX_RATE3;

    //在构造器中赋值
    public AA(){
        TAX_RATE2 = 0.01;
    }

    //在代码块中赋值
    {
        TAX_RATE3 = 0.02;
    }
}

class BB{
    //如果final修饰的属性是静态的，则初始化的位置只能是
    //  1、定义时
    //  2、在静态代码块中，而不能在构造函数中赋值了
    //final修饰的静态属性，必须在类加载的时候赋值，也就是说在类加载时，final修饰的静态值必须要有值

    //直接在定义时赋值
    public static final double TAX_RATE1 = 99.9;
    public static final double TAX_RATE2;
    //public static final double TAX_RATE3;

    //public BB(){
    //    TAX_RATE3 = 2.2;
    //}

    static{
        TAX_RATE2 = 3.3;
    }
}

//final类不能继承，但是可以实例化的
final class CC{

}

//如果类不是final类，但是含有final方法，则该方法虽然不能重写，但是可以被继承
//即，仍然遵守继承的机制
class DD{
    public final void cal(){
        System.out.println("cal()方法");
    }
}

class EE extends DD{

}
